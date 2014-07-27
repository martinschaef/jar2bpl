package jar2bpl_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AndroidTest.class,
		JarTranslationTest.class, 
		JavaTranslationTest.class,
		TerpwordTranslationTest.class})
public class AllTests {

}
