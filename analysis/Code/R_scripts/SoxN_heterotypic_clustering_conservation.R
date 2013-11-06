SoxN_het_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from soxn_msyp, soxn_het_overlap where dm_id = id1")

SoxN_het_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from soxn_3species, soxn_het_overlap where d1_id = id1")

SoxN_het_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from soxn_2species, soxn_het_overlap where d1_id = id1")

SoxN_het_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from soxn_1species, soxn_het_overlap where d1_id = id1")


SoxN_het_prox_4sp <- dbGetQuery(con, "select distinct dm_id from soxn_msyp, soxn_het_proximal where dm_id = id1")

SoxN_het_prox_3sp <- dbGetQuery(con, "select distinct d1_id from soxn_3species, soxn_het_proximal where d1_id = id1")

SoxN_het_prox_2sp <- dbGetQuery(con, "select distinct d1_id from soxn_2species, soxn_het_proximal where d1_id = id1")

SoxN_het_prox_1sp <- dbGetQuery(con, "select distinct d1_id from soxn_1species, soxn_het_proximal where d1_id = id1")


SoxN_het_dist_4sp <- dbGetQuery(con, "select distinct dm_id from soxn_msyp, soxn_het_distal where dm_id = id1")

SoxN_het_dist_3sp <- dbGetQuery(con, "select distinct d1_id from soxn_3species, soxn_het_distal where d1_id = id1")

SoxN_het_dist_2sp <- dbGetQuery(con, "select distinct d1_id from soxn_2species, soxn_het_distal where d1_id = id1")

SoxN_het_dist_1sp <- dbGetQuery(con, "select distinct d1_id from soxn_1species, soxn_het_distal where d1_id = id1")