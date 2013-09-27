package jobs;

import play.jobs.*;
import play.Logger;
import java.io.*;

import models.Enhancer;
public class AddEnhancerInfo extends Job {
	
	public void doJob() throws IOException {
		
		//Set soxBindPattern as either common, Dunique or SoxNunique
		//If soxBindPattern is Dunique or SoxNunique, set transcomp as either true or false
		
		Logger.info("Adding Sox binding pattern info");
		
		BufferedReader reader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.SoxNDam.DDam.common.uniqueEnhancers.txt"));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String enhancerName = line;
			Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
			thisEnhancer.soxBindPattern = "common";
			thisEnhancer.transcomp = null;
			thisEnhancer.save();
		}
		reader.close();
		
		BufferedReader reader2 = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.DDam.unique.enhancers.txt"));
		line = null;
		while ((line = reader2.readLine()) != null) {
			String enhancerName = line;
			Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
			thisEnhancer.soxBindPattern = "Dunique";
			BufferedReader transcompreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.DDam.unique.SoxNtranscomp.enhancers.txt"));
			String newline = null;
			while ((newline = transcompreader.readLine()) != null) {
				String e = newline;
				if (e == enhancerName){
					thisEnhancer.transcomp = true;
				} else {
					thisEnhancer.transcomp = false;
				}	
			}
			transcompreader.close();
			thisEnhancer.save();
		}
		reader2.close();
		
		BufferedReader reader3 = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.SoxNDam.unique.enhancers.txt"));
		line = null;
		while ((line = reader3.readLine()) != null) {
			String enhancerName = line;
			Enhancer thisEnhancer = Enhancer.find("byName", enhancerName).first();
			thisEnhancer.soxBindPattern = "SoxNunique";	
			BufferedReader transcompreader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/CNS.all.in.SoxNDam.unique.Dtranscomp.enhancers.txt"));
			String newline = null;
			while ((newline = transcompreader.readLine()) != null) {
				String e = newline;
				if (e == enhancerName){
					thisEnhancer.transcomp = true;
				} else {
					thisEnhancer.transcomp = false;
				}	
			}
			transcompreader.close();
			thisEnhancer.save();
		}
		reader3.close();
		
		//Set expression as 
	}
}
