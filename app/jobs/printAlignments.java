package jobs;

import java.util.List;

import models.Alignment;
import models.TFsite;
import play.jobs.Job;

public class printAlignments extends Job {
	
	public void doJob() {
		List<TFsite> mysites = TFsite.find("byTf", "D").fetch();
		for (TFsite site : mysites) {
			Alignment currentAlign = Alignment.find("byTfsite", site).first();
			currentAlign.printFasta();
		}
	}

}
