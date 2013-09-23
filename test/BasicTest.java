import org.junit.*;

import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
	
	@Before
	public void setup() {
		Fixtures.deleteDatabase();
	}

    @Test
    public void createEntities() {
    	
    	//Create and save some test entities
    	
    	TFsite site1 = new TFsite("Dichaete", "AACAAG", 302, 4.5).save();
    	
    	Enhancer enhancer1 = new Enhancer("Abd-B.35C08").save();
    	
    	Species mel = new Species("Drosophila melanogaster").save();
    	Species yak = new Species("Drosophila yakuba").save();
    	
    	//Test that they've been saved
    	
    	assertNotNull(site1.TF);
    	assertNotNull(site1.sequence);
    	assertNotNull(site1.start);
    	assertNotNull(enhancer1.name);
    	assertNotNull(mel.name);
    	assertNotNull(yak.name);
    	assertNotNull(site1.wscore);
    	
    	
    	//Tag the enhancer with a site
    	
    	site1.tagEnhancer(enhancer1);
    	site1.save();
    	
    	//Test that it worked
    	
    	assertEquals(1, enhancer1.TFsites.size());
    	assertNotNull(site1.enhancer);
    	
    	//Tag the site with a species
    	site1.tagSpecies(mel);
    	site1.tagSpecies(yak);
    	site1.save();
    	
    	//Test that it worked
    	
    	assertEquals(2, site1.species.size());
    	assertEquals(1, mel.TFsites.size());
    	assertEquals(1, yak.TFsites.size());
    	
    }

}
