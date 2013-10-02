package jobs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import models.Enhancer;
import models.Species;
import models.TFsite;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

@OnApplicationStart
public class ParseAllFlylight extends Job {

	public void doJob() throws IOException {
		
		Logger.info("Adding Flylight enhancers...");
		int counter = 0;
		//Open spreadsheet
		BufferedReader reader = new BufferedReader(new FileReader("/home/sarah/utilities/play-1.2.7/sox_sites/data/FlyLight_all_short.csv"));
		String line = null;
		String lineName = null;
		String gene = null;
		Boolean st16scattered = false;
		Boolean st16largesubset = false;
		Boolean st163perhemi = false;
		Boolean st16smallsubset = false;
		Boolean st16deeplayer = false;
		Boolean st16superficial = false;
		Boolean st16EVEmedial = false;
		Boolean st16EVElateral = false;
		Boolean st16brain = false;
		Boolean st16midline = false;
		Boolean st16bodywall = false;
		Boolean st16gut = false;
		Boolean GBEany = false;
		Boolean GBEscattered = false;
		Boolean GBENBsubset = false;
		Boolean GBENBall = false;
		Boolean GBEneuronsubset = false;
		Boolean GBEneuronsall = false;
		Boolean GBEcolumns = false;
		Boolean GBEhead = false;
		Boolean GBEmidline = false;
		Boolean GBEbodywall = false;
		Boolean GBEgut = false;
		
		while ((line = reader.readLine()) != null) {
			counter++;
			Logger.info("Looking at " + counter + " out of 5005");
			if (counter%10==0) {
				flush(Enhancer.class);
			}
			if (counter > 0) {
				String[] parts = line.split("\\s");
				
				//Define each variable
				lineName = parts[0];
				gene = parts[2];
				st16scattered = parts[7].equals("X");
				st16largesubset = parts[8].equals("X");
				st163perhemi = parts[9].equals("X");
				st16smallsubset = parts[10].equals("X");
				st16deeplayer = parts[11].equals("X");
				st16superficial = parts[12].equals("X");
				st16EVEmedial = parts[13].equals("X");
				st16EVElateral = parts[14].equals("X");
				st16brain = parts[15].equals("X");
				st16midline = parts[16].equals("X");
				st16bodywall = parts[17].equals("X");
				st16gut = parts[18].equals("X");
				GBEany = parts[19].equals("X");
				GBEscattered = parts[20].equals("X");
				GBENBsubset = parts[21].equals("X");
				GBENBall = parts[22].equals("X");
				GBEneuronsubset = parts[23].equals("X");
				GBEneuronsall = parts[24].equals("X");
				GBEcolumns = parts[25].equals("X");
				GBEhead = parts[26].equals("X");
				GBEmidline = parts[27].equals("X");
				GBEbodywall = parts[28].equals("X");
				GBEgut = parts[29].equals("X");
				
				String name = gene + "." + lineName;
				
				//Create new enhancer if it doesn't exist
				Enhancer thisEnhancer = Enhancer.find("byName", name).first(); 
				if (thisEnhancer == null) {
					thisEnhancer = new Enhancer(name);
				}
				
				//tag enhancer with expression data
				if ((st16scattered == true) || (st16largesubset == true) || (st163perhemi == true) || (st16smallsubset == true) || (st16deeplayer == true) || (st16superficial == true) || (st16EVEmedial == true) || (st16EVElateral == true) || (st16brain == true) || (st16midline == true) || (st16bodywall == true) || (st16gut == true)) {
					thisEnhancer.tagExpStage("St16");
					if (st16scattered == true) {
						thisEnhancer.tagExpSubset("scattered");
					}
					if (st16largesubset == true) {
						thisEnhancer.tagExpSubset("CNSlargesubset");
					}
					if (st163perhemi == true) {
						thisEnhancer.tagExpSubset("upto3perhemiseg");
					}
					if (st16smallsubset == true) {
						thisEnhancer.tagExpSubset("CNSsmallsubset");
					}
					if (st16deeplayer == true) {
						thisEnhancer.tagExpSubset("CNSdeeplayer");
					}
					if (st16superficial == true) {
						thisEnhancer.tagExpSubset("CNSsuperficiallayer");
					}
					if (st16EVEmedial == true) {
						thisEnhancer.tagExpSubset("EVEmedial");
					}
					if (st16EVElateral == true) {
						thisEnhancer.tagExpSubset("EVElateral");
					}
					if (st16brain == true) {
						thisEnhancer.tagExpSubset("brain");
					}
					if (st16midline == true) {
						thisEnhancer.tagExpSubset("midline");
					}
					if (st16bodywall == true) {
						thisEnhancer.tagExpSubset("bodywall");
					}
					if (st16gut == true) {
						thisEnhancer.tagExpSubset("gut/internal");
					}
				}
				if (GBEany == true) {
					thisEnhancer.tagExpStage("GBE");
					if (GBEscattered == true) {
						thisEnhancer.tagExpSubset("scattered");
					}
					if (GBENBsubset == true) {
						thisEnhancer.tagExpSubset("NBsubset");
						thisEnhancer.tagExpSubset("NB");
					}
					if (GBENBall == true) {
						thisEnhancer.tagExpSubset("NBall");
						thisEnhancer.tagExpSubset("NB");
					}
					if (GBEneuronsubset == true) {
						thisEnhancer.tagExpSubset("neuronsubset");
						thisEnhancer.tagExpSubset("neurons");
					}
					if (GBEneuronsall == true) {
						thisEnhancer.tagExpSubset("neuronsall");
						thisEnhancer.tagExpSubset("neurons");
					}
					if (GBEcolumns == true) {
						thisEnhancer.tagExpSubset("columns/stripes");
					}
					if (GBEhead == true) {
						thisEnhancer.tagExpSubset("headregion");
					}
					if (GBEmidline == true) {
						thisEnhancer.tagExpSubset("midline");
					}
					if (GBEbodywall == true) {
						thisEnhancer.tagExpSubset("bodywall");
					}
					if (GBEgut == true) {
						thisEnhancer.tagExpSubset("gut/internal");
					}
				}
				thisEnhancer.save();
			}
		}
		reader.close();
	}
	
	private void flush(Class<?> type) {
		Logger.info("Flushing...");
		if (type == Enhancer.class){
			Enhancer.em().flush();
			Enhancer.em().clear();
		} 	
	}
}
