package jobs;

import java.util.List;

import models.Alignment;
import models.TFsite;
import play.Logger;
import play.jobs.Job;

public class parsimonyCostNoPse extends Job {

	public void doJob() {
		
		String TF = "D";
		
		Logger.info("Job started");
		
		List<TFsite> mysites = TFsite.find("byTf", TF).fetch();
		Logger.info("Sites found");
		
		for (TFsite mysite : mysites) {
			Logger.info(mysite.toString());
			Alignment currentAlign = Alignment.find("byTfsite", mysite).first();
			if (currentAlign != null) {
				Logger.info("Alignment found");
				System.out.println(currentAlign);
			} else if (currentAlign == null) {
				Logger.info("Alignment is null");
			}
			currentAlign.parsimonyCostNoPse();
		}
	}
}

