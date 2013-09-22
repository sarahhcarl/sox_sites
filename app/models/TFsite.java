package models;

import play.data.validation.Required;
import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class TFsite extends Model {
	
	public TFsite(String TF, String sequence, int start, int end) {
		this.TF = TF;
		this.sequence = sequence;
		this.start = start;
		this.end = end;
		this.species = new ArrayList<>();
	}

	@Required
	public String sequence;
	
	@Required
	public String TF;
	
	@Required
	@ManyToMany(cascade=CascadeType.ALL)
	public List<Species> species;
	
	@Required
	public int start;
	
	@Required
	public int end;
	
	@Required
	@ManyToOne(cascade=CascadeType.ALL)
	public Enhancer enhancer;
	
}
