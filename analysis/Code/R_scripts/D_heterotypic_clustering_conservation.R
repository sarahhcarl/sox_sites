D_het_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from d_msyp, d_het_overlap where dm_id = id1")

D_het_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from d_3species, d_het_overlap where d1_id = id1")

D_het_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from d_2species, d_het_overlap where d1_id = id1")

D_het_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from d_1species, d_het_overlap where d1_id = id1")


D_het_prox_4sp <- dbGetQuery(con, "select distinct id1 from d_msyp, d_het_proximal where dm_id = id1")

D_het_prox_3sp <- dbGetQuery(con, "select distinct id1 from d_3species, d_het_proximal where d1_id = id1")

D_het_prox_2sp <- dbGetQuery(con, "select distinct id1 from d_2species, d_het_proximal where d1_id = id1")

D_het_prox_1sp <- dbGetQuery(con, "select distinct id1 from d_1species, d_het_proximal where d1_id = id1")


D_het_dist_4sp <- dbGetQuery(con, "select distinct dm_id from d_msyp, d_het_distal where dm_id = id1")

D_het_dist_3sp <- dbGetQuery(con, "select distinct d1_id from d_3species, d_het_distal where d1_id = id1")

D_het_dist_2sp <- dbGetQuery(con, "select distinct d1_id from d_2species, d_het_distal where d1_id = id1")

D_het_dist_1sp <- dbGetQuery(con, "select distinct d1_id from d_1species, d_het_distal where d1_id = id1")