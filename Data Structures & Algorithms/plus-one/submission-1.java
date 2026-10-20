class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (carry != 0) {
                int newVal = digits[i] + carry;
                if (newVal > 9) {
                    digits[i] = 0;
                    carry = 1;
                } else {
                    digits[i] = newVal;
                    carry = 0;
                }
            }
        }

        if (carry == 1) {
            int[] res = new int[digits.length + 1];
            System.arraycopy(digits, 0, res, 1, digits.length);
            res[0] = carry;
            return res;
        }
        return digits;
    }
}
