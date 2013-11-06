drv <- dbDriver("PostgreSQL")
con <- dbConnect(drv, dbname="sox_db")

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

D_prox_ms <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_ms where D_proximal.id1=D_ms.d1_id OR D_proximal.id2=D_ms.d1_id")
D_prox_my <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_my where D_proximal.id1=D_my.d1_id OR D_proximal.id2=D_my.d1_id")
D_prox_mp <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_mp where D_proximal.id1=D_mp.d1_id OR D_proximal.id2=D_mp.d1_id")
D_prox_sy <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_sy where D_proximal.id1=D_sy.d1_id OR D_proximal.id2=D_sy.d1_id")
D_prox_sp <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_sp where D_proximal.id1=D_sp.d1_id OR D_proximal.id2=D_sp.d1_id")
D_prox_yp <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_yp where D_proximal.id1=D_yp.d1_id OR D_proximal.id2=D_yp.d1_id")
D_prox_2sp <- nrow(D_prox_ms) + nrow(D_prox_my) + nrow(D_prox_mp) + nrow(D_prox_sy) + nrow(D_prox_sp) + nrow(D_prox_yp)

D_prox_m <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_m where D_proximal.id1=D_m.d1_id OR D_proximal.id2=D_m.d1_id")
D_prox_s <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_s where D_proximal.id1=D_s.d1_id OR D_proximal.id2=D_s.d1_id")
D_prox_y <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_y where D_proximal.id1=D_y.d1_id OR D_proximal.id2=D_y.d1_id")
D_prox_p <- dbGetQuery(con, "select distinct d1_id from D_proximal, D_p where D_proximal.id1=D_p.d1_id OR D_proximal.id2=D_p.d1_id")
D_prox_1sp <- nrow(D_prox_m) + nrow(D_prox_s) + nrow(D_prox_y) + nrow(D_prox_p)


d_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from d_overlap, d_msyp where d_overlap.id1=d_msyp.dm_id OR d_overlap.id2=d_msyp.dm_id")

d_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from d_overlap, d_3species where d_overlap.id1=d_3species.d1_id OR d_overlap.id2=d_3species.d1_id")

d_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from d_overlap, d_2species where d_overlap.id1=d_2species.d1_id OR d_overlap.id2=d_2species.d1_id")

d_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from d_overlap, d_1species where d_overlap.id1=d_1species.d1_id OR d_overlap.id2=d_1species.d1_id")


d_prox_4sp <- dbGetQuery(con, "select distinct dm_id from d_proximal, d_msyp where d_proximal.id1=d_msyp.dm_id OR d_proximal.id2=d_msyp.dm_id")

d_prox_3sp <- dbGetQuery(con, "select distinct d1_id from d_proximal, d_3species where d_proximal.id1=d_3species.d1_id OR d_proximal.id2=d_3species.d1_id")

d_prox_2sp <- dbGetQuery(con, "select distinct d1_id from d_proximal, d_2species where d_proximal.id1=d_2species.d1_id OR d_proximal.id2=d_2species.d1_id")

d_prox_1sp <- dbGetQuery(con, "select distinct d1_id from d_proximal, d_1species where d_proximal.id1=d_1species.d1_id OR d_proximal.id2=d_1species.d1_id")


D_dist_4sp <- dbGetQuery(con, "select distinct dm_id from D_distal, D_msyp where D_distal.id1=D_msyp.dm_id")

D_dist_3sp <- dbGetQuery(con, "select distinct d1_id from D_distal, D_3species where D_distal.id1=D_3species.d1_id")

D_dist_2sp <- dbGetQuery(con, "select distinct d1_id from D_distal, D_2species where D_distal.id1=D_2species.d1_id")

D_dist_1sp <- dbGetQuery(con, "select distinct d1_id from D_distal, D_1species where D_distal.id1=D_1species.d1_id")