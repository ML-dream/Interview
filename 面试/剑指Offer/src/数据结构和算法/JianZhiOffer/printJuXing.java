/**
 * 
 */
package 数据结构和算法.JianZhiOffer;

import java.util.ArrayList;

/**
 * @author auduser
 *总结：遇到问题，先考虑是个
 *		迭代问题？顺序解决？排序？查找？还是有相应的数据公式技巧？还是链表的指针等等数组的指针？
 */
//注意：双层非常出问题，因双层在迭代的时候，总会碰到一层的时候，想清楚非常麻烦，甚至想不清楚！
//必须根绝据是嵌套、还是单层的时候，进行判断循环！
//使用迭代可以解决必须计算还有几圈的判断 ，反正每次都会执行到单程的时候
public class printJuXing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] [] matrix= {{1,2,3},
						   {1,2,5},
						   {1,5,5},
						   {1,2,3},
						   {3,4,5}};
		ArrayList<Integer> printMatrix = new printJuXing().printMatrix(matrix);
		System.out.println(printMatrix.toString());
	}
	public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>() ;
        if(matrix==null || matrix.length==0) { return result ; }
 
        printMat(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
 
        return result ;
     }
/*
 * 使用迭代最清晰
 * 使用双层循环，自己很难想清楚内部的一层边界问题！所以还是尽量使用迭代吧
 * 之前我使用的是双层循环，发现嵌套的矩阵和单程的是不一样，从而必须要分开；
 * 既然是分开，那就更不能不使用迭代，因为嵌套这种情况肯定会执行到单层的时候，会非常混乱！
 * 使用迭代非常清晰，三种情况，直到执行到后面的单曾、或者没有的层数的时候终止、当是嵌套的时候执行的时候，
 * 然后迭代调用！一层层的循环下去！
 * 
 */
	public void printMat(int [][] matrix,int startRow, int startCol, 
			int endRow, int endCol, ArrayList<Integer> result) {
//		不需要每次新建一个删除外层的矩阵，通过序号进行保证，也就是通过传入的起始值和终点值保证！
		if(startRow<endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
//          注意此处的迭代，循环完一圈每次都进行迭代！
            printMat(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
		}
		/*ArrayList<Integer> list = new ArrayList<Integer>();
		int i = 0,j=0;
		int Y=matrix.length;
		int X=matrix[0].length;
		int length2=0;
		if(X>1&&Y>1) {
			for(;j<X;j++) {
				list.add(matrix[i][j]);
				
			};
			j=j-1;
			i++;
			for(;i<Y;i++) {
				list.add(matrix[i][j]);
				
			};
			i=i-1;
			j--;
			
			for(;j>=length2;j--) {
				list.add(matrix[i][j]);
			}
			j++;
			i--;
			length2++;
			for(;i>=length2;i--) {
				list.add(matrix[i][j]);
			};
			j++;
			
			X--;
			Y--;
			
			
		}else if(X==1 && Y>1) {
			for(int ii =0;ii<Y;ii++) {
				list.add(matrix[ii][0]);
				
			}
		}else if(X>1&&Y==1) {
			for(int ii =0;ii<X;ii++) {
				list.add(matrix[0][ii]);
				
			}
		}else {
			return list;
		}
		
		return list;
	       
	    }*/
}
