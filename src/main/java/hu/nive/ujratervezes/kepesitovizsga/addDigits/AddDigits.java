package hu.nive.ujratervezes.kepesitovizsga.addDigits;

public class AddDigits {
    public int addDigits(String input) {
        int result = 0;
        if (input == null || input.isEmpty() || input.isBlank()) {
            return -1;
        }
        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                result = result + Character.getNumericValue(c);
            }
        }
        return result;
    }
}
