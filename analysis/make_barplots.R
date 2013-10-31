Dichaete_matrix <- matrix(data = c(1102/1815,183/1815,269/1815,261/1815, 1774/2975,301/2975,457/2975,443/2975, 1499/2722,272/2722,486/2722,465/2722), nrow=3, ncol=4, byrow=TRUE,
       dimnames = list(c("Dunique", "SoxNunique", "Common"),
                       c("1 species", "2 species", "3 species", "4 species")))

SoxN_matrix <- matrix(data= c(2453/3730,453/3730,528/3730,296/3730, 4651/6914,758/6914,973/6914,532/6914, 3763/5791,674/5791,869/5791,485/5791), nrow=3, ncol=4, byrow=TRUE,
                      dimnames = list(c("Dunique", "SoxNunique", "Common"),
                                      c("1 species", "2 species", "3 species", "4 species")))

D_transcomp <- matrix(data = c(343/636,62/636,115/636,116/636, 2904/4828,486/4828,724/4828,714/4828), nrow=2, ncol=4, byrow=TRUE,
                      dimnames = list(c("Transcompensation", "No transcompensation"),
                                      c("1 species", "2 species", "3 species", "4 species")))

SoxN_transcomp <- matrix(data = c(915/1439,150/1439,237/1439,137/1439, 7158/10668,1203/10668,1488/10668,819/10668), nrow=2, ncol=4, byrow=TRUE,
                         dimname = list(c("Transcompensation", "No transcompensation"),
                                        c("1 species", "2 species", "3 species", "4 species")))

D_dhs <- matrix(data = c(228/2019,335/2019,722/2019,734/2019, 196/1333,247/1333,455/1333,435/1333), nrow=2, ncol=4, byrow=TRUE,
                dimnames = list(c("In DHS", "Not in DHS"),
                               c("1 species", "2 species", "3 species", "4 species")))

SoxN_dhs <- matrix(data = c(646/3760,877/3760,1402/3760,835/3760, 492/2455,561/2455,924/2455,478/2455), nrow=2, ncol=4, byrow=TRUE,
                   dimnames = list(c("In DHS", "Not in DHS"),
                                   c("1 species", "2 species", "3 species", "4 species")))


##barplot(SoxN_matrix, beside=TRUE, col=newpal[6:4], ylab="Proportion of total sites", legend.text=c("Dichaete only", "SoxN only", "Common"), args.legend=(list(x=5, y=0.6)))