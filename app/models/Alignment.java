package models;

import java.util.HashMap;
import java.util.Iterator;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Alignment extends Model {
	
	public Alignment(TFsite tfsite) {
		this.tfsite = tfsite;
		this.align = new HashMap();
	}
	
	public TFsite tfsite;
	public HashMap<String, String> align;
	
	public void addEntry(String speciesname, String sequence) {
		this.align.put(speciesname, sequence);
		this.save();
	}
	
	public void printFasta() {
		Iterator<String> keySetIterator = align.keySet().iterator();
		while (keySetIterator.hasNext()) {
			String species = keySetIterator.next();
			System.out.println(">" + species);
			System.out.println(align.get(species));
		}	
	}
		
	public void parsimonyCost() {
		// Calculate parsimony cost for each nucleotide in the alignment
	}


}
