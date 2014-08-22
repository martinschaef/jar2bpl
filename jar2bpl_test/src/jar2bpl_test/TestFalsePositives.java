package jar2bpl_test;
/**
 * 
 */


import static org.junit.Assert.fail;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

import org.joogie.Dispatcher;
import org.joogie.Options;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * @author schaef
 *
 */
@RunWith(Parameterized.class)
public class TestFalsePositives  {
	
	@Parameterized.Parameters (name = "{index}: check ({1})")
	public static Collection<Object[]> data() {
		LinkedList<Object[]> filenames = new LinkedList<Object[]>();
		String dirname = System.getProperty("user.dir")+"/regression/false_positives";
		  File dir = new File(dirname);
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {		    	
		    	if (child.isDirectory() && child.getAbsolutePath()!=null) {
		    		int idx = child.getName().lastIndexOf('/');
		    		idx = (idx<0)?0:idx;
		    		String sn = child.getName().substring(idx);
		    		filenames.add(new Object[] {child.getAbsolutePath(), sn });
		    		
		    	} else {
		    		//Ignore
		    	}
		    }
		  } else {			  
		    // Handle the case where dir is not really a directory.
		    // Checking dir.isDirectory() above would not be sufficient
		    // to avoid race conditions with another process that deletes
		    // directories.
			  throw new RuntimeException(dirname + " NOT FOUND!");
		  }				  
	   return filenames;
   }
	
    private String input, shortname;
    
    public TestFalsePositives(String input, String shortname) {
        this.input = input;
        this.shortname = shortname;
    }

	
	@Test
	public void test() {
		String bplFile = "regression/test_output/"+this.shortname.replace('/', '_')+".bpl";
		System.out.println("Test: "+this.input);
		System.out.println("  output: "+bplFile);
		try {			
			String javaFileDir = this.input;
			Options.v().setClasspath(javaFileDir);
			

			Dispatcher.run(javaFileDir,
					bplFile);

			System.err.println("============ PASSED =================");
		} catch (Exception e) {
			fail("Translation Error " + e.toString());
		}
		
		org.junit.Assert.assertTrue(true);
		
	}

}