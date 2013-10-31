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
