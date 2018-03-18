package model;

import static org.junit.Assert.*;
import org.junit.Test;

import static model.TaxCalculator.FilingStatus;;

public class TaxCalculatorTest {

	private static final double EPSILON = 0.005;

	@Test
	public void testTestBracket() {
		assertEquals(0.0, TaxCalculator.calculateTax(FilingStatus.TEST, 0), EPSILON);
		assertEquals(0.1, TaxCalculator.calculateTax(FilingStatus.TEST, 1), EPSILON);
		assertEquals(0.70, TaxCalculator.calculateTax(FilingStatus.TEST, 5), EPSILON);
		assertEquals(0.95, TaxCalculator.calculateTax(FilingStatus.TEST, 6), EPSILON);
		assertEquals(1.95, TaxCalculator.calculateTax(FilingStatus.TEST, 10), EPSILON);
		assertEquals(2.23, TaxCalculator.calculateTax(FilingStatus.TEST, 11), EPSILON);
		assertEquals(4.75, TaxCalculator.calculateTax(FilingStatus.TEST, 20), EPSILON);
		assertEquals(5.08, TaxCalculator.calculateTax(FilingStatus.TEST, 21), EPSILON);
		assertEquals(14.65, TaxCalculator.calculateTax(FilingStatus.TEST, 50), EPSILON);
		assertEquals(15.00, TaxCalculator.calculateTax(FilingStatus.TEST, 51), EPSILON);
		assertEquals(32.15, TaxCalculator.calculateTax(FilingStatus.TEST, 100), EPSILON);
		assertEquals(32.55, TaxCalculator.calculateTax(FilingStatus.TEST, 101), EPSILON);
		assertEquals(127.19, TaxCalculator.calculateTax(FilingStatus.TEST, 340), EPSILON); // random value
	}

	@Test
	public void testSingleBracket() {
		assertEquals(0.0, TaxCalculator.calculateTax(FilingStatus.SINGLE, 0), EPSILON);
		assertEquals(907.50, TaxCalculator.calculateTax(FilingStatus.SINGLE, 9_075), EPSILON);
		assertEquals(907.65, TaxCalculator.calculateTax(FilingStatus.SINGLE, 9_076), EPSILON);
		assertEquals(5081.25, TaxCalculator.calculateTax(FilingStatus.SINGLE, 36_900), EPSILON);
		assertEquals(5081.50, TaxCalculator.calculateTax(FilingStatus.SINGLE, 36_901), EPSILON);
		assertEquals(18193.75, TaxCalculator.calculateTax(FilingStatus.SINGLE, 89_350), EPSILON);
		assertEquals(18194.03, TaxCalculator.calculateTax(FilingStatus.SINGLE, 89_351), EPSILON);
		assertEquals(45353.75, TaxCalculator.calculateTax(FilingStatus.SINGLE, 186_350), EPSILON);
		assertEquals(45354.08, TaxCalculator.calculateTax(FilingStatus.SINGLE, 186_351), EPSILON);
		assertEquals(117541.25, TaxCalculator.calculateTax(FilingStatus.SINGLE, 405_100), EPSILON);
		assertEquals(117541.60, TaxCalculator.calculateTax(FilingStatus.SINGLE, 405_101), EPSILON);
		assertEquals(118118.75, TaxCalculator.calculateTax(FilingStatus.SINGLE, 406_750), EPSILON);
		assertEquals(118119.15, TaxCalculator.calculateTax(FilingStatus.SINGLE, 406_751), EPSILON);
		assertEquals(1046.25, TaxCalculator.calculateTax(FilingStatus.SINGLE, 10_000), EPSILON); // example from problem

	}

	@Test
	public void testMarriedBracket() {
		assertEquals(0.0, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 0), EPSILON);
		assertEquals(1815.00, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 18_150), EPSILON);
		assertEquals(1815.15, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 18_151), EPSILON);
		assertEquals(10162.50, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 73_800), EPSILON);
		assertEquals(10162.75, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 73_801), EPSILON);
		assertEquals(28925.00, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 148_850), EPSILON);
		assertEquals(28925.28, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 148_851), EPSILON);
		assertEquals(50765.00, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 226_850), EPSILON);
		assertEquals(50765.33, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 226_851), EPSILON);
		assertEquals(109587.50, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 405_100), EPSILON);
		assertEquals(109587.85, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 405_101), EPSILON);
		assertEquals(127962.50, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 457_600), EPSILON);
		assertEquals(127962.90, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 457_601), EPSILON);
		assertEquals(93925.04, TaxCalculator.calculateTax(FilingStatus.MARRIED_JOINT, 357_638), EPSILON);
	}
	
	@Test
	public void testHeadOfHouseholdBracket() {
		assertEquals(0.0, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 0), EPSILON);
		assertEquals(1295.00, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 12_950), EPSILON);
		assertEquals(1295.15, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 12_951), EPSILON);
		assertEquals(6762.50, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 49_400), EPSILON);
		assertEquals(6762.75, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 49_401), EPSILON);
		assertEquals(26300.00, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 127_550), EPSILON);
		assertEquals(26300.28, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 127_551), EPSILON);
		assertEquals(48434.00, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 206_600), EPSILON);
		assertEquals(48434.33, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 206_601), EPSILON);
		assertEquals(113939.00, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 405_100), EPSILON);
		assertEquals(113939.35, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 405_101), EPSILON);
		assertEquals(123424.00, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 432_200), EPSILON);
		assertEquals(123424.40, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 432_201), EPSILON);
		assertEquals(77528.78, TaxCalculator.calculateTax(FilingStatus.HEAD_OF_HOUSEHOLD, 294_766), EPSILON); //Random Value
	}
}
