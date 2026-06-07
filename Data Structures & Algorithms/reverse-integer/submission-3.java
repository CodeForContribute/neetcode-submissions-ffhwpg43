class Solution {
    public int reverse(int a) {
        final int MIN = Integer.MIN_VALUE;
        final int MAX = Integer.MAX_VALUE;

        int result = 0;
        while(a != 0){
            int digit = a % 10;
            a /= 10;
            if(result > MAX / 10 || (result == MAX / 10 && digit > MAX % 10))return 0;
            if(result < MIN / 10 || (result == MIN / 10 && digit < MIN % 10))return 0;
            result = (result * 10) + digit;
        }
        return result;
    }
}
