SoxN_D_overlap_1sp <- dbGetQuery(con, "select distinct id1 from soxn_d_overlap, soxn_1species where id1=d1_id")
SoxN_D_overlap_2sp <- dbGetQuery(con, "select distinct id1 from soxn_d_overlap, soxn_2species where id1=d1_id")
SoxN_D_overlap_3sp <- dbGetQuery(con, "select distinct id1 from soxn_d_overlap, soxn_3species where id1=d1_id")
SoxN_D_overlap_4sp <- dbGetQuery(con, "select distinct id1 from soxn_d_overlap, soxn_msyp where id1=dm_id") 

SoxN_D_prox_1sp <- dbGetQuery(con, "select distinct id1 from soxn_d_proximal, soxn_1species where id1=d1_id")
SoxN_D_prox_2sp <- dbGetQuery(con, "select distinct id1 from soxn_d_proximal, soxn_2species where id1=d1_id")
SoxN_D_prox_3sp <- dbGetQuery(con, "select distinct id1 from soxn_d_proximal, soxn_3species where id1=d1_id")
SoxN_D_prox_4sp <- dbGetQuery(con, "select distinct id1 from soxn_d_proximal, soxn_msyp where id1=dm_id") 

SoxN_D_dist_1sp <- dbGetQuery(con, "select distinct id1 from soxn_d_distal, soxn_1species where id1=d1_id")
SoxN_D_dist_2sp <- dbGetQuery(con, "select distinct id1 from soxn_d_distal, soxn_2species where id1=d1_id")
SoxN_D_dist_3sp <- dbGetQuery(con, "select distinct id1 from soxn_d_distal, soxn_3species where id1=d1_id")
SoxN_D_dist_4sp <- dbGetQuery(con, "select distinct id1 from soxn_d_distal, soxn_msyp where id1=dm_id") 