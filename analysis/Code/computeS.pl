
# pseudocode for calculating S

my $length = 8;
my $sequence; #(String of sequence)

#This is a variable to hold the affinity at each site as it's calculated
my $s = 0;

# this is what we want to find: the overall strength of the motif
my $s_total = 0;

# Iterate over each position in the motif

foreach my $pos (1..$length) {

# Iterate over each possible nucleotide
		
	foreach my $nt [A,C,G,T] {
		if ($sequence[$pos] = $nt) {
			$s = log((probability of $nt at $pos in PWM) / (probability of $nt in background));
			$s_total = $s + $s_total;
		}		

	}

}

# background probabilities: my %BG = ("A"=>"0.3","C"=>"0.2","G"=>"0.2","T"=>"0.3");


dS(iab) = log(f(ib)/g(b)) - log(f(ia)/g(a))


## Example for site D_729 in the Abd-B.35C08 enhancer ##

changes: T -> C, pos. 0, lineage pse

= log(0.569/0.2) - log(0.166/0.3) = log(2.845) - log(0.5533) = 0.454 - -(.257) = 0.711

