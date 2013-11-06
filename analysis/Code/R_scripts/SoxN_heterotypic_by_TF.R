soxn_het_Kr_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from soxn_msyp, soxn_het_kr_overlap where dm_id = id1")

soxn_het_Kr_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from soxn_3species, soxn_het_kr_overlap where d1_id = id1")

soxn_het_Kr_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from soxn_2species, soxn_het_kr_overlap where d1_id = id1")

soxn_het_Kr_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from soxn_1species, soxn_het_kr_overlap where d1_id = id1")


soxn_het_Kr_prox_4sp <- dbGetQuery(con, "select distinct id1 from soxn_msyp, soxn_het_kr_proximal where dm_id = id1")

soxn_het_Kr_prox_3sp <- dbGetQuery(con, "select distinct id1 from soxn_3species, soxn_het_kr_proximal where d1_id = id1")

soxn_het_Kr_prox_2sp <- dbGetQuery(con, "select distinct id1 from soxn_2species, soxn_het_kr_proximal where d1_id = id1")

soxn_het_Kr_prox_1sp <- dbGetQuery(con, "select distinct id1 from soxn_1species, soxn_het_kr_proximal where d1_id = id1")


soxn_het_vnd_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from soxn_msyp, soxn_het_vnd_overlap where dm_id = id1")

soxn_het_vnd_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from soxn_3species, soxn_het_vnd_overlap where d1_id = id1")

soxn_het_vnd_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from soxn_2species, soxn_het_vnd_overlap where d1_id = id1")

soxn_het_vnd_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from soxn_1species, soxn_het_vnd_overlap where d1_id = id1")


soxn_het_vnd_prox_4sp <- dbGetQuery(con, "select distinct id1 from soxn_msyp, soxn_het_vnd_proximal where dm_id = id1")

soxn_het_vnd_prox_3sp <- dbGetQuery(con, "select distinct id1 from soxn_3species, soxn_het_vnd_proximal where d1_id = id1")

soxn_het_vnd_prox_2sp <- dbGetQuery(con, "select distinct id1 from soxn_2species, soxn_het_vnd_proximal where d1_id = id1")

soxn_het_vnd_prox_1sp <- dbGetQuery(con, "select distinct id1 from soxn_1species, soxn_het_vnd_proximal where d1_id = id1")