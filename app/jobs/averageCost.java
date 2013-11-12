package jobs;

import java.util.ArrayList;
import java.util.List;

import models.Alignment;
import models.TFsite;
import play.jobs.Job;

public class averageCost extends Job {

	public void doJob() {
		//Set TF of interest
		String tf = "#";
		
		//Get all sites for that TF
		List<TFsite> mysites = TFsite.find("byTf", tf).fetch();
		
		//Get all corresponding alignments, get length of site
		int siteLength;
		List<Alignment> myaligns = new ArrayList<Alignment>();
		for (TFsite site : mysites) {
			String seq = site.sequence;
			siteLength = seq.length();
			Alignment currentAlign = Alignment.find("byTfsite", site).first();
			myaligns.add(currentAlign);
		}
		
		
	}
	
}
