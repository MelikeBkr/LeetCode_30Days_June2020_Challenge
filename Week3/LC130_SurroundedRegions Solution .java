class Solution {
    public void solve(char[][] board) 
    {
        
        if (board == null || board.length == 0 || board[0].length == 0)
        {
             return;
        }

        int numOfRows = board.length;
        int numOfColumns = board[0].length;
        
        for (int i = 0; i < numOfRows; i++) 
        {
            DFS(board, i, 0);
            DFS(board, i, numOfColumns - 1);
        }
        
        for (int i = 0; i < numOfColumns; i++) 
        {
            DFS(board, 0, i);
            DFS(board, numOfRows - 1, i);
        }
        
        for (int i = 0; i < numOfRows; i++) 
        {
            for (int j = 0; j < numOfColumns; j++) 
            {
                if (board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }

                else if (board[i][j] == '*')
                {
                    board[i][j] = 'O';
                }
            }
        }                     
    }
    
    public void DFS (char[][] board, int rIndex, int cIndex)
    {
        if (! ((rIndex >= 0) && (rIndex < board.length) 
               && (cIndex >= 0) && (cIndex < board[0].length)
               && (board[rIndex][cIndex] == 'O')))
            return;
        
        board[rIndex][cIndex] = '*';
        
        DFS(board, rIndex , cIndex + 1);
        DFS(board, rIndex, cIndex - 1);
        DFS(board, rIndex + 1, cIndex);
        DFS(board, rIndex - 1, cIndex);
        
    }
}