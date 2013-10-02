
select dm_id, dm_tf, dm_sequence, dm_start, dm_wscore from
(
	(select t.id as dm_id, t.TF as dm_TF, t.sequence as dm_sequence, t.start as dm_start, t.wscore as dm_wscore from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dmel') AS mel
	JOIN
	(select t.id, t.TF, t.sequence, t.start, t.wscore from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dsim') AS sim ON mel.dm_id = sim.id
) AS twospecies WHERE dm_tf = 'D';
