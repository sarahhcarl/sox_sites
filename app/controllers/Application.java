package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import org.hibernate.validator.constraints.Length;

import models.*;

public class Application extends Controller {

    public static void index() {
        render();
    }
    
    public static void pairwise() {
    	//long totalSites = sites.size();
    	String nameSpecies = "dmel";
    	Species refSpecies = Species.find("byName", nameSpecies).first();
    	List<TFsite> refSites = TFsite.find(
    			"select t from tfsite t, tfsite_species ts, species s" +
    			"where s.name = nameSpecies AND s.id = ts.species_id AND t.id = ts.tfsites_id").fetch();
    	List<Species> otherSpecies = Species.find("byNameNotEqual", refSpecies).fetch();
    	ArrayList<Long> pairwise = new ArrayList<Long>();
    	long numRefSites = refSites.size();
    	for (Species currentSpecies : otherSpecies) {
    		List<TFsite> currentConserved = TFsite.find("species", refSpecies, currentSpecies).fetch();
    		long numConserved = currentConserved.size();
    		long ratioPairwise = numConserved / numRefSites;
    		pairwise.add(ratioPairwise);
    	}
    	render(refSpecies, pairwise);
    }
    
    public static void rateOfLoss(List<TFsite> sites) {
    	//Do stuff
    }
    
    public static void rateOfGain(List<TFsite> sites) {
    	//Do stuff
    }
    
    

}