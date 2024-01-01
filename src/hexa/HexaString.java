package hexa;

/**
 * @author soethihakyaw : 1/1/2024
 */
public class HexaString {

    public static void main(String[] args) {
        String inputString = "michael@bluestone2023";
        String hexString = stringToHex(inputString);

        System.out.println(hexString);
    }

    public static String stringToHex(String input) {
        StringBuilder hexString = new StringBuilder();
        for (char ch : input.toCharArray()) {
            hexString.append(String.format("%02x", (int) ch));
        }
        return hexString.toString();
    }
}
