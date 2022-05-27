package calculator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import calculator.tests.CalculatorTest;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CalculatorTest.class })
public class CalculatorTestSuite {

}
