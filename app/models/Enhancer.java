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
	
	private String chrom;
	private int startCoords;
	private int endCoords;
	
	public void setChrom(String chrom) {
		this.chrom = chrom;
	}
	
	public String getChrom() {
		return chrom;
	}
	
	public void setStart(int startCoords) {
		this.startCoords = startCoords;
	}
	
	public int getStart() {
		return startCoords;
	}
	
	public int getEnd() {
		return endCoords;
	}
	
	public void setEnd(int endCoords) {
		this.endCoords = endCoords;
	}
	
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
		tfsite.save();
	}
	
	public void tagExpStage(String stage){
		if (this.expressionStage.contains(stage)) {
		} else {
			this.expressionStage.add(stage);
			this.save();
		}	
	}
	
	public void tagExpSubset(String subset){
		if (this.expressionSubset.contains(subset)) {
		} else {
			this.expressionSubset.add(subset);
			this.save();
		}	
	}
	
		
}
