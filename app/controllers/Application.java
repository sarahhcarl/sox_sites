package controllers;

import play.*;
import play.db.jpa.JPA;
import play.mvc.*;

import java.io.IOException;
import java.util.*;

import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

import models.*;

public class Application extends Controller {

    public static void index() {
    	List<TFsite> tfsites = TFsite.find("byTf", "D").fetch();
    	SortedSet<String> enhancers = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
    	for (TFsite site : tfsites) {
    		String e_name = site.enhancer.name;
    		enhancers.add(e_name);
    	}
        render(enhancers);
    }
    
    public static void enhancers(int page) {
    	List<Enhancer> enhancers = Enhancer.find("order by name").from((page*100)-99).fetch(100);
    	render(enhancers, page);
    }
    
    public static void enhancersByName(String name) {
    	Logger.info(name);
    	Enhancer enhancer = Enhancer.find("byName", name).first();
    	if (enhancer == null) {
    		Logger.info("Enhancer not found");
    	} else {
    		Logger.info("Enhancer is" + name);
    	}
    	render(enhancer);
    }
    
    public static void enhancersByInput(String soxBind, String expStage, String expSubset) {
    	if (soxBind.equals("Dichaete unique")){
    		soxBind = "Dunique";
    	} else if (soxBind.equals("SoxN unique")){
    		soxBind = "SoxNunique";
    	} else if (soxBind.equals("Common")) {
    		soxBind = "common";
    	} else if (soxBind.equals("All")) {
    		soxBind = null;
    	}
    	Logger.info(soxBind);
    	if (expStage.equals("GBE")){
    		expStage = "GBE";
    	} else if (expStage.equals("Stage 16")){
    		expStage = "St16";
    	} else if (expStage.equals("All")){
    		expStage = null;
    	}
    	Logger.info(expStage);
    	if (expSubset.equals("NBs")) {
    		expSubset = "NB";
    	} else if (expSubset.equals("Neurons")) {
    		expSubset = "neurons";
    	} else if (expSubset.equals("Midline")) {
    		expSubset = "midline";
    	} else if (expSubset.equals("All")) {
    		expSubset = null;
    	}
    	Logger.info(expSubset);
    	List<Enhancer> enhancers = Enhancer.find("bySoxBindPattern", soxBind).fetch(20);
    	render(enhancers);
    }
    
    
    public static void tfsitesByEnhancer(String enhancer, int page) {
    	Enhancer thisEnhancer = Enhancer.find("byName", enhancer).first();
    	List<TFsite> tfsites = TFsite.find("enhancer", thisEnhancer).from(100/(page*100)).fetch(100);
    	render(tfsites, page, enhancer);
    }
    
    public static void alignmentByTf(TFsite tfsite) {
    	Alignment thisAlign = Alignment.find("byTfsite", tfsite).first();
    	render(thisAlign);
    }
    
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