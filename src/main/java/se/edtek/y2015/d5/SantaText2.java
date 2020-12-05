package se.edtek.y2015.d5;

public class SantaText2 implements IsNice {

    private String s;

    public SantaText2(String s) {
        this.s = s;
    }

    public boolean isNice() {

        if (!containsDoublePair()) {
            return false;
        }

        return containsRepeatingLetter();
    }

    private boolean containsDoublePair() {
        for (int i = 0; i < s.length() - 3; i++) {
            String pair = s.substring(i, i + 2);

            if (s.indexOf(pair, i + 2) != -1) {
                return true;
            }
        }
        return false;
    }

    private boolean containsRepeatingLetter() {
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }
}
