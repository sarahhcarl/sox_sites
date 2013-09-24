package models;

import play.data.validation.Required;
import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class TFsite extends Model {

	public TFsite(Enhancer enhancer, String speciesname, String TF, String sequence, int start, double wscore) {
		this.TF = TF;
		this.sequence = sequence;
		this.start = start;
		this.wscore = wscore;
		this.species = new ArrayList<Species>();
		this.speciesname = speciesname;
		this.enhancer = enhancer;
	}

	public String speciesname;
	public String sequence;
	public String TF;
	public int start;
	public double wscore;
	
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Species> species;
	
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
