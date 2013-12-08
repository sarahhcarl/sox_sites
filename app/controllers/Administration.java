package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import models.Alignment;
import models.TFsite;

import jobs.AddAllSeqs;
import jobs.AddDNaseData;
import jobs.AddEnhancerInfo;
import jobs.AddTFs;
import jobs.LoadDB;
import jobs.ParseAllFlylight;
import jobs.PrintFastaClade;
import jobs.averageCost;
import jobs.parsimonyCostNoPse;
import jobs.parsimonyCostSites;
import jobs.parsimonyCostAll;
import jobs.printAlignments;
import jobs.printSites;
import play.Logger;
import play.mvc.Controller;

public class Administration extends Controller {
	
	public static boolean jobRunning = false;

	public static void index() {
		render();
	}


	public static void createDb() {
		Logger.info("Creating DB...");
		new LoadDB().now();
		index();
	}
	
	public static void parseFlylight() {
		Logger.info("Adding all FlyLight enhancers...");
		new ParseAllFlylight().now();
		index();
	}
	
	public static void addEnhancerInfo() {
		Logger.info("Adding functional annotations to enhancers...");
		new AddEnhancerInfo().now();
		index();
	}
	
	public static void addTFs() {
		Logger.info("Adding other predicted TFs...");
		new AddTFs().now();
		index();
		
	}
	
	public static void addDNase() {
		Logger.info("Adding DNase-seq data...");
		new AddDNaseData().now();
		index();
	}
	
	public static void addAlignments() {
		Logger.info("Adding sequence alignments...");
		new AddAllSeqs().now();
		index();
	}

    public static void printAllFasta() {
        Logger.info("Printing all Dichaete alignments...");
        new printAlignments().now();
        index();
    }    
    
    public static void printSitesFasta() {
    	Logger.info("Printing TFsite alignments...");
    	new printSites().now();
    	index();
    }
    
    public static void printFastaClade() {
    	Logger.info("Printing alignments for defined clade...");
    	new PrintFastaClade().now();
    	index();
    }
    
    public static void parsimony() {
    	Logger.info("Calculating parsimony costs...");
    	new parsimonyCostSites().now();
    	Logger.info("Done.");
    	index();
    }
    
    public static void parsimonyAll() {
    	Logger.info("Calculating parsimony costs for all alignments...");
    	new parsimonyCostAll().now();
    	index();
    }
    
    public static void parsimonyNoPse() {
    	Logger.info("Calculating parsimony costs for all alignments excluding D. pseudo...");
    	new parsimonyCostNoPse().now();
    	index();
    }
    
    public static void avgParsimony() {
    	Logger.info("Calculating average parsimony costs over motif...");
    	new averageCost().now();
    	index();
    }
}
