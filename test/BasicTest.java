import org.junit.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jobs.AddEnhancerInfo;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {

	@Before
	public void setup() {
		Fixtures.deleteDatabase();
	}

	//TODO: Figure out how to grab enhancer name from input file, automate loading of input files

	@Test
	public void loadEntities() throws NumberFormatException, IOException {
		//Start off by creating one of each class to create the relations
		Species firstSpecies = new Species("test");
		Enhancer firstEnhancer = new Enhancer("test");
		TFsite firstSite = new TFsite(firstEnhancer, "test", "test", 450, 3.4);

		//Read flat file
		File dir = new File("/home/sarah/utilities/play-1.2.7/sox_sites/test/testdata/");
		//for (File childdir : dir.listFiles()) {
		//System.out.println(childdir.getName());
		//Pattern p = Pattern.compile("(.+)_scan90");
		//Matcher m = p.matcher(childdir.getName());
		//m.lookingAt();
		//String TF = m.group();
		for (File childfile : dir.listFiles()) {
			System.out.println(childfile.getName());
			Pattern p1 = Pattern.compile("/home/sarah/utilities/play-1.2.7/sox_sites/test/testdata/(.+)_(.+).ft");
			Matcher m1 = p1.matcher(childfile.getPath());
			m1.lookingAt();
			Enhancer enhancer = new Enhancer(m1.group(1));
			enhancer.save();
			String TF = "D";

			BufferedReader reader = new BufferedReader(new FileReader(childfile));
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
					siteOfInterest = TFsite.find("byEnhancerAndTFAndStart", enhancer, TF, start).first();
					if (siteOfInterest == null) {
						siteOfInterest = new TFsite(enhancer, TF, sequence, start, wscore);
					} 
					siteOfInterest.tagSpecies(newSpecies);
					siteOfInterest.save();

					enhancer.tagTF(siteOfInterest);
					enhancer.save();
				}
			}
			reader.close();
		}	


		firstSpecies.delete();
		firstEnhancer.delete();
		firstSite.delete();

		//Test that objects were created properly
		assertEquals(7, Species.count());
	}
	
	@Test
	public void annotateEnhancers() {
		new AddEnhancerInfo().now();
		System.out.println("Annotating enhancers");
		
		//Test annotations
		assertNotNull(Enhancer.find("byExpressionStage", "GBE"));
		assertNotNull(Enhancer.find("byExpressionSubset", "neurons"));
		
	}

}

