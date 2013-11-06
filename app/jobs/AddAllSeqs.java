package jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import models.Enhancer;
import models.Species;
import models.TFsite;
import play.Logger;
import play.jobs.Job;

public class AddAllSeqs extends Job {

	public void doJob() {
		
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
					}
					Pattern p1 = Pattern.compile("/home/sarah/utilities/play-1.2.7/sox_sites/data/" + TF + "_scan90/(.+)_(.+).ft");
					Matcher m1 = p1.matcher(childfile.getPath());
					m1.lookingAt();
					String enhancer = m1.group(1);
					
					BufferedReader reader = new BufferedReader(new FileReader(childfile));
					String line = null;
					String speciesname = null;
					String sequence = null;
					
					//Read each line by line
					while ((line = reader.readLine()) != null) {
						if ((line.indexOf(";") == -1) && (line.indexOf("#seq_id") == -1)) {
							String[] parts = line.split("\\s");
							speciesname = parts[0];
							sequence = parts[6];
							Species thisSpecies = Species.find("byName", speciesname).first();
							
							//TODO: Write query to find this particular TF site
							TFsite thisTFsite = TFsite.find()		
							Sequence newsequence(sequence, thisSpecies, tfsite)
		
	}
	
}

	private void flush(Class<TFsite> class1) {
		// TODO Auto-generated method stub
		
	}
