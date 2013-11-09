package controllers;

import java.util.Iterator;

import models.Alignment;
import models.TFsite;

import jobs.AddAllSeqs;
import jobs.LoadDB;
import jobs.printAlignments;
import play.Logger;
import play.mvc.Controller;

public class Administration extends Controller {
	
	public static boolean jobRunning = false;

	public static void index() {
		render();
	}


	public static void createDb() {
		Logger.info("Creating DB...");
		//new LoadDb().now();
		index();
	}
	
	public static void addAlignments() {
		Logger.info("Adding sequence alignments...");
		new AddAllSeqs().now();
		index();
	}
	
	public static void printFasta() {
		Logger.info("Printing all Dichaete site alignments...");
		new printAlignments().now();
		index();
		
	}
}
