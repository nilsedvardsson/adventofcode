package se.edtek.y2019.d4;

public class Password {

    protected int number;
    protected char[] digits;

    public Password(int number) {
        this.number = number;
        digits = Integer.toString(number).toCharArray();
    }

    public boolean isValid() {
        return digits.length == 6 && digitsNeverDecrease() && hasDoubleDigits();
    }

    private boolean digitsNeverDecrease() {
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] > digits[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDoubleDigits() {
        for (int i = 0; i < digits.length - 1; i++) {
            if (digits[i] == digits[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
