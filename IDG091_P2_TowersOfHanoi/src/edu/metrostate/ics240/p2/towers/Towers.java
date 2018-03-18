package edu.metrostate.ics240.p2.towers;

/**
 * 
 * @author Ian Gormley
 *
 */
public class Towers {
	protected int[][] towers;
	private int ringCount1 = 0;
	private int ringCount2 = 0;
	private int ringCount3 = 0;
	private static final int DEFAULT_TOWER_SIZE = 5;

	/**
	 * Initializes Towers with between 1 and 64 rings on the first peg and no
	 * rings on the other two pegs. The diameters of the first peg's rings are
	 * from one inch (on the top) to n inches (on the bottom).
	 * 
	 * @param n
	 *            Number of rings on peg 1
	 */
	public Towers(int n) {
		if (n >= 1 && n <= 64) {
			ringCount1 = n;
			int i;
			towers = new int[3][n];
			for (i = 0; i < ringCount1 - 1; i++) {
				towers[1][i] = n;
				n--;
			}
		}
	}

	/**
	 * Initializes Towers with DEFAULT_TOWER_SIZE (five) rings on the first peg
	 * and zero on the other two.
	 * 
	 */
	public Towers() {
		this(DEFAULT_TOWER_SIZE);
	}

	/**
	 * Enter peg number get number of rings pegNumber is 1, 2, or 3.
	 * 
	 * @param pegNumber
	 *            Number of the peg
	 * @return Number of rings on the specified peg
	 * @throws IllegalArgumentException
	 *             pegNumber must be 1, 2, or 3
	 */

	public int getRingCount(int pegNumber) {
		switch (pegNumber) {

		case 1:
			return ringCount1;
		case 2:
			return ringCount2;
		case 3:
			return ringCount3;
		default:
			throw new IllegalArgumentException("pegNumber must be 1, 2, or 3");
		}
	}

	/**
	 * Gives the diameter of the ring on the top of the specified peg (1, 2, or
	 * 3).
	 * 
	 * @param pegNumber
	 *            Number of the peg
	 * @return if getRingCount(pegNumber) is more than 0, returns the diameter
	 *         of the top ring otherwise is zero.
	 * @throws IllegalArgumentException
	 *             pegNumber must be 1, 2, or 3
	 */
	public int getTopDiameter(int pegNumber) {
		int top;
		switch (pegNumber) {
		case 1:
			if (ringCount1 > 0)
				top = towers[0][ringCount1 - 1];
			else
				top = 0;
			return top;

		case 2:
			if (ringCount2 > 0)
				top = towers[1][ringCount2 - 1];
			else
				top = 0;
			return top;
		case 3:
			if (ringCount3 > 0)
				top = towers[2][ringCount3 - 1];
			else
				top = 0;
			return top;
		default:
			throw new IllegalArgumentException("pegNumber must be 1, 2, or 3");
		}
	}

	/**
	 * Moves the top ring of one peg to one of the other two pegs. The starting
	 * peg must have a ring that is smaller than the top peg of the target peg
	 * to move.
	 * 
	 * @param startPeg
	 *            is a peg number (1, 2, or 3)
	 * @param endPeg
	 *            is a peg number (1, 2, or 3) not equal to startPeg
	 * @return If precondition is not true, return value is false and pegs are
	 *         unchanged, otherwise the top ring has been moved from startPeg to
	 *         endPeg and return value is true.
	 * @throws IllegalArgumentException
	 *             startPeg must be 1, 2, or 3
	 * @throws IllegalArgumentException
	 *             endPeg must be 1, 2, or 3
	 * @throws IllegalArgumentException
	 *             endPeg must not equal startPeg
	 */
	public boolean move(int startPeg, int endPeg) {
		boolean moved = false;
		if (getRingCount(startPeg) > 0) {
			if (getRingCount(endPeg) >= 1) {
				if (getTopDiameter(startPeg) < getTopDiameter(endPeg)) {
					switch (startPeg) {
					case 1:
						switch (endPeg) {
						case 1:
							throw new IllegalArgumentException("endPeg must not equal startPeg");
						case 2:
							System.arraycopy(towers[0], (ringCount1 - 1), towers[1], (ringCount2), 1);
							ringCount1--;
							ringCount2++;
							moved = true;
							break;
						case 3:
							System.arraycopy(towers[0], (ringCount1 - 1), towers[2], (ringCount3), 1);
							ringCount1--;
							ringCount3++;
							moved = true;
							break;
						default:
							throw new IllegalArgumentException("endPeg must be 1, 2, or 3");
						}
						break;

					case 2:
						switch (endPeg) {
						case 1:
							System.arraycopy(towers[1], (ringCount2 - 1), towers[0], (ringCount1), 1);
							ringCount2--;
							ringCount1++;
							moved = true;
							break;
						case 2:
							throw new IllegalArgumentException("endPeg must not equal startPeg");
						case 3:
							System.arraycopy(towers[1], (ringCount2 - 1), towers[2], (ringCount3), 1);
							ringCount2--;
							ringCount3++;
							moved = true;
							break;
						default:
							throw new IllegalArgumentException("endPeg must be 1, 2, or 3");
						}
						break;

					case 3:
						switch (endPeg) {
						case 1:
							System.arraycopy(towers[2], (ringCount3 - 1), towers[0], (ringCount1), 1);
							ringCount3--;
							ringCount1++;
							moved = true;
							break;
						case 2:
							System.arraycopy(towers[2], (ringCount3 - 1), towers[1], (ringCount2), 1);
							ringCount3--;
							ringCount2++;
							moved = true;
							break;
						case 3:
							throw new IllegalArgumentException("endPeg must not equal startPeg");
						default:
							throw new IllegalArgumentException("endPeg must be 1, 2, or 3");
						}
						break;

					default:
						throw new IllegalArgumentException("startPeg must be 1, 2, or 3");
					}
				}
			}
			//
			else if (getRingCount(endPeg) == 0) {
				switch (startPeg) {
				case 1:
					switch (endPeg) {
					case 1:
						throw new IllegalArgumentException("endPeg must not equal startPeg");
					case 2:
						System.arraycopy(towers[0], (ringCount1 - 1), towers[1], (0), 1);
						ringCount1--;
						ringCount2++;
						moved = true;
						break;
					case 3:
						System.arraycopy(towers[0], (ringCount1 - 1), towers[2], (0), 1);
						ringCount1--;
						ringCount3++;
						moved = true;
						break;
					default:
						throw new IllegalArgumentException("endPeg must be 1, 2, or 3");
					}
					break;

				case 2:
					switch (endPeg) {
					case 1:
						System.arraycopy(towers[1], (ringCount2 - 1), towers[0], (0), 1);
						ringCount2--;
						ringCount1++;
						moved = true;
						break;
					case 2:
						throw new IllegalArgumentException("endPeg must not equal startPeg");
					case 3:
						System.arraycopy(towers[1], (ringCount2 - 1), towers[2], (0), 1);
						ringCount2--;
						ringCount3++;
						moved = true;
						break;
					default:
						throw new IllegalArgumentException("endPeg must be 1, 2, or 3");
					}
					break;

				case 3:
					switch (endPeg) {
					case 1:
						System.arraycopy(towers[2], (ringCount3 - 1), towers[0], (0), 1);
						ringCount3--;
						ringCount1++;
						moved = true;
						break;
					case 2:
						System.arraycopy(towers[2], (ringCount3 - 1), towers[1], (0), 1);
						ringCount3--;
						ringCount2++;
						moved = true;
						break;
					case 3:
						throw new IllegalArgumentException("endPeg must not equal startPeg");
					default:
						throw new IllegalArgumentException("endPeg must be 1, 2, or 3");
					}
					break;

				default:
					throw new IllegalArgumentException("startPeg must be 1, 2, or 3");
				}
			}
		}
		return moved;
	}
}