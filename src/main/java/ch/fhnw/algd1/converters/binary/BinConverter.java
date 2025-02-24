package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		if(x > 127 || x < -128){
			throw new IllegalArgumentException("x must be between 127 and -128");
		}
		StringBuilder output = new StringBuilder();
		int power = 0;
		int counter = 0;

		int temp = x;

		if (x < 0){
			temp ^= -1;
			temp++;
		}

		while (power < temp) {
			power <<= 1;
			power ^= 1;
			counter++;
		}

		for (int i = 0; i < counter; i++) {
			output.append((temp >> i) & 1);
		}

		if (output.length() <= 8 && x >= 0){
			output.append("0".repeat(8-output.length()));
		} else if (output.length() <= 8){
			output.append("1".repeat(8-output.length()));
		}

		output.reverse();

		return output.toString();
	}

	public static int fromString(String text) {
		int output = 0;
		text = text.replace(" ", "");
		if (text.length() > 8 || text.isEmpty()){
			throw new IllegalArgumentException("text must contain 8 non space characters");
		}
		for (int i = 0; i < text.length(); i++) {
			int temp = text.charAt(i)-48;
			output = output << 1;
			if(temp == 1){
				output ^= 1;
			}
		}

		return output;
	}
}