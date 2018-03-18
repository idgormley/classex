package model;
/**
 * An example implementation of an ICS141 problem
 * 
 * @author rfoy
 *
 */
public class TaxCalculator {
	/**
	 * The Filing Statuses defined in the ICS141 problem (plus one test status)
	 * @author rfoy
	 *
	 */
	public enum FilingStatus {
		/**
		 * a status with simplified brackets for testing purposes
		 */
		TEST(new int [] { 1, 5, 10, 20, 50, 100 }),
		SINGLE(new int [] { 9_075, 36_900, 89_350, 186_350, 405_100, 406_750 }),
		MARRIED_JOINT(new int [] { 18_150, 73_800, 148_850, 226_850, 405_100, 457_600 }),
		HEAD_OF_HOUSEHOLD(new int [] { 12_950, 49_400, 127_550, 206_600, 405_100, 432_200 });
		
		private int [] brackets;
		
		FilingStatus(int [] brackets){
			this.brackets = brackets;
		}
		/**
		 * Returns a copy of the income brackets associated with this FilingStatus
		 * @return copy of the income brackets
		 */
		public int [] getBrackets(){
			return brackets.clone();
		}
	}
	
	private static final double[] TAX_RATES = { 0.10, 0.15, 0.25, 0.28, 0.33, 0.35, 0.396 };

	public static final int TOP_BRACKET_INDEX = 6;

	/**
	 * Returns the calculated tax based on the filing status and taxable income
	 * @param filingStatus the filing status of the individual
	 * @param income the taxable income
	 * @return the calculated tax
	 */
	public static double calculateTax(FilingStatus filingStatus, int income){

		int [] bracket = filingStatus.getBrackets();
		double taxAccumulator = 0.0;
		int bracketTaxAmt = 0;

		for (int i = 0; i < TAX_RATES.length && (i == 0 || income >= bracket[i - 1]); i++) {

				if (i == 0){
				bracketTaxAmt = Math.min(income, bracket[i]);
				} else if (i == TOP_BRACKET_INDEX){
				bracketTaxAmt = income - bracket[i - 1];
				} else {
				bracketTaxAmt = Math.min(income, bracket[i]) - bracket[i - 1];
				}	
			taxAccumulator += TAX_RATES[i] * bracketTaxAmt;
		}
		return taxAccumulator;
	}
}

