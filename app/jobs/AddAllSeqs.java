package jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.*;

import models.Alignment;
import models.Enhancer;
import models.Species;
import models.TFsite;
import models.Sequence;
import play.Logger;
import play.db.jpa.JPA;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

//@OnApplicationStart
public class AddAllSeqs extends Job {

	public void doJob() throws NumberFormatException, IOException {
		
		Enhancer testEnhancer = new Enhancer("testing");
		TFsite testsite = new TFsite(testEnhancer, "Protein", "CAAGTAG", 100, 107, 4.5);
		Alignment testalign = new Alignment(testsite, "D");
		
		int counter = 0;
		//Read flat file
		
		File D_sites = new File("/home/sarah/utilities/play-1.2.7/sox_sites/data/all_D_alignments.txt");
		BufferedReader reader = new BufferedReader(new FileReader(D_sites));
		String line = null;
		String enhancerName = null;
		int relstart = 0;
		int relend = 0;
		Alignment thisAlign = null;
		String speciesName = null;
		String sequence = null;
		
		while ((line = reader.readLine()) != null) {
			Pattern p1 = Pattern.compile("Enhancer: (.+)");
			Matcher m1 = p1.matcher(line);
			Pattern p2 = Pattern.compile("Start: (.+)");
			Matcher m2 = p2.matcher(line);
			Pattern p3 = Pattern.compile("End: (.+)");
			Matcher m3 = p3.matcher(line);
			Pattern p4 = Pattern.compile(">(.+)");
			Matcher m4 = p4.matcher(line);
			if (m1.lookingAt() == true) {
				enhancerName = m1.group(1);
			} else if (m2.lookingAt() == true) {
				relstart = Integer.parseInt(m2.group(1));
			} else if (m3.lookingAt() == true) {
				relend = Integer.parseInt(m3.group(1));
				File matrix_scan = new File("/home/sarah/utilities/play-1.2.7/sox_sites/data/D_scan90/" + enhancerName + "_Dscan90.ft");
				BufferedReader reader2 = new BufferedReader(new FileReader(matrix_scan));
				String line2 = null;
				int startCoords = 0;
				int endCoords = 0;
				String strand = null;

				while ((line2 = reader2.readLine()) != null) {
					if ((line2.indexOf(";") == -1) && (line2.indexOf("#seq_id") == -1)) {
						//Logger.info(line2);
						String[] parts = line2.split("\\s");
						startCoords = Integer.parseInt(parts[4]);
						endCoords = Integer.parseInt(parts[5]);
						if ((relstart == startCoords) && (relend == endCoords)) {
							strand = parts[3];
						}
					}	
				}
				
				Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
				TFsite thisTFsite = TFsite.find("byEnhancerAndRelstartAndRelendAndTf", thisEnhancer, relstart, relend, "D").first();
				thisAlign = new Alignment(thisTFsite, strand);
				thisTFsite.tagAlign(thisAlign);
				counter++;
				System.out.println(counter);
				
				reader2.close();
				
			} else if (m4.lookingAt() == true) {
				speciesName = m4.group();
				sequence = reader.readLine();
				thisAlign.addEntry(speciesName, sequence);
			}
		}
		reader.close();
		testEnhancer.delete();
		testsite.delete();
		testalign.delete();
	}
	

	private void flush(Class<?> type) {
		Logger.info("Flushing...");
		if(type == TFsite.class){
			TFsite.em().flush();
			TFsite.em().clear();
		} else if (type == Enhancer.class){
			Enhancer.em().flush();
			Enhancer.em().clear();
		} else if (type == Species.class) {
			Species.em().flush();
			Species.em().clear();
		} else if (type == Alignment.class) {
			Alignment.em().flush();
			Alignment.em().clear();
		}
}
}	
