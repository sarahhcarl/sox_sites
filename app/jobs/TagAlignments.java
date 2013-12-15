package jobs;

import java.util.ArrayList;
import java.util.List;

import models.Alignment;
import models.TFsite;
import play.jobs.Job;
import play.Logger;

public class TagAlignments extends Job {
	
	public void doJob() {
		List<Alignment> alignments = Alignment.findAll();
		TFsite curTF = null;
		for (Alignment thisAlign: alignments) {
			curTF = thisAlign.tfsite;
			curTF.alignment = thisAlign;
			curTF.save();
		}
	Logger.info("Done");	
	}
	
}
