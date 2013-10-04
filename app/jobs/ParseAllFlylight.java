package jobs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

import models.Enhancer;
import models.Species;
import models.TFsite;

import play.Logger;
import play.jobs.Job;
import play.jobs.OnApplicationStart;

//@OnApplicationStart
public class ParseAllFlylight extends Job {

	public void doJob() throws IOException {

		Logger.info("Adding Flylight enhancers...");
		int counter = 0;

		String chrom = null;
		int startCoord = 0;
		int endCoord = 0;
		String name = null;

		List<String> fileNames = Arrays.asList("GBE.CNS.all.bed", "GBE.NBs.all.bed", "GBE.Neurons.all.bed", "GBE.Midline.all.bed", "St16.CNS.all.bed", "St16.Midline.all.bed");
		for (String fileName : fileNames) {
			//Open each bed file, read in lines, create enhancers
			BufferedReader reader = new BufferedReader(new FileReader("/home/sarah/utilities/play-1.2.7/sox_sites/data/" + fileName));
			String line = null;
			while ((line = reader.readLine()) != null) {
				counter++;
				Logger.info("Looking at " + counter);
				if (counter%10==0) {
					flush(Enhancer.class);
					Logger.info("Flushing...");
				}

				String[] parts = line.split("\\s");
				chrom = parts[0];
				startCoord = Integer.parseInt(parts[1]);
				endCoord = Integer.parseInt(parts[2]);
				name = parts[3];
				Enhancer thisEnhancer = null;
				thisEnhancer = Enhancer.find("byName", name).first();
				if (thisEnhancer == null) {
					thisEnhancer = new Enhancer(name);
				}
				thisEnhancer.chrom = chrom;
				thisEnhancer.startCoords = startCoord;
				thisEnhancer.endCoords = endCoord;
				
				Pattern p1 = Pattern.compile("(.+).(.+).all.bed");
				Matcher m1 = p1.matcher(fileName);
				m1.matches();
				if (m1.group(1).equals("GBE")){
					thisEnhancer.tagExpStage("GBE");
				} else if (m1.group(1).equals("St16")) {
					thisEnhancer.tagExpStage("St16");
				}
				if (m1.group(2).equals("CNS")) {
					thisEnhancer.tagExpSubset("CNS");
				} else if (m1.group(2).equals("NBs")) {
					thisEnhancer.tagExpSubset("NB");
				} else if (m1.group(2).equals("Neurons")) {
					thisEnhancer.tagExpSubset("neurons");
				} else if (m1.group(2).equals("Midline")) {
					thisEnhancer.tagExpSubset("midline");
				}
				thisEnhancer.save();
			}
			reader.close();
		}
	}	


	private void flush(Class<?> type) {
		Logger.info("Flushing...");
		if (type == Enhancer.class){
			Enhancer.em().flush();
			Enhancer.em().clear();
		} 	
	}
}
