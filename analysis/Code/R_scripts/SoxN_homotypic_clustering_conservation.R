##SoxN_overlap_4sp <- dbGetQuery(con, "select distinct dm_id from SoxN_overlap, SoxN_msyp where SoxN_overlap.id1=SoxN_msyp.dm_id OR SoxN_overlap.id2=SoxN_msyp.dm_id")

SoxN_overlap_3sp <- dbGetQuery(con, "select distinct d1_id from SoxN_overlap, SoxN_3species where SoxN_overlap.id1=SoxN_3species.d1_id OR SoxN_overlap.id2=SoxN_3species.d1_id")

SoxN_overlap_2sp <- dbGetQuery(con, "select distinct d1_id from SoxN_overlap, SoxN_2species where SoxN_overlap.id1=SoxN_2species.d1_id OR SoxN_overlap.id2=SoxN_2species.d1_id")

SoxN_overlap_1sp <- dbGetQuery(con, "select distinct d1_id from SoxN_overlap, SoxN_1species where SoxN_overlap.id1=SoxN_1species.d1_id OR SoxN_overlap.id2=SoxN_1species.d1_id")


SoxN_prox_4sp <- dbGetQuery(con, "select distinct dm_id from SoxN_proximal, SoxN_msyp where SoxN_proximal.id1=SoxN_msyp.dm_id OR SoxN_proximal.id2=SoxN_msyp.dm_id")

SoxN_prox_3sp <- dbGetQuery(con, "select distinct d1_id from SoxN_proximal, SoxN_3species where SoxN_proximal.id1=SoxN_3species.d1_id OR SoxN_proximal.id2=SoxN_3species.d1_id")

SoxN_prox_2sp <- dbGetQuery(con, "select distinct d1_id from SoxN_proximal, SoxN_2species where SoxN_proximal.id1=SoxN_2species.d1_id OR SoxN_proximal.id2=SoxN_2species.d1_id")

SoxN_prox_1sp <- dbGetQuery(con, "select distinct d1_id from SoxN_proximal, SoxN_1species where SoxN_proximal.id1=SoxN_1species.d1_id OR SoxN_proximal.id2=SoxN_1species.d1_id")


SoxN_dist_4sp <- dbGetQuery(con, "select distinct dm_id from SoxN_distal, SoxN_msyp where SoxN_distal.id1=SoxN_msyp.dm_id")

SoxN_dist_3sp <- dbGetQuery(con, "select distinct d1_id from SoxN_distal, SoxN_3species where SoxN_distal.id1=SoxN_3species.d1_id")

SoxN_dist_2sp <- dbGetQuery(con, "select distinct d1_id from SoxN_distal, SoxN_2species where SoxN_distal.id1=SoxN_2species.d1_id")

SoxN_dist_1sp <- dbGetQuery(con, "select distinct d1_id from SoxN_distal, SoxN_1species where SoxN_distal.id1=SoxN_1species.d1_id")