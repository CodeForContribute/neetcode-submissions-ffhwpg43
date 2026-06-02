class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>>result = new ArrayList();
        if(n == 0)return result;
        int[]queens = new int[n]; // queens[row] = col
        backtrack(0,n,queens,result);
        return result;
    }

    private void backtrack(int row, int n, int[]queens, List<List<String>>result){
        // if isGoal(currentState)
        if(row == n){
            result.add(buildGrid(queens,n));
            return;
        }
        for(int col = 0; col < n; col++){
            if(!isSafe(row,col,queens))continue;
            queens[row] = col;
            backtrack(row+1,n,queens,result);
            // implicit undo: next iteration overwrites queens[row]
        }
    }

    private boolean isSafe(int row, int col, int[]queens){
        for(int r = 0; r < row; r++){
            int c = queens[r];
            if(c == col || Math.abs(c-col) == row-r){
                return false;
            }
        }
        return true;
    }

    private List<String> buildGrid(int[]queens, int n){
        List<String>queensPosition = new ArrayList();
        for(int r = 0; r < n; r++){
            char[]row = new char[n];
            Arrays.fill(row,'.');
            row[queens[r]] ='Q';
            queensPosition.add(new String(row));
        }
        return queensPosition;
    }
}
