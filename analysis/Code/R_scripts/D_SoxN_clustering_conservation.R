D_SoxN_overlap_1sp <- dbGetQuery(con, "select distinct id1 from d_soxn_overlap, d_1species where id1=d1_id")
D_SoxN_overlap_2sp <- dbGetQuery(con, "select distinct id1 from d_soxn_overlap, d_2species where id1=d1_id")
D_SoxN_overlap_3sp <- dbGetQuery(con, "select distinct id1 from d_soxn_overlap, d_3species where id1=d1_id")
D_SoxN_overlap_4sp <- dbGetQuery(con, "select distinct id1 from d_soxn_overlap, d_msyp where id1=dm_id") 

D_SoxN_prox_1sp <- dbGetQuery(con, "select distinct id1 from d_soxn_proximal, d_1species where id1=d1_id")
D_SoxN_prox_2sp <- dbGetQuery(con, "select distinct id1 from d_soxn_proximal, d_2species where id1=d1_id")
D_SoxN_prox_3sp <- dbGetQuery(con, "select distinct id1 from d_soxn_proximal, d_3species where id1=d1_id")
D_SoxN_prox_4sp <- dbGetQuery(con, "select distinct id1 from d_soxn_proximal, d_msyp where id1=dm_id") 

D_SoxN_dist_1sp <- dbGetQuery(con, "select distinct id1 from d_soxn_distal, d_1species where id1=d1_id")
D_SoxN_dist_2sp <- dbGetQuery(con, "select distinct id1 from d_soxn_distal, d_2species where id1=d1_id")
D_SoxN_dist_3sp <- dbGetQuery(con, "select distinct id1 from d_soxn_distal, d_3species where id1=d1_id")
D_SoxN_dist_4sp <- dbGetQuery(con, "select distinct id1 from d_soxn_distal, d_msyp where id1=dm_id") 