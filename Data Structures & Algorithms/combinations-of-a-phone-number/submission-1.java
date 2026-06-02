class Solution {
    private static final String[]digitToChar = {
        "","","abc","def","ghi","jkl","mno","qprs", "tuv","wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String>result = new ArrayList();
        if(digits.isEmpty())return result;
        //backtrack(digits, 0, "",result);
        return buildCombOneByOne(digits);
        //return result;
    }
    private List<String> buildCombOneByOne(String digits){
        List<String>result = new ArrayList();
        result.add("");
        for(char digit : digits.toCharArray()){
            List<String>tmp = new ArrayList();
            for(String cur : result){
                for(char c : digitToChar[digit-'0'].toCharArray()){
                    System.out.print(c + ",");
                    tmp.add(cur + c);
                }
            }
            System.out.println(tmp.size());
            result = tmp;
        }
        return result;
    }
    private void backtrack(String digits, int idx, String cur, List<String>result){
        if(cur.length() == digits.length()){
            result.add(cur);
            return;
        }

        String chars = digitToChar[digits.charAt(idx)-'0'];
        for(char ch : chars.toCharArray()){
            backtrack(digits,idx+1,cur + ch, result);
        }
    }
}
