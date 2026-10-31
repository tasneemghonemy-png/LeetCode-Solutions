class Solution {
    public int romanToInt(String s) {
        int sum = 0;
                if (s.length() == 1) return getValue(s.charAt(0));

        for (int i = 0; i < s.length() - 1; i++) {
            if (getValue(s.charAt(i)) < getValue(s.charAt(i + 1))) {
                sum += (getValue(s.charAt(i + 1)) - getValue(s.charAt(i)));
                i++;
            }
            else
            sum += getValue(s.charAt(i));
        }
        if (getValue(s.charAt(s.length()-2)) >= getValue(s.charAt(s.length()-1)))
            sum+= getValue(s.charAt(s.length()-1));
            return sum;
    }

   private int getValue(char c) {
        int romanValue = switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            default -> 1000;
        };
        return romanValue;
    }

}