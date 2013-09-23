package models;

import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class Species extends Model {

	public Species(String name) {
		this.name = name;
		this.TFsites = new ArrayList<>();
	}

	public String name;
	
	@ManyToMany(mappedBy="species", cascade=CascadeType.ALL)
	public List<TFsite> TFsites;
}
