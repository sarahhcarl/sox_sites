D <- as.table(rbind(c(261,(242+9+6+12),(116+25+22+6+14),(117+111+246+628)), c(443,(421+13+11+12),(183+40+57+5+16),(155+182+368+1069)), c(465,(437+29+9+11),(187+26+5+38+1+15),(152+171+303+873))))
dimnames(D) <- list(binding=c("Dunique", "SoxNunique", "common"),
                    cons=c("4-species", "3-species", "2-species", "1-species"))
Dsq <- chisq.test(D)

SoxN <- as.table(rbind(c(296,(492+16+9+11),(293+46+5+66+13+30),(242+247+509+1455)), c(532,(877+53+24+19),(457+111+5+132+13+40),(501+456+1061+2633)), c(485,(792+43+20+14),(436+94+11+98+6+29),(395+385+840+2143))))
dimnames(SoxN) <- list(binding=c("Dunique", "SoxNunique", "common"),
                       cons=c("4-species", "3-species", "2-species", "1-species"))

SoxNsq <- chisq.test(SoxN)

D1 <- as.table(rbind(c(116,(101+5+3+6),(39+10+6+5+2),(43+23+70+207)), c(714,(661+24+15+24),(302+64+82+6+32),(276+311+603+1714))))
dimnames(D1) <- list(class=c("Transcomp", "NoTranscomp"),
                    cons=c("4-species", "3-species", "2-species", "1-species"))
D1sq <- chisq.test(D1)

SoxN1 <- as.table(rbind(c(137,(216+7+8+6),(80+34+1+27+1+7),(96+85+185+549)), c(819,(1361+71+30+26),(763+138+11+193+27+71),(762+709+1572+4115))))
dimnames(SoxN1) <- list(class=c("Transcomp", "NoTranscomp"),
                        cons=c("4-species", "3-species", "2-species", "1-species"))
SoxN1sq <- chisq.test(SoxN1)


##Only for sites that are in D.mel (because DHS measured in D.mel)

Ddhs <- as.table(rbind(c(734, (668+33+21),(273+58+4),228), c(435,(432+18+5),(213+33+1),196)))
dimnames(Ddhs) <- list(clas=c("DHS", "no DHS"),
                       cons=c("4-species", "3-species", "2-species", "1-species"))
Ddhssq <- chisq.test(Ddhs)

SoxNdhs <- as.table(rbind(c(835, (1300+69+33),(720+146+11),646), c(478,(861+43+20),(446+105+10),492)))
dimnames(SoxNdhs) <- list(clas=c("DHS", "no DHS"),
                       cons=c("4-species", "3-species", "2-species", "1-species"))
SoxNdhssq <- chisq.test(SoxNdhs)

D_turn<- as.table(rbind(c(619,41,47,6), c(1047,52,97,5), c(1089,64,64,6)))
dimnames(D_turn) <- list(binding=c("Dunique", "SoxNunique", "common"),
                    cons=c("0", "1/6", "1/4", "2/6"))


SoxN_turn<- as.table(rbind(c(1081,66,112,18), c(1866,136,243,18), c(1713,106,192,17)))
dimnames(SoxN_turn) <- list(binding=c("Dunique", "SoxNunique", "common"),
                         cons=c("0", "1/6", "1/4", "2/6"))

D_homotypic <- as.table(rbind(c(D_overlap_1sp, D_overlap_2sp, D_overlap_3sp, nrow(D_overlap_4sp)), c(D_prox_1sp, D_prox_2sp, D_prox_3sp, nrow(D_prox_4sp)), c(nrow(D_dist_1sp), nrow(D_dist_2sp), nrow(D_dist_3sp), nrow(D_dist_4sp))))
dimnames(D_homotypic) <- list(position=c("Overlap", "Proximal", "Distal"),
                              cons=c("1 species", "2 species", "3 species", "4 species"))

SoxN_homotypic <- as.table(rbind(c(nrow(SoxN_overlap_1sp), nrow(SoxN_overlap_2sp), nrow(SoxN_overlap_3sp), nrow(SoxN_overlap_4sp)), c(nrow(SoxN_prox_1sp), nrow(SoxN_prox_2sp), nrow(SoxN_prox_3sp), nrow(SoxN_prox_4sp)), c(nrow(SoxN_dist_1sp), nrow(SoxN_dist_2sp), nrow(SoxN_dist_3sp), nrow(SoxN_dist_4sp))))
dimnames(SoxN_homotypic) <- list(position=c("Overlap", "Proximal", "Distal"),
                                 cons=c("1 species", "2 species", "3 species", "4 species"))

D_heterotypic <- as.table(rbind(c(433,72,109,60), c(483,89,138,144), c(3459,595,965,965)))
dimnames(D_heterotypic) <- list(position=c("Overlap", "Proximal", "Dista"),
                                cons=c("1 species", "2 species", "3 species", "4 species"))

SoxN_heterotypic <- as.table(rbind(c(2748,542,536,141), c(1087,213,259,126), c(7032,1130,1575,1046)))
dimnames(SoxN_heterotypic) <- list(position=c("Overlap", "Proximal", "Distal"),
                                   cons=c("1 species", "2 species", "3 species", "4 species"))

D_SoxN <- as.table(rbind(c(262,58,70,38), c(426,85,133,139), c(3687,613,1009,992)))
dimnames(D_SoxN) <- list(position=c("Overlap", "Proximal", "Distal"),
                         cons=c("1 species", "2 species", "3 species", "4 species"))

SoxN_D <- as.table(rbind(c(293,64,64,21), c(551,98,157,69), c(10023,1723,2149,1223)))
dimnames(SoxN_D) <- list(position=c("Overlap", "Proximal", "Distal"),
                         cons=c("1 species", "2 species", "3 species", "4 species"))

D_het_vnd <- as.table(rbind(c(77,11,9,8), c(112,16,31,20), c(3459,595,965,965)))
dimnames(D_het_vnd) <- list(position=c("Overlap", "Proximal", "Distal"),
                               cons=c("1 species", "2 species", "3 species", "4 species"))

D_het_Kr <- as.table(rbind(c(358,61,100,52), c(377,74,108,126), c(3459,595,965,965)))
dimnames(D_het_Kr) <- list(position=c("Overlap", "Proximal", "Distal"),
                              cons=c("1 species", "2 species", "3 species", "4 species"))

SoxN_het_vnd <- as.table(rbind(c(156,24,26,10), c(264,37,53,21), c(7032,1130,1575,1046)))
dimnames(SoxN_het_vnd) <- list(position=c("Overlap", "Proximal", "Distal"),
                               cons=c("1 species", "2 species", "3 species", "4 species"))

SoxN_het_Kr <- as.table(rbind(c(2615,522,510,131), c(843,179,207,106), c(7032,1130,1575,1046)))
dimnames(SoxN_het_Kr) <- list(position=c("Overlap", "Proximal", "Distal"),
                              cons=c("1 species", "2 species", "3 species", "4 species"))

SoxN_proximal <- as.table(rbind(c(658,116,224,144), c(551,98,157,69), c(1087,213,259,126)))
dimnames(SoxN_proximal) <- list(type=c("Hom", "Het Sox", "Het other"),
                                const=c("1 species", "2 species", "3 species", "4 species"))

SoxN_proximal_2 <- as.table(rbind(c(658,116,224,144), c(551,98,157,69), c(264,37,53,21), c(843,179,207,106)))
dimnames(SoxN_proximal_2) <- list(type=c("Hom", "Het Sox", "Het vnd", "Het Kr"),
                                const=c("1 species", "2 species", "3 species", "4 species"))

D_proximal <- as.table(rbind(c(184,40,79,81), c(426,85,133,139), c(112,16,31,20), c(377,74,108,126)))
dimnames(D_proximal) <- list(type=c("Hom", "Het Sox", "Het vnd", "Het Kr"),
                             const=c("1 species", "2 species", "3 species", "4 species"))

D_proximal_2 <- as.table(rbind(c(184,40,79,81), c(426,85,133,139), c(483,89,138,144)))
dimnames(D_proximal_2) <- list(type=c("Hom", "Het Sox", "Het other"),
                                  const=c("1 species", "2 species", "3 species", "4 species"))

D_overlap <- as.table(rbind(c(24,6,9,20), c(262,58,70,38), c(358,61,100,52), c(358,61,100,52)))
dimnames(D_overlap) <- list(type=c("Hom", "Het Sox", "Het vnd", "Het Kr"),
                             const=c("1 species", "2 species", "3 species", "4 species"))

##NOTE: All 20 of the 4-conserved D homotypic overlap sites have a 1-bp overlap with their partner D site. 

SoxN_overlap <- as.table(rbind(c(1665,331,365,139), c(293,64,64,21), c(156,24,26,10), c(2615,522,510,131)))
dimnames(SoxN_overlap) <- list(type=c("Hom", "Het Sox", "Het vnd", "Het Kr"),
                            const=c("1 species", "2 species", "3 species", "4 species"))