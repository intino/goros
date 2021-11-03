package io.intino.goros.unit.printers;

public class Printer {
	private static final int WordLengthOffset = 10;

	protected int wordLength(String label) {
		if (label == null)
			return 0;

		String[] labelArray = label.split(" ");
		int result = 0;
		for (int i=0; i<labelArray.length; i++) {
			if (labelArray[i].length() > result)
				result = labelArray[i].length();
		}

		return result + WordLengthOffset;
	}

	protected int maxColumnPercentageWith(int countColumns) {
		return 100/countColumns;
	}

}
