package jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Query;

import models.Enhancer;
import models.Species;
import models.TFsite;
import play.Logger;
import play.db.jpa.JPA;
import play.jobs.*;

//@OnApplicationStart
public class AddTFs extends Job {

	public void doJob() throws NumberFormatException, IOException {
		
		//Set filepath and TF name for each TF to be added
		
		int counter = 0;
		File dir = new File("/home/sarah/utilities/play-1.2.7/sox_sites/data/vnd_scan_90/");
		String TF = "vnd";
		
		for (File childfile : dir.listFiles()) {
			counter++;
			Logger.info("Counter: " + counter);
			if (counter%10==0) {
				flush(TFsite.class);
				flush(Enhancer.class);
				flush(Species.class);
			}
			Pattern p1 = Pattern.compile("/home/sarah/utilities/play-1.2.7/sox_sites/data/" + TF + "_scan_90/(.+)_(.+).ft");
			Matcher m1 = p1.matcher(childfile.getPath());
			m1.lookingAt();
			String eName = m1.group(1);
			Enhancer enhancer = Enhancer.find("byName", eName).first();
			
			BufferedReader reader = new BufferedReader(new FileReader(childfile));
			String line = null;
			String speciesname = null;
			String sequence = null;
			int relstart = 0;
			int relend = 0;
			double wscore = 0;
			while ((line = reader.readLine()) != null) {
				if ((line.indexOf(";") == -1) && (line.indexOf("#seq_id") == -1)) {
					String[] parts = line.split("\\s");
					speciesname = parts[0];
					sequence = parts[6];
					relstart = Integer.parseInt(parts[4]);
					relend = Integer.parseInt(parts[5]);
					wscore = Double.parseDouble(parts[7]);
	
					Species currentSpecies = Species.find("byName", speciesname).first();
					TFsite siteOfInterest = null;
					Query newquery = JPA.em().createQuery("Select t from TFsite t where t.enhancer = :enhancer AND t.TF = :TF AND t.relstart = :relstart");
					newquery.setParameter("enhancer", enhancer);
					newquery.setParameter("TF", TF);
					newquery.setParameter("relstart", relstart);
					List results = newquery.getResultList();
					if (results.size() > 0) {
						siteOfInterest = (TFsite) results.get(0);
					}	
					if (siteOfInterest == null) {
						siteOfInterest = new TFsite(enhancer, TF, sequence, relstart, relend, wscore);
					} 
					siteOfInterest.tagSpecies(currentSpecies);
					siteOfInterest.save();
					//System.out.printf("TFsite %s saved%n", siteOfInterest.sequence);
	
					enhancer.tagTF(siteOfInterest);
					enhancer.save();
				}
			}
			reader.close();
		}
		
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
		}

	}
}
