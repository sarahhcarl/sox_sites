## This script takes a bed file as input and finds the sequences from a multiple alignment that correspond to each interval, outputting them as separate multiple alignments.

my $TF = "D";

open FILE, ">all_".$TF."_sites.csv";

while (my $line = <FILE>) {
	my @tmp = split(/,/, $line);
	my $ename = $tmp[0];
	my $start = $tmp[1];
	my $end = $tmp[2];
	open ALIGN, >$ename.".fasta.best.anc.fas";
	my %align;
	my $species;
	my $seq;
	while (my $newline = <ALIGN>) {	
		if ($newline =~ />(.+)/ {
			$species = $1;	
		} else {
			$seq = $newline;
			$align{$species} = $seq;
		}
	}
	foreach my $species (keys %align) {
		print $species."\t".$align{$species}."\n";
	}
}
