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
    	
    	TFsite site1 = new TFsite("Dichaete", "AACAAG", 302, 456);
    	
    	Enhancer enhancer1 = new Enhancer("Abd-B.35C08");
    	
    	Species mel = new Species("Drosophila melanogaster");
    	
    }

}
