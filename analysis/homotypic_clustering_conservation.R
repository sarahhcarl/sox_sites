#drv <- dbDriver("PostgreSQL")
#con <- dbConnect(drv, dbname="sox_db")

D_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from D_overlap, D_msyp where D_overlap.id1=D_msyp.dm_id OR D_overlap.id2=D_msyp.dm_id")

D_overlap_msy <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_msy where D_overlap.id1=D_msy.d1_id OR D_overlap.id2=D_msy.d1_id")
D_overlap_msp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_msp where D_overlap.id1=D_msp.d1_id OR D_overlap.id2=D_msp.d1_id")
D_overlap_myp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_myp where D_overlap.id1=D_myp.d1_id OR D_overlap.id2=D_myp.d1_id")
D_overlap_syp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_syp where D_overlap.id1=D_syp.d1_id OR D_overlap.id2=D_syp.d1_id") 
D_overlap_3sp <- nrow(D_overlap_msy) + nrow(D_overlap_msp) + nrow(D_overlap_myp) + nrow(D_overlap_syp)

D_overlap_ms <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_ms where D_overlap.id1=D_ms.d1_id OR D_overlap.id2=D_ms.d1_id")
D_overlap_my <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_my where D_overlap.id1=D_my.d1_id OR D_overlap.id2=D_my.d1_id")
D_overlap_mp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_mp where D_overlap.id1=D_mp.d1_id OR D_overlap.id2=D_mp.d1_id")
D_overlap_sy <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_sy where D_overlap.id1=D_sy.d1_id OR D_overlap.id2=D_sy.d1_id")
D_overlap_sp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_sp where D_overlap.id1=D_sp.d1_id OR D_overlap.id2=D_sp.d1_id")
D_overlap_yp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_yp where D_overlap.id1=D_yp.d1_id OR D_overlap.id2=D_yp.d1_id")
D_overlap_2sp <- nrow(D_overlap_ms) + nrow(D_overlap_my) + nrow(D_overlap_mp) + nrow(D_overlap_sy) + nrow(D_overlap_sp) + nrow(D_overlap_yp)

D_overlap_m <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_m where D_overlap.id1=D_m.d1_id OR D_overlap.id2=D_m.d1_id")
D_overlap_s <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_s where D_overlap.id1=D_s.d1_id OR D_overlap.id2=D_s.d1_id")
D_overlap_y <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_y where D_overlap.id1=D_y.d1_id OR D_overlap.id2=D_y.d1_id")
D_overlap_p <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_p where D_overlap.id1=D_p.d1_id OR D_overlap.id2=D_p.d1_id")
D_overlap_1sp <- nrow(D_overlap_m) + nrow(D_overlap_s) + nrow(D_overlap_y) + nrow(D_overlap_p)

D_prox_4sp <- dbGetQuery(con, "select distinct dm_id from D_proximal, D_msyp where D_proximal.id1=D_msyp.dm_id OR D_proximal.id2=D_msyp.dm_id")

D_prox_msy <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_msy where D_proximal.id1=D_msy.d1_id OR D_proximal.id2=D_msy.d1_id")
D_prox_msp <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_msp where D_proximal.id1=D_msp.d1_id OR D_proximal.id2=D_msp.d1_id")
D_prox_myp <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_myp where D_proximal.id1=D_myp.d1_id OR D_proximal.id2=D_myp.d1_id")
D_prox_syp <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_syp where D_proximal.id1=D_syp.d1_id OR D_proximal.id2=D_syp.d1_id") 
D_prox_3sp <- nrow(D_prox_msy) + nrow(D_prox_msp) + nrow(D_prox_myp) + nrow(D_prox_syp)

##Finish changing overlap to prox, do distal

D_overlap_ms <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_ms where D_overlap.id1=D_ms.d1_id OR D_overlap.id2=D_ms.d1_id")
D_overlap_my <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_my where D_overlap.id1=D_my.d1_id OR D_overlap.id2=D_my.d1_id")
D_overlap_mp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_mp where D_overlap.id1=D_mp.d1_id OR D_overlap.id2=D_mp.d1_id")
D_overlap_sy <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_sy where D_overlap.id1=D_sy.d1_id OR D_overlap.id2=D_sy.d1_id")
D_overlap_sp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_sp where D_overlap.id1=D_sp.d1_id OR D_overlap.id2=D_sp.d1_id")
D_overlap_yp <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_yp where D_overlap.id1=D_yp.d1_id OR D_overlap.id2=D_yp.d1_id")
D_overlap_2sp <- nrow(D_overlap_ms) + nrow(D_overlap_my) + nrow(D_overlap_mp) + nrow(D_overlap_sy) + nrow(D_overlap_sp) + nrow(D_overlap_yp)

D_overlap_m <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_m where D_overlap.id1=D_m.d1_id OR D_overlap.id2=D_m.d1_id")
D_overlap_s <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_s where D_overlap.id1=D_s.d1_id OR D_overlap.id2=D_s.d1_id")
D_overlap_y <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_y where D_overlap.id1=D_y.d1_id OR D_overlap.id2=D_y.d1_id")
D_overlap_p <- dbGetQuery(con, "select distinct d1_id from D_overlap, D_p where D_overlap.id1=D_p.d1_id OR D_overlap.id2=D_p.d1_id")
D_overlap_1sp <- nrow(D_overlap_m) + nrow(D_overlap_s) + nrow(D_overlap_y) + nrow(D_overlap_p)