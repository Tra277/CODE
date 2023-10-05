    
public class Manager {

    

    //display menu
    public static int menu() {
        System.out.println("1. Convert From Binary.");
        System.out.println("2. Convert From Decimal.");
        System.out.println("3. Convert From Hexa.");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validate.checkInputIntLimit(1, 4);
        return choice;
    }

    //display choose conver
    public static int displayConvert(String from, String toCase1, String toCase2) {
        System.out.println("1. Convert from " + from + " to " + toCase1);
        System.out.println("2. Convert from " + from + " to " + toCase2);
        System.out.print("Enter your choice: ");
        int result = Validate.checkInputIntLimit(1, 2);
        return result;
    }

    //allow user convert from binary
    public static void convertFromBinary(String binary) {
        int choice = displayConvert("binary", "decimal", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Decimal: "
                        + convertBinaryToDecimal(binary)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertBinaryToHexa(binary));
                break;
        }
    }

    //allow user convert from binary
    public static void convertFromDecimal(double decimal) {
        int choice = displayConvert("decimal", "binary", "hexadecimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertDecimalToBinary(decimal)
                );
                break;
            case 2:
                System.out.println("Hexadecimal: "
                        + convertDecimalToHexa(decimal));
                break;
        }
    }

    //allow user convert from binary
    public static void convertFromHexa(String hexa) {
        int choice = displayConvert("hexa", "binary", "decimal");
        switch (choice) {
            case 1:
                System.out.println("Binary: "
                        + convertHexaToBinary(hexa)
                );
                break;
            case 2:
                System.out.println("Decimal: "
                        + convertHexaToDecimal(hexa));
                break;
        }
    }

    //allow user convert from binary to decimal
    public static double convertBinaryToDecimal(String binaryString) {
        if (binaryString.contains(".")) {
            int integerPart = Integer.parseInt(binaryString.substring(0, binaryString.indexOf('.')), 2);
            double fractionalPart = Integer.parseInt(binaryString.substring(binaryString.indexOf('.') + 1), 2) / Math.pow(2, binaryString.length() - binaryString.indexOf('.') - 1);
            return integerPart + fractionalPart;
        } else {
            return Integer.parseInt(binaryString, 2);
        }
    }

    //allow user convert from binary to decimal
    public static String convertBinaryToHexa(String binary) {
        double decimal = convertBinaryToDecimal(binary);
        String hexa = convertDecimalToHexa(decimal);
        return hexa;
    }

    //allow user convert from hexa to decimal
    public static double convertHexaToDecimal(String hexString) {
        if (hexString.contains(".")) {
            int integerPart = Integer.parseInt(hexString.substring(0, hexString.indexOf('.')), 16);
            double fractionalPart = Integer.parseInt(hexString.substring(hexString.indexOf('.') + 1), 16) / Math.pow(16, hexString.length() - hexString.indexOf('.') - 1);
            return integerPart + fractionalPart;
        } else {
            return Integer.parseInt(hexString, 16);
        }
    }

    //allow user convert from hexa to binary
    public static String convertHexaToBinary(String hexadecimal) {
        double decimal = convertHexaToDecimal(hexadecimal);
        String binary = convertDecimalToHexa(decimal);
        return binary;
    }

    //allow user convert from binary to decimal
    public static String convertDecimalToBinary(double decimal) {
        int integerPart = (int) decimal;
        double fractionalPart = decimal - integerPart;

        // Convert the integer part to binary
        String binaryIntegerPart = "";
        while (integerPart > 0) {
            binaryIntegerPart = (integerPart % 2) + binaryIntegerPart;
            integerPart /= 2;
        }

        // Convert the fractional part to binary
        String binaryFractionalPart = "";
        int maxDigits = 10;
        while (fractionalPart > 0 && binaryFractionalPart.length() < maxDigits) {
            fractionalPart *= 2;
            int bit = (int) fractionalPart;
            binaryFractionalPart += bit;
            fractionalPart -= bit;
        }

        // Hide the decimal point if the fractional part is 0
        if (binaryFractionalPart.isEmpty()) {
            return binaryIntegerPart;
        } else {
            return binaryIntegerPart + "." + binaryFractionalPart;
        }

    }

    //allow user convert from decimal to hexa
    public static String convertDecimalToHexa(double decimal) {
        int integerPart = (int) decimal;
        double fractionalPart = decimal - integerPart;

        // Convert the integer part to hexadecimal
        String hexaIntegerPart = "";
        while (integerPart > 0) {
            int remainder = integerPart % 16;
            hexaIntegerPart = (remainder < 10 ? remainder : (char) ('A' + remainder - 10)) + hexaIntegerPart;
            integerPart /= 16;
        }

        // Convert the fractional part to hexadecimal
        String hexaFractionalPart = "";
        int maxDigits = 10;
        while (fractionalPart > 0 && hexaFractionalPart.length() < maxDigits) {
            fractionalPart *= 16;
            int bit = (int) fractionalPart;
            hexaFractionalPart += (bit < 10 ? bit : (char) ('A' + bit - 10));
            fractionalPart -= bit;
        }

        // Hide the decimal point if the fractional part is 0
        if (hexaFractionalPart.isEmpty()) {
            return hexaIntegerPart;
        } else {
            return hexaIntegerPart + "." + hexaFractionalPart;
        }
    }

    

}
