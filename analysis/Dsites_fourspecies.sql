﻿
select dm_id, dm_tf, dm_sequence, dm_relstart, dm_wscore, mel_name, sim_name, yak_name, pse_name from
(
	(((select t.id as dm_id, t.TF as dm_TF, t.sequence as dm_sequence, t.relstart as dm_relstart, t.wscore as dm_wscore, s.name as mel_name from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dmel') AS mel
	JOIN
	(select t.id as ds_id, t.TF as ds_TF, t.sequence as ds_sequence, t.relstart as ds_relstart, t.wscore as ds_wscore, s.name as sim_name from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dsim') AS sim ON mel.dm_id = sim.ds_id) AS ms
	JOIN
	(select t.id as dy_id, t.TF as dy_TF, t.sequence as dy_sequence, t.relstart as dy_relstart, t.wscore as dy_wscore, s.name as yak_name from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dyak') AS yak ON ms.dm_id = yak.dy_id) AS msy
	JOIN
	(select t.id as dp_id, t.TF as dp_TF, t.sequence as dp_sequence, t.relstart as dp_relstart, t.wscore as dp_wscore, s.name as pse_name from tfsite t, tfsite_species ts, species s WHERE t.id = ts.tfsites_id AND s.id = ts.species_id AND s.name = 'dpse') AS pse ON msy.dm_id = pse.dp_id) AS msyp WHERE dm_tf = 'D';
