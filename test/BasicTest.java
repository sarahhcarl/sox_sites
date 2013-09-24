import org.junit.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import play.Logger;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteDatabase();
	}

	@Test
	public void loadEntities() throws NumberFormatException, IOException {
		//Read flat file
		BufferedReader reader = new BufferedReader(new FileReader("/home/sarah/Documents/PhD/Janelia/Enhancers/rsat/D_scan/Abd-B.35C08_Dscan.ft"));
		String line = null;
		String speciesname = null;
		String sequence = null;
		int start = 0;
		double wscore = 0;
		while ((line = reader.readLine()) != null) {
			if ((line.indexOf(";") == -1) && (line.indexOf("#seq_id") == -1)) {
				String[] parts = line.split("\\s");
				speciesname = parts[0];
				sequence = parts[6];
				start = Integer.parseInt(parts[4]);
				wscore = Double.parseDouble(parts[7]);

				Species newSpecies = null;
				newSpecies = Species.find("byName", speciesname).first();
				if (newSpecies == null) {
					newSpecies = new Species(speciesname);
					newSpecies.save();
				}

				TFsite siteOfInterest = null;
				siteOfInterest = TFsite.find("byStart", start).first();
				if (siteOfInterest == null) {
					siteOfInterest = new TFsite(speciesname, "Dichaete", sequence, start, wscore);
					siteOfInterest.tagSpecies(newSpecies);
					siteOfInterest.save();
				} else {
					siteOfInterest.tagSpecies(newSpecies);
				}
			}
		}
		reader.close();
		
		//Test that objects were created properly
		assertEquals(9, TFsite.count());
		assertEquals(7, Species.count());
	}

}
