package jobs;

import java.io.IOException;

import models.Alignment;
import models.TFsite;
import play.Logger;
import play.jobs.Job;

public class printSites extends Job {

	public void doJob() throws IOException {
		TFsite mysite = TFsite.findById(255544L);
        Logger.info("Site found");
        System.out.println(mysite);
        Alignment currentAlign = Alignment.find("byTfsite", mysite).first();
        if (currentAlign != null) {
        	Logger.info("Alignment found");
        	System.out.println(currentAlign);
        } else if (currentAlign == null) {
        	Logger.info("Alignment is null");
        }
        currentAlign.printFastaSites();
		
	}
	
}
