create view SoxN_syp as select d1_id, d1_tf, d1_sequence, d1_relstart, d1_wscore, name1, name2, name3 from

	(((select t.id as d1_id, t.TF as d1_TF, t.sequence as d1_sequence, t.relstart as d1_relstart, t.wscore as d1_wscore, s.name as name1 from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dsim') AS species1
	JOIN
	(select t.id as d2_id, t.TF as d2_TF, t.sequence as d2_sequence, t.relstart as d2_relstart, t.wscore as d2_wscore, s.name as name2 from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dyak') AS species2 ON species1.d1_id = species2.d2_id) AS s1s2
	JOIN
	(select t.id as d3_id, t.TF as d3_TF, t.sequence as d3_sequence, t.relstart as d3_relstart, t.wscore as d3_wscore, s.name as name3 from tfsite t, tfsite_species ts, species s where t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dpse') AS species3 ON s1s2.d1_id = species3.d3_id) AS s1s2s3
	WHERE s1s2s3.d1_id NOT IN (select t.id as not1_id from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dmel') AND d1_tf = 'SoxN';
