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

D_hom <- matrix(data = c(24/59,6/59,9/59,20/59, 184/384,40/384,79/384,81/384, 4273/7281,728/7281,1162/7281,1118/7281), nrow=3, ncol=4, byrow=TRUE,
                dimnames = list(c("Overlap", "Proximal", "Distal"),
                                c("1 species", "2 species", "3 species", "4 species")))

SoxN_hom <- matrix(data = c(1665/2500,331/2500,365/2500,139/2500, 658/1142,116/1142,224/1142,144/1142, 9671/14555,1651/14555,2069/14555,1164/14555), nrow=3, ncol=4, byrow=TRUE,
                   dimnames = list(c("Overlap", "Proximal", "Distal"),
                                   c("1 species", "2 species", "3 species", "4 species")))

D_het <- matrix(data = c(433/674,72/674,109/674,60/674, 483/854,89/854,138/854,144/854, 3459/5984,595/5984,965/5984,965/5984), nrow=3, ncol=4, byrow=TRUE,
                dimnames = list(c("Overlap", "Proximal", "Distal"),
                                c("1 species", "2 species", "3 species", "4 species")))

SoxN_het <- matrix(data = c(2748/3967,542/3967,536/3967,141/3967, 1087/1685,213/1685,259/1685,126/1685, 7032/10783,1130/10783,1575/10783,1046/10783), nrow=3, ncol=4, byrow=TRUE,
                    dimnames = list(c("Overlap", "Proximal", "Distal"),
                                   c("1 species", "2 species", "3 species", "4 species")))

D_SoxN <- matrix(data = c(262/428,58/428,70/428,38/428, 426/783,85/783,133/783,139/783, 3687/6301,613/6301,1009/6301,992/6301), nrow=3, ncol=4, byrow=TRUE,
                 dimnames = list(c("Overlap","Proximal", "Distal"),
                                 c("1 species", "2 species", "3 species", "4 species")))

SoxN_D <- matrix(data = c(293/442,64/442,64/442,21/442, 551/875,98/875,157/875,69/875, 10023/15118,1723/15118,2149/15118,1223/15118), nrow=3, ncol=4, byrow=TRUE,
                 dimnames = list(c("Overlap", "Proximal", "Distal"),
                                 c("1 species", "2 species", "3 species", "4 species")))

D_vnd <- matrix(data = c(77/105,11/105,9/105,8/105, 112/179,16/179,31/179,20/179, 3459/5984,595/5984,965/5984,965/5984), nrow=3, ncol=4, byrow=TRUE,
                dimnames = list(c("Overlap", "Proximal", "Distal"),
                                c("1 species", "2 species", "3 species", "4 species")))

D_Kr <- matrix(data = c(377/571,61/571,100/571,52/571, 377/685,74/685,108/685,126/685, 3459/5984,595/5984,965/5984,965/5984), nrow=3, ncol=4, byrow=TRUE,
               dimnames = list(c("Overlap", "Proximal", "Distal"),
                               c("1 species", "2 species", "3 species", "4 species")))

SoxN_vnd <- matrix(data = c(156/216,24/216,26/216,10/216, 264/375,37/375,53/375,21/375, 7032/10783,1130/10783,1575/10783,1046/10783), nrow=3, ncol=4, byrow=TRUE,
                   dimnames = list(c("Overlap", "Proximal", "Distal"),
                                  c("1 species", "2 species", "3 species", "4 species")))

SoxN_Kr <- matrix(data = c(2615/3778,522/3778,510/3778,131/5778, 843/1335,179/1335,207/1335,106/1335, 7032/10783,1130/10783,1575/10783,1046/10783), nrow=3, ncol=4, byrow=TRUE,
                  dimnames = list(c("Overlap", "Proximal", "Distal"),
                                  c("1 species", "2 species", "3 species", "4 species")))

SoxN_prox <- matrix(data = c(658/1142,116/1142,224/1142,144/1142, 551/875,98/875,157/875,69/875, 264/375,37/375,53/375,21/375, 843/1335,179/1335,207/1335,106/1335), nrow=4, ncol=4, byrow=TRUE,
                    dimnames = list(c("Homotypic", "Het Sox", "Het vnd", "Het Kr"),
                                    c("1 species", "2 species", "3 species", "4 species")))

D_prox <- matrix(data= c(184/384,40/384,79/384,81/384, 426/783,85/783,133/783,139/783, 112/179,16/179,31/179,20/179, 377/685,74/685,108/685,126/685), nrow=4, ncol=4, byrow=TRUE,
                  dimnames = list(c("Homotypic", "Het Sox", "Het vnd", "Het Kr"),
                  c("1 species", "2 species", "3 species", "4 species")))

##barplot(SoxN_matrix, beside=TRUE, col=newpal[6:4], ylab="Proportion of total sites", legend.text=c("Dichaete only", "SoxN only", "Common"), args.legend=(list(x=5, y=0.6)))