package models;

import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class Enhancer extends Model {

	
	public Enhancer(String name) {
		this.name = name;
		this.TFsites = new ArrayList<TFsite>();
	}

	public String name;
	
	@ElementCollection
	public List<String> expressionStage = new ArrayList<String>();
	
	@ElementCollection
	public List<String> expressionSubset = new ArrayList<String>();

	public String soxBindPattern;
	public Boolean transcomp;
	
	@OneToMany(mappedBy="enhancer", cascade=CascadeType.ALL)
	public List<TFsite> TFsites;
	
	//TODO changed
	public void tagTF(TFsite tfsite) {
		this.TFsites.add(tfsite);
		//this.save();
		tfsite.enhancer = this;
		//tfsite.save();
	}
	
	public void tagExpStage(String stage){
		this.expressionStage.add(stage);
		this.save();
	}
	
	public void tagExpSubset(String subset){
		this.expressionSubset.add(subset);
		this.save();
	}
	
		
}
