package models;

import play.db.jpa.Model;
import javax.persistence.*;

@Entity
public class DNase_site extends Model {

	public DNase_site(String chrom, int startcoord, int endcoord, String stage) {
		this.chrom = chrom;
		this.startcoord = startcoord;
		this.endcoord = endcoord;
		this.stage = stage;
	}
	
	public String chrom;
	public int startcoord;
	public int endcoord;
	public String stage;
}
