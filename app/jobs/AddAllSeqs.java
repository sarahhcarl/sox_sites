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
		Alignment testalign = new Alignment(testsite);
		
		int counter = 0;
		//Read flat file
		File dir = new File("/home/sarah/utilities/play-1.2.7/sox_sites/data/");
		for (File childdir : dir.listFiles()) {
			System.out.println(childdir.getName());
			Pattern p = Pattern.compile("(.+)_scan90");
			Matcher m = p.matcher(childdir.getName());
			if (m.lookingAt() == true) {
				String TF = m.group(1);
				for (File childfile : childdir.listFiles()) {
					counter++;
					Logger.info("Counter: " + counter);
					if (counter%10==0) {
						flush(TFsite.class);
						flush(Enhancer.class);
						flush(Species.class);
						flush(Sequence.class);
					}
					Pattern p1 = Pattern.compile("/home/sarah/utilities/play-1.2.7/sox_sites/data/" + TF + "_scan90/(.+)_(.+).ft");
					Matcher m1 = p1.matcher(childfile.getPath());
					m1.lookingAt();
					String enhancerName = m1.group(1);
					Enhancer enhancer = Enhancer.find("byName", enhancerName).first();
					
					BufferedReader reader = new BufferedReader(new FileReader(childfile));
					String line = null;
					String speciesname = null;
					String sequence = null;
					int relstart = 0;
					int relend = 0;
					
					//Read each line by line
					while ((line = reader.readLine()) != null) {
						if ((line.indexOf(";") == -1) && (line.indexOf("#seq_id") == -1)) {
							String[] parts = line.split("\\s");
							speciesname = parts[0];
							sequence = parts[6];
							relstart = Integer.parseInt(parts[4]);
							relend = Integer.parseInt(parts[5]);

							TFsite thisTFsite = TFsite.find("byEnhancerAndRelstartAndRelend", enhancer, relstart, relend).first();
							
							Alignment thisAlign = null;
							thisAlign = Alignment.find("byTfsite", thisTFsite).first();
							if (thisAlign == null) {
								thisAlign = new Alignment(thisTFsite);
							}

							thisAlign.addEntry(speciesname, sequence);
							thisTFsite.tagAlign(thisAlign);
						}
					}
					reader.close();
					
				}
			}
		}
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
