class Solution {
    public double myPow(double a, int n) {
        return dfs(a,n);
    }
    private double dfs(double a, int n){
        if(n == 0)return 1;
        if(n < 0)return 1/ dfs(a,-n);
        if(n % 2 != 0)return a * dfs(a*a, (n-1)/2);
        return dfs(a*a, n/2);
    }
}
