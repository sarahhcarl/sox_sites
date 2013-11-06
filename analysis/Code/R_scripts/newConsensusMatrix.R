## Use Biostrings to calculate a new PWM from a subset of sequences of predicted TF binding sites

library(Biostrings)

## Take the sequences from all predicted sites that are conserved in 4 species

D_4species_seqs <- D_msyp$dm_sequence
SoxN_4species_seqs <- SoxN_mysp$dm_sequence

## Convert these into DNAStringSet objects

D_strings <- DNAStringSet(D_4species_seqs)
SoxN_strings <- DNAStringSet(SoxN_4species_seqs)

## Calculate consensus matrix

D_4species_matrix <- consensusMatrix(D_strings, baseOnly=TRUE, as.prob=TRUE)
SoxN_4species_matrix <- consensusMatrix(SoxN_strings, baseOnly=TRUE, as.prob=TRUE)