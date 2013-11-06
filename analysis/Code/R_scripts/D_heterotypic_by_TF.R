##D_het_Kr_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from d_msyp, d_het_kr_overlap where dm_id = id1")

D_het_Kr_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from d_3species, d_het_kr_overlap where d1_id = id1")

D_het_Kr_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from d_2species, d_het_kr_overlap where d1_id = id1")

D_het_Kr_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from d_1species, d_het_kr_overlap where d1_id = id1")


D_het_Kr_prox_4sp <- dbGetQuery(con, "select distinct id1 from d_msyp, d_het_kr_proximal where dm_id = id1")

D_het_Kr_prox_3sp <- dbGetQuery(con, "select distinct id1 from d_3species, d_het_kr_proximal where d1_id = id1")

D_het_Kr_prox_2sp <- dbGetQuery(con, "select distinct id1 from d_2species, d_het_kr_proximal where d1_id = id1")

D_het_Kr_prox_1sp <- dbGetQuery(con, "select distinct id1 from d_1species, d_het_kr_proximal where d1_id = id1")


D_het_vnd_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from d_msyp, d_het_vnd_overlap where dm_id = id1")

D_het_vnd_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from d_3species, d_het_vnd_overlap where d1_id = id1")

D_het_vnd_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from d_2species, d_het_vnd_overlap where d1_id = id1")

D_het_vnd_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from d_1species, d_het_vnd_overlap where d1_id = id1")


D_het_vnd_prox_4sp <- dbGetQuery(con, "select distinct id1 from d_msyp, d_het_vnd_proximal where dm_id = id1")

D_het_vnd_prox_3sp <- dbGetQuery(con, "select distinct id1 from d_3species, d_het_vnd_proximal where d1_id = id1")

D_het_vnd_prox_2sp <- dbGetQuery(con, "select distinct id1 from d_2species, d_het_vnd_proximal where d1_id = id1")

D_het_vnd_prox_1sp <- dbGetQuery(con, "select distinct id1 from d_1species, d_het_vnd_proximal where d1_id = id1")
