package models;

import play.db.jpa.Model;
import javax.persistence.*;

import java.util.*;

@Entity
public class Enhancer extends Model {
	
	public Enhancer(String name) {
		this.name = name;
		this.TFsites = new ArrayList<>();
	}

	public String name;
	
	@OneToMany(mappedBy="enhancer", cascade=CascadeType.ALL)
	public List<TFsite> TFsites;
		
}
