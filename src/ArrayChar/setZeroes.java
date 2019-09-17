package ArrayChar;


//     j   0 1 2 3
//  i   [
//  0     [0,1,2,0],
//  1     [3,4,0,2],
//  2     [1,3,1,5]
//       ]
//  firstColumn T   , firstRow T
// 第一步： 做标记，媒介是 第一行，第一列。
// 第二步： 修改matrix。判断基于 头行，头列的值
// 第三步： 修改第一行，第一列，判断基于 firstColZero & firstRowZero

// time: O(m*n)  space: O(1)
class setZeroes {
    public void setZeroes(int[][] matrix) {
        boolean firstColZero = false;
        boolean firstRowZero = false;

        // 做标记。 traverse matrix, mark X Y轴 是否有 0
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) firstRowZero = true;
                    if(j == 0) firstColZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // 基于第一行的标记，判断以下位置是否为0
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // 基于fr & fc 的标记，判断第一行、列是否为0
        if(firstColZero == true){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        if(firstRowZero == true){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
    }
}
