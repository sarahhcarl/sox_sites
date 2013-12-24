package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.io.IOException;
import java.util.*;
import java.io.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import models.*;

public class Application extends Controller {

    public static void index() {
//    	List<TFsite> tfsites = TFsite.find("byTf", "D").fetch();
//    	Logger.info("Starting...");
//    	SortedSet<String> enhancers = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
//    	for (TFsite site : tfsites) {
//    		String e_name = site.enhancer.name;
//    		enhancers.add(e_name);
//    	}
//    	Logger.info("Done.");
        render();
    }
    
    public static void enhancers(int page) {
    	List<Enhancer> enhancers = Enhancer.find("order by name").from((page*100)-99).fetch(100);
    	render(enhancers, page);
    }
    
    public static void enhancersByName(String EnhancerInput) {
    	Logger.info(EnhancerInput);
    	Enhancer enhancer = Enhancer.find("byNameElike", EnhancerInput).first();
    	if (enhancer == null) {
    		Logger.info("Enhancer not found");
    	} else {
    		Logger.info("Enhancer is" + EnhancerInput);
    	}
    	render(enhancer);
    }
    
    public static void enhancersByInput(String soxBind, String soxTrans, String expStage, String expSubset, int page) {
    	if (page == 0) {
    		page = 1;
    	}
    	if (soxBind == null) {
    	} else {
	    	if (soxBind.equals("Dichaete unique")){
	    		soxBind = "Dunique";
	    	} else if (soxBind.equals("SoxN unique")){
	    		soxBind = "SoxNunique";
	    	} else if (soxBind.equals("Common")) {
	    		soxBind = "common";
	    	} else {
	    		soxBind = null;
	    	}
    	}	
    	Logger.info(soxBind);
    	Boolean transcomp = null;
    	if (soxTrans == null) {
    	} else {
    		if (soxTrans.equals("Transcompensation")){
    			transcomp = true;
    		} else if (soxTrans.equals("No transcompensation")) {
    			transcomp = false;
    		} else {
    			transcomp = null;
    		}
    	}
    	if (expStage == null) {	
    	} else {
	    	if (expStage.equals("GBE")){
	    		expStage = "GBE";
	    	} else if (expStage.equals("Stage 16")){
	    		expStage = "St16";
	    	} else {
	    		expStage = null;
	    	}
    	}
    	if (expSubset == null) {
    	} else {
	    	if (expSubset.equals("NBs")) {
	    		expSubset = "NB";
	    	} else if (expSubset.equals("Neurons")) {
	    		expSubset = "neurons";
	    	} else if (expSubset.equals("Midline")) {
	    		expSubset = "midline";
	    	} else {
	    		expSubset = null;
	    	}
    	}
    	Logger.info(expSubset);
    	List<Enhancer> enhancers = new ArrayList<>();
    	if (soxBind == null && transcomp == null && expStage == null && expSubset == null) {
    		Application.enhancers(1);
    	}
    	else if (soxBind != null && transcomp == null && expStage == null && expSubset == null) {
    		enhancers = Enhancer.find("bySoxBindPattern", soxBind).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp != null && expStage == null && expSubset == null) {
    		enhancers = Enhancer.find("byTranscomp", transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp == null && expStage != null && expSubset == null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st where st = ?", expStage).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp == null && expStage == null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionSubset as sb where sb = ?", expSubset).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp != null && expStage == null && expSubset == null) {
    		enhancers = Enhancer.find("bySoxBindPatternAndTranscomp", soxBind, transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp == null && expStage != null && expSubset == null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st where st = ? and e.soxBindPattern = ?", expStage, soxBind).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp == null && expStage == null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionSubset as sb where sb = ? and e.soxBindPattern = ?", expSubset, soxBind).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp != null && expStage != null && expSubset == null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st where st = ? and e.transcomp = ?", expStage, transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp != null && expStage == null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionSubset as sb where sb = ? and e.transcomp = ?", expSubset, transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp == null && expStage != null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st join e.expressionSubset as sb where st = ? and sb = ?", expStage, expSubset).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp != null && expStage != null && expSubset == null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st where st = ? and e.soxBindPattern = ? and e.transcomp = ?", expStage, soxBind, transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp != null && expStage == null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionSubset as sb where sb = ? and e.soxBindPattern = ? and e.transcomp = ?", expSubset, soxBind, transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp == null && expStage != null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st join e.expressionSubset as sb where st = ? and sb = ? and e.soxBindPattern = ?", expStage, expSubset, soxBind).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind == null && transcomp != null && expStage != null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st join e.expressionSubset as sb where st = ? and sb = ? and e.transcomp = ?", expStage, expSubset, transcomp).from((page*100)-99).fetch(100);
    	}
    	else if (soxBind != null && transcomp != null && expStage != null && expSubset != null) {
    		enhancers = Enhancer.find("select e from Enhancer e join e.expressionStage as st join e.expressionSubset as sb where st = ? and sb = ? and e.soxBindPattern = ? and e.transcomp = ?", expStage, expSubset, soxBind, transcomp).from((page*100)-99).fetch(100);
    	}
    	render(enhancers, soxBind, transcomp, expStage, expSubset, page);
    }
    
    
    public static void tfsitesByEnhancer(String enhancer, int page) {
    	Enhancer thisEnhancer = Enhancer.find("byName", enhancer).first();
    	System.out.println(enhancer);
    	List<TFsite> tfsites = TFsite.find("byEnhancer", thisEnhancer).from((page*100)-99).fetch(100);
    	//SortedSet<Alignment> alignments = new TreeSet<Alignment>();
    	for (TFsite site : tfsites) {
    		System.out.println(site);
    		System.out.println(site.alignment);
    		//Doesn't retain correct order
    		//Alignment thisAlign = Alignment.find("byTfsite", site).first();
	    	//if (thisAlign != null) {
	    	//	System.out.println("Alignment:" + thisAlign);
	    	//	alignments.add(thisAlign);
	    	//	}
    		}
    	//System.out.println("Alignments found:" + alignments.size());
    	render(tfsites, page, enhancer);
    }
    
    public static void alignmentByTf(TFsite tfsite) {
    	Alignment thisAlign = Alignment.find("byTfsite", tfsite).first();
    	render(thisAlign);
    }
    
   // public static void downloadBed(List<Enhancer> enhancers) {
   // 	for (Enhancer enhancer: enhancers) {
   // 		java.io.InputStream binaryData()
   // 		renderBinary(enhancer.chrom, "FlyLight.bed");
   // 	}
    //}
    
    public static void analyses() {
    	render();
    }
    
    public static void about() {
    	render();
    }
    
    public static void pairwise() {
    	render();
    }
    
    
    public static void rateOfLoss(List<TFsite> sites) {
    	//Do stuff
    }
    
    public static void rateOfGain(List<TFsite> sites) {
    	//Do stuff
    }
    

    

}