class Solution {
    public boolean isValidSudoku(char[][] board) {
        // int[] freq=new int[10];
        // int[] freqC=new int[10];
        // int n=board.length;
        // for(int i=0;i<n;i++){
        //     Arrays.fill(freq,0);
        //     Arrays.fill(freqC,0);
        //     for(int j=0;j<n;j++){
        //         if(board[i][j]!='.'){
        //             freq[board[i][j]-'0']++;

        //             if(freq[board[i][j]-'0']>1){
        //                 return false;
        //             }
        //         }

        //         if(board[j][i]!='.'){
        //             freqC[board[j][i]-'0']++;
        //             if(freqC[board[j][i]-'0']>1){
        //                 return false;
        //             }
        //         }
        //     }
        // }

        // for(int i=0;i<n;i+=3){
        //     for(int j=0;j<n;j+=3){
        //                     Arrays.fill(freq,0);

        //         int row=i;
                
        //         while(row<i+3){
        //             int col=j;
        //             while(col<j+3){
        //                 if(board[row][col]!='.'){
        //                     freq[board[row][col]-'0']++;
        //                     if(freq[board[row][col]-'0']>1){
        //                         return false;
        //                     }
        //                 }
        //                 col++;
        //             }
        //             row++;
        //         }
        //     }
        // }

        // return true;

        Map<Integer, Set<Integer>> rowMap=new HashMap<>();
        Map<Integer, Set<Integer>> colMap=new HashMap<>();
        Map<String, Set<Integer>> squareMap=new HashMap<>();

        for(int r=0;r<9;r++){
            for(int c=0;c<9;c++){
                if(board[r][c]=='.'){
                    continue;
                }
                int tmp=board[r][c];
                if(rowMap.computeIfAbsent(r, k-> new HashSet<>()).contains(tmp)
                || colMap.computeIfAbsent(c, k-> new HashSet<>()).contains(tmp)
                || squareMap.computeIfAbsent((r/3)+"-"+(c/3), q->new HashSet<>()).contains(tmp)){
                    return false;
                }

                rowMap.get(r).add(tmp);
                colMap.get(c).add(tmp);
                squareMap.get((r/3)+"-"+(c/3)).add(tmp);

            }
        }
        return true;
    }
}
