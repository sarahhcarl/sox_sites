##Implementation of Alan Moses' affinity-based model of selection on TF binding sites

#Currently takes alignments for every site which is present in node 1, regardless of whether it is present in all descendants.
#Excludes alignments with any gaps.

library(Biostrings)

# Define background frequences of A, C, T and G (in this case, background Drosophila noncoding frequences from RSAT)
bg_freqs <- matrix(c(0.30319,0.20103,0.19882,0.29697), nrow=1, ncol=4, byrow=TRUE, dimnames=list(c("Frequency"), c("A", "C", "G", "T")))

# Define PWMs for sites of interest 
D_matrix <- matrix(c(0.001,0.569,0.264,0.166, 0.007,0.797,0.071,0.125, 0.435,0.067,0.062,0.436, 0.001,0.001,0.057,0.941, 0.209,0.001,0.001,0.789, 0.001,0.001,0.997,0.001, 0.001,0.001,0.001,0.997, 0.125,0.199,0.235,0.441), nrow=8, ncol=4, byrow=TRUE, dimnames= list(c("1", "2", "3", "4", "5", "6", "7", "8"), c("A", "C", "G","T")))
SoxN_matrix <- matrix(c(0.355,0.217,0.274,0.155, 0.208,0.213,0.521,0.058, 0.253,0.284,0.399,0.064, 0.805,0.087,0.107,0.001, 0.304,0.614,0.001,0.081, 0.997,0.001,0.001,0.001, 0.997,0.001,0.001,0.001, 0.838,0.001,0.001,0.160, 0.312,0.082,0.502,0.104, 0.001,0.001,0.965,0.033), nrow=10, ncol=4, byrow=TRUE, dimnames= list(c("1", "2", "3", "4", "5", "6", "7", "8", "9", "10"), c("A", "C", "G","T")))

# Define which PWM model to use
f <- SoxN_matrix

# Make a data frame to hold everything
dS_data <- data.frame(Name=character(),
                      Start=integer(),
                      dS=double(),
                      stringsAsFactors=FALSE)

#Definition of find_subst function
find_subst <- function(col, dS_total, dS_counter, dS_data, enhancer, startcoord) {
  node1_nt <- as.character(node1[col])
  mel_nt <- as.character(mel[col])
  sim_nt <- as.character(sim[col])
  
  if (sim_nt != node1_nt) {
    nt1 <- node1_nt
    nt2 <- sim_nt
    pos <- col
    dS <- calc_dS(nt1, nt2, pos, bg_freqs, f)
    dS_data <- rbind(dS_data, data.frame(Name=enhancer, Start=startcoord, dS=dS))
    dS_total <- dS_total + dS
    dS_counter <- dS_counter + 1
  }
  if (mel_nt != node1_nt) {
    nt1 <- node1_nt
    nt2 <- mel_nt
    pos <- col
    dS <- calc_dS(nt1, nt2, pos, bg_freqs, f)
    dS_data <- rbind(dS_data, data.frame(Name=enhancer, Start=startcoord, dS=dS))
    dS_total <- dS_total + dS
    dS_counter <- dS_counter + 1
  }
  dS_list <- c(dS_total, dS_counter)
  if (dS_total == 0) {
    cat(myfile, file="SoxN_node1_nochange.txt", sep=" ", fill=TRUE, append=TRUE)
  }
  return(dS_data)
}  

#Definition of calc_dS function
calc_dS <- function(nt1, nt2, pos, bg_freqs, f) {
  g_nt1 <- bg_freqs[, nt1]
  g_nt2 <- bg_freqs[, nt2]
  f_nt1 <- f[pos, nt1]
  f_nt2 <- f[pos, nt2]
  dS <- log(f_nt2/g_nt2) - log(f_nt1/g_nt1)
  return(dS)
}

# Read in alignments, store as biostrings

files <- list.files(path="/home/sarah/utilities/play-1.2.7/sox_sites/analysis/Sequences/site_alignments/SoxN_node1", pattern=".fasta", all.files=T, full.names=T)
for (myfile in files) {
  #print(myfile)
  enhancer <- sub(".*SoxN_node1/(.*)\\.(.*)\\..*", "\\1", myfile)
  startcoord <- sub(".*SoxN_node1/(.*)\\.(.*)\\..*", "\\2", myfile)
  con <- file(myfile)
  alignment <- readLines(con)
  
  gap1 <- grepl("-", alignment[3])
  gap_mel <- grepl("-", alignment[5])
  gap_sim <- grepl("-", alignment[7])
 
  n1 <- grepl("N", alignment[3])
  n_mel <- grepl("N", alignment[5])
  n_sim <- grepl("N", alignment[7])
  
  if ((gap1 == TRUE) | (gap_mel == TRUE) | (gap_sim == TRUE)) {
    cat(myfile, file="all_SoxN_node1_gaps.txt", sep=" ", fill=TRUE, append=TRUE)
    cat("Gaps detected", file="all_SoxN_node1_gaps.txt", sep=" ", fill=TRUE, append=TRUE)
    close(con)
  } 
  else if ((n1 == TRUE) | (n_mel == TRUE) | (n_sim == TRUE)) {
    cat(myfile, file="all_SoxN_node1_n.txt", sep=" ", fill=TRUE, append=TRUE)
    cat("N detected", file="all_SoxN_node1_n.txt", sep=" ", fill=TRUE, append=TRUE)
    close(con)
  }
  else if ((gap1 == FALSE) & (gap_mel == FALSE) & (gap_sim == FALSE) & (n1 == FALSE) & (n_mel == FALSE) & (n_sim == FALSE)) {

    node1 <- DNAString(alignment[3])
    mel <- DNAString(alignment[5])
    sim <- DNAString(alignment[7])
    
    # If strand = R, take reverse complement
    if (alignment[1] == "R") {
      node1 <- reverseComplement(node1)
      mel <- reverseComplement(mel)
      sim <- reverseComplement(sim)
    }
    
    
    # Identify substitutions
    
    #For each position, get all the values of dS for any substitution at that position, add them to a list, then repeat, always appending values to the same list.
    dS_total <- 0
    dS_counter <- 0
    for (col in 1:length(mel)) {
      dS_data <- find_subst(col, dS_total, dS_counter, dS_data, enhancer, startcoord)
      dS_total <- dS_list[1] + dS_total
      dS_counter <- dS_list[2] + dS_counter
    }
    
    dS_avg = dS_total / dS_counter
    close(con)
  }  
}  

# Calculate dS for each substitution where a directional change can be identified
# Take average dS for alignment(s)
# Perform Z-test against E[S] statistic

enhancer_pvalues <- data.frame(Name=character(),
                               Z=double(),
                               p=double(),
                               stringsAsFactors=FALSE)

site_pvalues <- data.frame(Name=character(),
                           Start=integer(),
                           Z=double(),
                           p=double(),
                           stringsAsFactors=FALSE)

enhancers <- unique(dS_data$Name, )

for (e in enhancers) {
  E_dS <- -3.06467162201556  #SoxN
  V_dS <-  8.71182428167666  #SoxN 
  #E_dS <- -3.71980334172789  #D
  #V_dS <- 9.06507252807775   #D
  enhancer <- dS_data[dS_data$Name==e, ]
  sites <- unique(enhancer$Start, )
  for (s in sites) {
    site <- enhancer[enhancer$Start==s, ]
    Ns <- nrow(site)
    site_sum <- 0
    for (ks in 1:Ns) {
      site_sum = (site[ks, 3] - E_dS) + site_sum
    }
    Zs <- ((1/Ns)*site_sum)/sqrt(V_dS/Ns)
    p_site <- pnorm(Zs, lower.tail=FALSE)
    site_pvalues <- rbind(site_pvalues, data.frame(Name=e, Start=s, Z=Zs, p=p_site))
  }
  N <- nrow(enhancer)
  sum <- 0
  for (k in 1:N) {
    sum = (enhancer[k, 3] - E_dS) + sum
  }
  Z <- ((1/N)*sum)/sqrt(V_dS/N)
  p <- pnorm(Z, lower.tail=FALSE)
  enhancer_pvalues <- rbind(enhancer_pvalues, data.frame(Name=e, Z=Z, p=p))
}