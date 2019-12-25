package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.Challenges;

@RunWith(Suite.class)
@SuiteClasses({ 
	Challenges.class,

})

public class SuiteTest {

}