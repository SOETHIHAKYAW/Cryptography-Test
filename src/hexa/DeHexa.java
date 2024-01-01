package hexa;

/**
 * @author soethihakyaw : 1/1/2024
 */
public class DeHexa {

        public static void main(String[] args) {
            String hexString = "6d69636861656c40626c756573746f6e6532303233";
            String decodedString = hexToString(hexString);

            System.out.println(decodedString);
        }

        public static String hexToString(String hex) {
            StringBuilder output = new StringBuilder();
            for (int i = 0; i < hex.length(); i += 2) {
                String str = hex.substring(i, i + 2);
                output.append((char) Integer.parseInt(str, 16));
            }
            return output.toString();
        }

}
