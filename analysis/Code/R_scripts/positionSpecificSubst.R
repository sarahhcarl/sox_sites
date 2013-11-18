
## Use PWMs from 
##Define vectors for information content of each PWM by nucleotide (calculated using PWMEnrich motifIC function)
##Motifs calculated from all D.mel sequences

D_IC <- c(0.5283238, 1.4832539, 0.4634836, 1.8363522, 1.7551130, 1.9966104, 1.9966104, 0.3136310)
SoxN_IC <- c(0.06126436, 0.34048129, 0.27468987, 0.84478374, 0.76508800, 1.77933291, 1.78601180, 1.21457060, 0.35209726, 1.78462505)

##Define vectors for evolutionary rate at each site (parsimony cost) 

D_rate <- c(0.11120616, 0.03507271, 0.075278014, 0.002566296, 0.001710864, 0.0, 0.0, 0.12745936)
SoxN_rate <-c(0.18688025, 0.12433257, 0.1006865, 0.048817698, 0.03051106, 0.0038138826, 0.009916094, 0.03661327, 0.112128146, 0.008390541)

##Plot rate versus information content

plot(D_IC, D_rate)
D_IC_rate <- lm(D_IC ~ D_rate)

plot(SoxN_IC, SoxN_rate)
SoxN_IC_rate <- lm(SoxN_IC ~ SoxN_rate)

##Plot both series on the same graph
