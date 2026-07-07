class Solution {
    public String multiply(String a, String b) {
        if(a.equals("0") || b.equals("0"))return "0";
        if(a.length() < b.length()){
            return multiply(b,a);
        }
        String result = "";
        int zero = 0;
        for(int i = b.length()-1; i >= 0; i--){
            String cur = mul(a,b.charAt(i),zero);
            result = add(result,cur);
            zero++;
        }
        return result;
    }

    private String mul(String s, char d, int zero){
        int i = s.length()-1, carry = 0;
        int digit = d-'0';
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || carry > 0){
            int n = i >= 0 ? s.charAt(i)-'0' : 0;
            int prod = n * digit + carry;
            sb.append(prod % 10);
            carry = prod / 10;
            i--;
        }
        return sb.reverse().toString() + "0".repeat(zero);
    }

    private String add(String a, String b){
        int i = a.length()-1, j = b.length()-1, carry = 0;
        StringBuilder result = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0){
            int m = i >= 0 ? a.charAt(i)-'0': 0;
            int n = j >= 0 ? b.charAt(j)-'0': 0;
            int total = m + n + carry;
            result.append(total % 10);
            carry = total / 10;
            i--;j--;
        }
        return result.reverse().toString();
    }
}
