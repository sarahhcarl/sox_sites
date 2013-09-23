package models;

import play.data.validation.Required;
import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class TFsite extends Model {

	public TFsite(String TF, String sequence, int start, double wscore) {
		this.TF = TF;
		this.sequence = sequence;
		this.start = start;
		this.wscore = wscore;
		this.species = new ArrayList<>();
	}

	public String sequence;
	public String TF;
	
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Species> species;
	
	public int start;
	public double wscore;
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Enhancer enhancer;

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
	
}
