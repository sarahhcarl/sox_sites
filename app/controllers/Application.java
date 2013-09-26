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
    
    public static void pairwise() {
    	
    	//long totalSites = sites.size();
    	
    	//Specify which species is the reference
    	String nameSpecies = "dmel";
    	Species refSpecies = Species.find("byName", nameSpecies).first();
    	
    	//Get a list of TFsites that are present in the reference species
    	Query query = JPA.em().createQuery("SELECT t FROM TFsite t, Species s WHERE s.name = :nameSpecies AND s.id MEMBER OF t.species");
    	query.setParameter("nameSpecies", nameSpecies);
    	List<TFsite> refSites = query.getResultList();
    	
    	//Get all the other species we're interested in
    	List<Species> otherSpecies = Species.find("byNameNotEqual", nameSpecies).fetch();
    	
    	//Make an ArrayList to hold the pairwise ratio values
    	ArrayList<Long> pairwise = new ArrayList<Long>();
    	long numRefSites = refSites.size();
    	
    	//Get a list of TFsites that are present in both the reference species and each other species. Calculate the pairwise conservation ratio and store it in the ArrayList
    	for (Species currentSpecies : otherSpecies) {
    		Query newquery = JPA.em().createQuery("Select t FROM TFsite t, Species s WHERE s = :refSpecies AND s = :currentSpecies AND s.id MEMBER OF t.species");
    		newquery.setParameter("refSpecies", refSpecies);
    		newquery.setParameter("currentSpecies", currentSpecies);
    		List<TFsite> currentConserved = newquery.getResultList();
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