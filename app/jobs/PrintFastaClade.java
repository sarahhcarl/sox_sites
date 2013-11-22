package jobs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Alignment;
import models.Species;
import models.TFsite;

import play.Logger;
import play.jobs.Job;

public class PrintFastaClade extends Job {

	public void doJob() throws IOException{
		//Set ancestral node and TF
		String ancestralNode = "#3#";
		String TF = "D";
		List<String> allNodes = new ArrayList<String>();
		
		Species mySpecies = Species.find("byName", ancestralNode).first();
		
		List<TFsite> mySites = TFsite.find("byTf", TF).fetch();
		for (TFsite curSite : mySites) {
			if (curSite.species.contains(mySpecies)) {
				Alignment curAlign = Alignment.find("byTfsite", curSite).first();
				if (ancestralNode.equals("#3#")) {
					allNodes.add("dmel");
					allNodes.add("dsim");
					allNodes.add("dyak");
					allNodes.add("dpse");
				} else if (ancestralNode.equals("#2#")) {
					allNodes.add("dmel");
					allNodes.add("dsim");
					allNodes.add("dyak");
				} else if (ancestralNode.equals("#1#")) {
					allNodes.add("dmel");
					allNodes.add("dsim");
				}
				curAlign.printFastaClade(allNodes);
			}
		}
		Logger.info("Done printing fasta");
	}
}
