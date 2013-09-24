package jobs;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


import models.Species;
import models.TFsite;

import play.Logger;
import play.jobs.Job;

public class LoadDB extends Job {

	public void doJob() throws NumberFormatException, IOException{
		Logger.info("loading DB now...");
		//Read flat file
		BufferedReader reader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Enhancers/rsat/D_scan/Abd-B.35C08_Dscan.ft"));
			String line = null;
			String speciesname = null;
			String sequence = null;
			int start = 0;
			double wscore = 0;
			while ((line = reader.readLine()) != null) {
				String[] parts = line.split("\\s");
				String first = parts[0];
				if ((first != ";") && (first != "#seq_id")) {
					speciesname = parts[0];
					sequence = parts[6];
					start = Integer.parseInt(parts[4]);
					wscore = Integer.parseInt(parts[7]);
				}
				
				Species newSpecies = null;
				newSpecies = Species.find("byname", speciesname).first();
				if (newSpecies == null) {
					newSpecies = new Species(speciesname);
					newSpecies.save();
				}
				
				TFsite siteOfInterest = null;
				siteOfInterest = TFsite.find("bystart", start).first();
				if (siteOfInterest == null) {
					siteOfInterest = new TFsite(speciesname, "Dichaete", sequence, start, wscore);
					siteOfInterest.save();
				} else {
					siteOfInterest.tagSpecies(newSpecies);
				}
			}
			reader.close();

		}

	}