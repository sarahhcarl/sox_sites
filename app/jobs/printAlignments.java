package jobs;

import java.util.ArrayList;
import java.util.List;

import models.Alignment;
import models.TFsite;
import play.Logger;
import play.jobs.Job;

public class printAlignments extends Job {
    
    public void doJob() {
            TFsite mysite = TFsite.findById(250998L);
            Logger.info("Site found");
            System.out.println(mysite);
            Alignment currentAlign = Alignment.find("byTfsite", mysite).first();
            if (currentAlign != null) {
            	Logger.info("Alignment found");
            	System.out.println(currentAlign);
            } else if (currentAlign == null) {
            	Logger.info("Alignment is null");
            }
            currentAlign.printFasta();
    }
    
}
