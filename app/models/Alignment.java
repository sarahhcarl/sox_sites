package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.persistence.*;

import play.db.jpa.Model;

@Entity
public class Alignment extends Model {
	
	public Alignment(TFsite tfsite) {
		this.tfsite = tfsite;
		this.align = new HashMap();
	}
	
	@OneToOne
	public TFsite tfsite;
	
	public HashMap<String, String> align;
	
	public int[] parsimonyCosts;
	
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
		//Iterate over the hashmap to the first value in order to get the sequence length
		int nodes = align.size();
		if (nodes == 7) {
			int looper;
			Iterator<String> keyIterator = align.keySet().iterator();
			String species = keyIterator.next();
			String sequence = align.get(species);
			int sites = sequence.length();
			parsimonyCosts = new int[sites];

			//Iterate over each position in the motif
			for (looper=0; looper<sites; looper++) {	
				int cost=0;
				//Then get the nucleotide at that position in each species and calculate the cost
				String mel_nt = align.get("dmel").substring(looper, looper+1);
				String sim_nt = align.get("dsim").substring(looper, looper+1);
				String yak_nt = align.get("dyak").substring(looper, looper+1);
				String pse_nt = align.get("dpse").substring(looper, looper+1);
				String node_1;
				String node_2;
				String node_3;

				if (mel_nt.contains(sim_nt)) {
					node_1 = mel_nt;	
				} else {
					cost++;
					node_1 = mel_nt + sim_nt;
				}
				if (node_1.contains(yak_nt)) {
					node_2 = yak_nt;
				} else {
					cost++;
					node_2 = node_1 + yak_nt;
				}
				if (node_2.contains(pse_nt)) {
					node_3 = pse_nt;
				} else {
					cost++;
					node_3 = node_2 + pse_nt;
				}
				parsimonyCosts[looper] = cost;
				this.save();
			}
			System.out.println(Arrays.toString(parsimonyCosts));
		} else {
			System.out.println("Not enough sequences present in alignment.");
		}
		//return parsimonyCosts;
		System.out.println("Done.");
	}
}
