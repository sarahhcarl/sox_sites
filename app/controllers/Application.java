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
        render();
    }
    
    public static void enhancers(int page) {
    	List<Enhancer> enhancers = Enhancer.find("order by name").from((page*100)-99).fetch(100);
    	render(enhancers, page);
    }
    
    public static void enhancersByName(String name) {
    	Enhancer enhancer = Enhancer.find("byName", name).first();
    	render(enhancer);
    }
    
    public static void enhancersByInput(String soxBind, String expStage, String expSubset) {
    	if (soxBind.equals("Dichaete unique")){
    		soxBind = "D_unique";
    	} else if (soxBind.equals("SoxN unique")){
    		soxBind = "SoxN_unique";
    	} else if (soxBind.equals("Common")) {
    		soxBind = "common";
    	} else if (soxBind.equals("All")) {
    		soxBind = null;
    	}
    	if (expStage.equals("GBE")){
    		expStage = "GBE";
    	} else if (expStage.equals("Stage 16")){
    		expStage = "St16";
    	} else if (expStage.equals("All")){
    		expStage = null;
    	}
    	if (expSubset.equals("NBs")) {
    		expSubset = "NB";
    	} else if (expSubset.equals("Neurons")) {
    		expSubset = "neurons";
    	} else if (expSubset.equals("Midline")) {
    		expSubset = "midline";
    	} else if (expSubset.equals("All")) {
    		expSubset = null;
    	}
    	List<Enhancer> enhancers = Enhancer.find(
    			"select e from Enhancer e where e.soxBindPattern = soxBind and expStage member of e.expressionStage and expSubset member of e.expressionSubset"
    			).fetch(20);
    	render(enhancers);
    }
    
    public static void tfsites(int page) {
    	List<TFsite> tfsites = TFsite.find("order by Tf").from(100/(page*100)).fetch(100);
    	render(tfsites, page);
    }
    
    public static void tfsitesByTF(String TF) { 
    	List<TFsite> tfsites = TFsite.find("byTf", TF).fetch(25);
    	render(tfsites);
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