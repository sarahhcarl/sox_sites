
## Use PWMs from 
##Define vectors for information content of each PWM by nucleotide (calculated using PWMEnrich motifIC function)
##Motifs calculated from all D.mel sequences

D_IC <- c(0.5283238, 1.4832539, 0.4634836, 1.8363522, 1.7551130, 1.9966104, 1.9966104, 0.3136310)
SoxN_IC <- c(0.06126436, 0.34048129, 0.27468987, 0.84478374, 0.76508800, 1.77933291, 1.78601180, 1.21457060, 0.35209726, 1.78462505)

##Define vectors for evolutionary rate at each site (parsimony cost) 

D_rate <- c(0.11120616, 0.03507271, 0.075278014, 0.002566296, 0.001710864, 0.0, 0.0, 0.12745936)
D_rate_all <- c(1.359559, 1.3863693, 1.2400401, 1.2387873, 1.1638687, 1.2773741, 1.2470559, 1.2197444)
D_rate_nopse <- c(0.3265306, 0.31932774, 0.28391355, 0.24489796, 0.2647059, 0.26110443, 0.26170468, 0.28031212)

SoxN_rate <-c(0.18688025, 0.12433257, 0.1006865, 0.048817698, 0.03051106, 0.0038138826, 0.009916094, 0.03661327, 0.112128146, 0.008390541)
SoxN_rate_all <- c()
SoxN_rate_nopse <- c(0.3496394, 0.34054562, 0.35497022, 0.33960488, 0.30667922, 0.27626216, 0.2712449, 0.31169647, 0.32768893, 0.32925683)

##Plot rate versus information content

plot(D_IC, D_rate)
D_IC_rate <- lm(D_IC ~ D_rate)

plot(SoxN_IC, SoxN_rate)
SoxN_IC_rate <- lm(SoxN_IC ~ SoxN_rate)

##Plot both series on the same graph
