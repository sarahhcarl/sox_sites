package jobs;

import java.util.ArrayList;
import java.util.List;

import models.Alignment;
import models.Species;
import models.TFsite;
import play.Logger;
import play.jobs.Job;

public class parsimonyCostNoPse extends Job {

	public void doJob() {
		
		//Select TF of interest
		String TF = "SoxN";
		
		//Select species in which site must be present
		Species mySpecies = Species.find("byName", "dmel").first();
		Logger.info("Job started");
		
		//Get sites
		List<TFsite> mysites = TFsite.find("byTf", TF).fetch();
		Logger.info("Sites found");
		
		for (TFsite mysite : mysites) {
			//Check if site is present in species of interest
			if (mysite.species.contains(mySpecies)) {
				Logger.info(mysite.toString());
				//Get alignment
				Alignment currentAlign = Alignment.find("byTfsite", mysite).first();
				if (currentAlign != null) {
					Logger.info("Alignment found");
					System.out.println(currentAlign);
				} else if (currentAlign == null) {
					Logger.info("Alignment is null");
				}
				//Call method to calculate parsimony cost
				currentAlign.parsimonyCostNoPse();
			}	
		}
		Logger.info("Finished calculating scores.");
	}
}

