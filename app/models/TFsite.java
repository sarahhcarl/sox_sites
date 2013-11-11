package models;

import play.data.validation.Required;
import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class TFsite extends Model {

	public TFsite(Enhancer enhancer, String TF, String sequence, int startcoord, int endcoord, double wscore) {
		this.TF = TF;
		this.sequence = sequence;
		this.relstart = startcoord;
		this.relend = endcoord;
		this.wscore = wscore;
		this.species = new ArrayList<Species>();
		this.enhancer = enhancer;
		this.allseqs = new ArrayList<Sequence>();
	}

	public String sequence;
	public String TF;
	public int relstart;
	public int relend;
	public double wscore;
	
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Species> species;
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Enhancer enhancer;
	
	@OneToOne(mappedBy="tfsite", cascade=CascadeType.ALL)
	public Alignment alignment;
	
	@OneToMany(mappedBy="tfsite", cascade=CascadeType.ALL)
	public List<Sequence> allseqs;

	public void tagSpecies(Species species) {
		this.species.add(species);
		species.TFsites.add(this);
		species.save();
		
	}

	public void tagEnhancer(Enhancer enhancer) {
		this.enhancer = enhancer;
		enhancer.TFsites.add(this);
		enhancer.save();
		
	}
	
	public void tagSeq(Sequence sequence) {
		this.allseqs.add(sequence);
		sequence.tfsite = this;
		sequence.save();
	}
	
	public void tagAlign(Alignment alignment) {
		this.alignment = alignment;
		this.save();
	}
	
}
