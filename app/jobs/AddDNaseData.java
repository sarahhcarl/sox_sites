package jobs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import models.DNase_site;

import play.Logger;
import play.jobs.*;


//@OnApplicationStart
public class AddDNaseData extends Job {

	public void doJob() throws IOException {
		
		Logger.info("Adding DNase-seq data...");
		
		//Initialize table with test data
		DNase_site testSite = new DNase_site("test", 1234, 2345, "none");
		testSite.save();
		
		BufferedReader reader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/DNase-seq/Thomas_et_al_data/gb-2011-12-5-r43-S2.csv"));
		String line = null;
		int counter = 0;
		String chrom = null;
		int startcoord = 0;
		int endcoord = 0;
		String stage = null;
		while ((line = reader.readLine()) != null) {
			counter++;
			if (counter > 1) {
				String[] parts = line.split("\\s");
				chrom = parts[0];
				startcoord = Integer.parseInt(parts[1]);
				endcoord = Integer.parseInt(parts[2]);
				stage = parts[3];
				
				System.out.println(counter);
				
				DNase_site site = new DNase_site(chrom, startcoord, endcoord, stage);
				site.save();
			}
		}
		reader.close();
		testSite.delete();
	}
}
