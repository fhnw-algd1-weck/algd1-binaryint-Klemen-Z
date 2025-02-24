package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		if(x > 127 || x < -128){
			throw new IllegalArgumentException("x must be between 127 and -128");
		}
		StringBuilder output = new StringBuilder();
		byte power = 0;
		int counter = 0;

		byte temp = (byte) x;

		if (x < 0){
			temp = (byte) ~temp;
		}

		while (power < temp) {
			power <<= 1;
			power ^= 1;
			counter++;
		}

		for (int i = 0; i < counter; i++) {
			output.append((temp >> i) & 1);
		}

		if (output.length() <= 8){
			output.append("0".repeat(8-output.length()));
		}
		output.reverse();

		if (x < 0){
            return output.toString().replace("0", ".").replace("1", "0").replace(".", "1");
		}
		return output.toString();
	}

	public static int fromString(String text) {
		byte output = 0;
		text = text.replace(" ", "");
		if (text.length() > 8 || text.isEmpty()){
			throw new IllegalArgumentException("text must contain 8 non space characters");
		}
		for (int i = 0; i < text.length(); i++) {
			byte temp = (byte) (text.charAt(i)-48);
			output = (byte) (output << 1);
			if(temp == 1){
				output ^= 1;
			}
		}

		return output;
	}
}