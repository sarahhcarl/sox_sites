select s1.tfsite_id, s1.tf, s1.relend, s1.relstart, s1.sequence, s1.wscore, s1.enhancer_id, s1.chrom, s1.startcoords, s1.endcoords, s1.enhancer_name, s1.soxbindpattern, s1.transcomp, s1.name as species1, s2.name as species2 from (
(select * from d_common, tfsite_species ts, species s where 
	d_common.tfsite_id = ts.tfsites_id AND ts.species_id = s.id AND s.name='dmel') as s1 JOIN
(select * from d_common, tfsite_species ts, species s where 
	d_common.tfsite_id = ts.tfsites_id AND ts.species_id = s.id AND s.name='dsim') as s2 ON s1.tfsite_id = s2.tfsite_id);