package ch.fhnw.algd1.converters.binary;

public class BinConverter {
	public static String toString(int x) {
		StringBuilder output = new StringBuilder(8);

		for (int i = 0; i < 8; i++) {
			output.append((x >>> i) & 1);
		}
		output.reverse();
		return output.toString();
	}

	public static int fromString(String text) {
		byte output = 0;
		for (int i = 0; i < text.length(); i++) {
			output = (byte) (output << 1);
			output ^= (byte) (text.charAt(i)-'0');
		}

		return output;
	}
}