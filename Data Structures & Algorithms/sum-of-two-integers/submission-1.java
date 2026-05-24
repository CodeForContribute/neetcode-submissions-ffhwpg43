class Solution {
    public int getSum(int a, int b) {
        int carry = 0, result = 0, mask = 0xFFFFFFFF;
        for(int i = 0; i < 32; i++){
            int a_bit = (a >> i) & 1;
            int b_bit = (b >> i) & 1;
            int cur_bit = a_bit  ^ b_bit ^ carry;
            carry = (a_bit + b_bit + carry) >= 2 ? 1 : 0;
            if(cur_bit != 0){
                result |= ( 1 << i);
            }
        }
        if(result > 0x7FFFFFFF){
            result = ~(result ^ mask);
        }
        return result;
    }
}
