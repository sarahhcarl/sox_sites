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
	
	@OneToMany(mappedBy="enhancer", cascade=CascadeType.ALL)
	public List<TFsite> TFsites;
	
	public void tagTF(TFsite tfsite) {
		this.TFsites.add(tfsite);
		this.save();
		tfsite.enhancer = this;
		tfsite.save();
	}
		
}
