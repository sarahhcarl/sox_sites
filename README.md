sox_sites
=========

#Introduction
	
The aim of the sox-sites project is to create a resource for integrating <i>in vivo</i> genome-wide binding data generated by the Russell lab, functional enhancer sequences from the Flylight collection, computational predictions of transcription factor binding sites (TFBS) and evolutionary analyses in order to learn about the regulatory logic and evolutionary patterns of the group B Sox proteins Dichaete and SoxNeuro in <i>Drosophila</i>.
		

#Data sources
		
###The FlyLight enhancer collection
	
The FlyLight GAL4 enhancer collection is a public resource of Drosophila lines created by the FlyLight Project Team at Janelia Farm (full documentation is available from their website <a href="http://flweb.janelia.org/cgi-bin/flew.cgi">here</a>). Briefly, each fly line expresses GAL4 under the control of a segment of non-coding DNA that directs a spatially and temporally specific pattern of expression, which has been characterized using GFP. Although each enhancer sequence may not be necessary in its entirety to direct its corresponding expression pattern, it is by definition sufficient to direct that expression. As such, these DNA elements represent a set of functionally-verified enhancers and are of great potential value to the fly community.
		
The sox-sites database contains information about all of the Flylight enhancers that have been shown to direct expression in the embryonic central nervous system (CNS). This is because the focus of our lab is on developmental biology; however, it should be noted that the Flylight collection also contains enhancers that are active in the 3rd-instar larva and the adult fly.
		
###Species of interest

Four species of <i>Drosophila</i> are included in the database and analyses: <i>D. melanogaster</i>, <i>D. simulans,</i>, <i>D. yakuba</i> and <i>D. pseudoobscura</i>. The FlyLight enhancer lines were produced in <i>D. melanogaster</i>, making it the reference species for enhancer-level data. At present, all genome-wide binding data has also been generated in <i>D. melanogaster</i>, although experiments are under way to produce similar data in each of the other species of interest. These species were chosen because they span an evolutionary distance of approximately 2 million to 25 million years (Russo et al., 1995), making possible a range of evolutionary comparisons. Each species also has a stable genome release and a number of useful bioinformatic tools. For this project, the dm3 (Flybase release 5), droSim1, droYak2, and dp3 releases as available on the <a href="http://hgdownload.soe.ucsc.edu/downloads.html">UCSC website</a> were used, respectively. Although in some cases these are not the most recent releases, they are the most recent for which all the necessary bioinformatic tools are available.
		
###Enhancers
		
The analyses presented here, including the TF binding site predictions, are based on a curated set of 725 enhancers. These enhancers were chosen according to the following criteria:
			<ul>
				<li>They drive expression in the embryonic CNS, as characterized nby the FlyLight Project Team.</li>
				<li>DamID experiments carried out in the Russell lab show that they are bound <i>in vivo</i> in <i>Drosophila melanogaster</i> by either Dichaete, SoxN, or both.</li>
				<li>An orthologous putative-enhancer sequence can be unambiguously identified in each species of interest.</li>
			</ul> 
		
		
#Methods
	
###Identification of orthologues
	
As described above, the first step in creating the dataset used here was to identify orthologous sequences for each FlyLight enhancer of interest in each species of interest. This was accomplished using the <a href="http://genome.ucsc.edu/cgi-bin/hgLiftOver">UCSC LiftOver</a> tool. The key parameter for a successful conversion was the minimum ratio of bases that must remap. This was set to 0.9 for <i>D. simulans</i> and <i>D. yakuba</i> and 0.7 for <i>D. pseudoobscura</i>. Although such a relatively stringent setting limits the number of enhancers included in the study, it is necessary to prevent an introduction of bias (namely, under-prediction of TF binding sites) in sequences of poor quality or containing large gaps. LiftOver produces bed files; the corresponding fasta files were obtained using the fetch-UCSC sequences tool from <a href="http://rsat.ulb.ac.be/">RSAT</a>, which preserves strand information, a critical piece of information for multiple alignments.
	
	
###Multiple alignment

Once the set of 725 enhancers, each with an orthologous sequence in four species, was identified, the orthologues were aligned using the phylogeny-aware multiple aligner <a href="http://code.google.com/p/prank-msa/">prank</a>. An explanation of the differences between prank and traditional aligners like Clustal can be found <a href="http://code.google.com/p/prank-msa/wiki/ExplanationDifferences?tm=6">here</a>. The guide tree was estimated from a test set of 50 enhancers. The branch lengths of the guide tree represent an estimate of the number of nucleotide changes expected between species. It was decided to estimate the guide tree from the data rather than using an independent estimate of branch lengths because selection is expected to act differently on different classes of DNA; therefore, branch lengths determined using coding sequences or averaging over the genome might over- or under-estimate the expected differences in enhancer sequences between species. Prank output a multiple alignment of four sequences for each enhancer, as well as predicted ancestral sequences at each of the three ancestral nodes.
	
	
###Predicting transcription factor binding sites
	
A number of tools exist to predict TFBSs in sequences, either using a <i>de novo</i> pattern finding algorithm or scanning for known patterns. In this case, I used a combination of two tools: <a href="http://biowhat.ucsd.edu/homer/index.html">HOMER</a> for a <i>de novo</i> motif search and the matrix-scan tool from <a href="http://rsat.ulb.ac.be/">RSAT</a> to identify instances of the motifs found by HOMER.
	
First, a <i>de novo</i> binding motif for both Dichaete and SoxNeuro	was identified by scanning the FDR5 binding intervals identified by DamID for each protein with HOMER. In each case, an enriched motif was found that matched the known degenerate Sox binding motif. For the Dichaete DamID intervals, this was the second-highest scoring motif; for the SoxN DamID intervals, it was the fourth-highest. Although the two motifs do have some differences, they are quite similar overall; however, we believe that this reflects the known degeneracy in Sox binding and possibility for compensatory binding between Dichaete and SoxN at some of the same sites. A positional-weight matrix (PWM) representing each motif was downloaded and used as an input for matrix-scan.

The aligned enhancer sequences were then scanned for sites matching both PWMs using matrix-scan. The pre-compiled <i>Drosophila</i> background file provided by RSAT was used as the background for scanning, and the cutoff for reporting matches was set to a PWM weight-score of >=4 and a p-value of < 0.001. The fact that matrix-scan permits using an alignment as input confers an advantage in this case, as the identified sites are already in alignment across the four species, greatly simplifying the task of classifying sites as conserved or not. The end result of this process was a set of output files, one for each enhancer-PWM combination, containing the locations, sequences, and scores of every predicted TFBS. If a site was predicted at the same aligned position in multiple species, it was considered to be conserved between those species. This data was then loaded into the database.

