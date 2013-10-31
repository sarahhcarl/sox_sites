a <- 0.03672
b <- 0.02957
c <- 0.03512  
d <- 0.06823
e <- 0.11110
f <- 0.18294

D_msyp["turnover_rate"] <- 0
D_msy["turnover_rate"] <- 0
D_msp["turnover_rate"] <- 1/(a+b+c+d+e+f)
D_myp["turnover_rate"] <- 1/(a+b+c+d+e+f)
D_syp["turnover_rate"] <- 1/(a+b+c+d+e+f)
D_ms["turnover_rate"] <- 0
D_my["turnover_rate"] <- 1/(a+b+c+d)
D_mp["turnover_rate"] <- 2/(a+b+c+d+e+f)
D_sy["turnover_rate"] <- 1/(a+b+c+d)
D_sp["turnover_rate"] <- 2/(a+b+c+d+e+f)
D_yp["turnover_rate"] <- 1/(a+b+c+d+e+f)
D_m["turnover_rate"] <- 0
D_s["turnover_rate"] <- 0
D_y["turnover_rate"] <- 0
D_p["turnover_rate"] <-0

SoxN_mysp["turnover_rate"] <- 0
SoxN_msy["turnover_rate"] <- 0
SoxN_msp["turnover_rate"] <- 1/(a+b+c+d+e+f)
SoxN_myp["turnover_rate"] <- 1/(a+b+c+d+e+f)
SoxN_syp["turnover_rate"] <- 1/(a+b+c+d+e+f)
SoxN_ms["turnover_rate"] <- 0
SoxN_my["turnover_rate"] <- 1/(a+b+c+d)
SoxN_mp["turnover_rate"] <- 2/(a+b+c+d+e+f)
SoxN_sy["turnover_rate"] <- 1/(a+b+c+d)
SoxN_sp["turnover_rate"] <- 2/(a+b+c+d+e+f)
SoxN_yp["turnover_rate"] <- 1/(a+b+c+d+e+f)
SoxN_m["turnover_rate"] <- 0
SoxN_s["turnover_rate"] <- 0
SoxN_y["turnover_rate"] <- 0
SoxN_p["turnover_rate"] <-0
    
D90_turnover <- c(D_msyp$turnover_rate, D_msy$turnover_rate, D_myp$turnover_rate, D_msp$turnover_rate, D_syp$turnover_rate, D_ms$turnover_rate, D_my$turnover_rate, D_mp$turnover_rate, D_sy$turnover_rate, D_sp$turnover_rate, D_yp$turnover_rate)
D90_wscore <- c(D_msyp$dm_wscore, D_msy$d1_wscore, D_myp$d1_wscore, D_msp$d1_wscore, D_syp$d1_wscore, D_ms$d1_wscore, D_my$d1_wscore, D_mp$d1_wscore, D_sy$d1_wscore, D_sp$d1_wscore, D_yp$d1_wscore)

SoxN90_turnover <- c(SoxN_mysp$turnover_rate, SoxN_msy$turnover_rate, SoxN_myp$turnover_rate, SoxN_msp$turnover_rate, SoxN_syp$turnover_rate, SoxN_ms$turnover_rate, SoxN_my$turnover_rate, SoxN_mp$turnover_rate, SoxN_sy$turnover_rate, SoxN_sp$turnover_rate, SoxN_yp$turnover_rate)
SoxN90_wscore <- c(SoxN_mysp$dm_wscore, SoxN_msy$d1_wscore, SoxN_myp$d1_wscore, SoxN_msp$d1_wscore, SoxN_syp$d1_wscore, SoxN_ms$d1_wscore, SoxN_my$d1_wscore, SoxN_mp$d1_wscore, SoxN_sy$d1_wscore, SoxN_sp$d1_wscore, SoxN_yp$d1_wscore)