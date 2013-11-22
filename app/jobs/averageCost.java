package jobs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import models.Alignment;
import models.Species;
import models.TFsite;
import play.Logger;
import play.jobs.Job;

public class averageCost extends Job<float[]> {

	public float[] doJobWithResult() {
		//Set TF of interest
		String tf = "SoxN";
		//Species mySpecies = Species.find("byName", "dmel").first();
		
		//Get all sites for that TF
		List<TFsite> mysites = TFsite.find("byTf", tf).fetch();
		
		//Get all corresponding alignments, get length of site
		int siteLength=0;
		List<Alignment> myaligns = new ArrayList<Alignment>();
		for (TFsite site : mysites) {
			//if (site.species.contains(mySpecies)) {
				String seq = site.sequence;
				siteLength = seq.length();
				Alignment currentAlign = Alignment.find("byTfsite", site).first();
				myaligns.add(currentAlign);
			//}	
		}
		
		//should be float not int!
		float[] avgCosts = new float[siteLength];
		int looper=0;
		for (looper=0; looper<siteLength; looper++) {	
			float totalScore=0;
			float count=0;
			for (Alignment align : myaligns) {
				if (align.strand.equals("D")) {
					totalScore = totalScore + align.parsimonyCosts[looper];
					count++;
				} else if (align.strand.equals("R")) {
					totalScore = totalScore + align.parsimonyCosts[siteLength-looper-1];
				}
			}
			float finalCost = totalScore / count;
			avgCosts[looper] = finalCost;
		}
		System.out.println(tf);
		System.out.println(Arrays.toString(avgCosts));
		return avgCosts;
	}
}
