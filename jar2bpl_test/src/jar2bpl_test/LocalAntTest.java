package jar2bpl_test;

import static org.junit.Assert.fail;

import java.io.File;

import org.joogie.Dispatcher;
import org.junit.Test;

import bixie.Bixie;

public class LocalAntTest extends AbstractTest {
	
	public LocalAntTest() {
		super("ant", "ant");
		// TODO Auto-generated constructor stub
	}


	@Test
	public void testJavaDirectory() {
		//TODO: design one test case for each sort of input to the translation.
//		String bplFile = "regression/test_output/soot.bpl";			
//		String output_file = "regression/test_output/soot.txt";
		try {
			String javaFileDir = System.getProperty("user.dir")+"/local_tests/ant/classes";
			
//			javaFileDir = "/Users/schaef/git/jar2bpl/jar2bpl_test/regression/java_input/class";
			
			String cp = "";
			for (File f : new File(System.getProperty("user.dir")+"/local_tests/ant/lib").listFiles()) {
				if (f.getName().endsWith(".jar")) {
					cp += File.pathSeparatorChar+ f.getAbsolutePath();
				}
			}

//			cp+=File.pathSeparatorChar+"/Users/schaef/Documents/workspace/jar2bpl/heros/guava-14.0.1.jar";

			Dispatcher.setClassPath(javaFileDir+cp );
			
			Dispatcher.run(javaFileDir, bplFile);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail("Translation Error " + e.toString());
		}
		
		Bixie bx = new Bixie();
		bixie.Options.v().stopTime = true;
		bx.run(bplFile, output_file);
		
		org.junit.Assert.assertTrue(compareFiles(output_file, gold_output));
	}
		
	
}


