package models;
import play.db.jpa.Model;
import javax.persistence.*;

@Entity
public class Sequence extends Model {
	
	public Sequence (String seq, String speciesname, TFsite tfsite) {
		this.seq = seq;
		this.speciesname = speciesname;
		this.tfsite = tfsite;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public TFsite tfsite;
	
	public String seq;
	public String speciesname;
}
