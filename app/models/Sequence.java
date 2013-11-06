package models;
import play.db.jpa.Model;
import javax.persistence.*;

@Entity
public class Sequence extends Model {
	
	public Sequence (String seq, Species species, TFsite tfsite) {
		this.seq = seq;
		this.species = species;
		this.tfsite = tfsite;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public TFsite tfsite;
	
	public String seq;
	public Species species;
}
