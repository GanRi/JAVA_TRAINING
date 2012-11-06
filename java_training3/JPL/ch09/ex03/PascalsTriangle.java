package ch09.ex03;

public class PascalsTriangle {
	public static void main(String[] args){
		final int LEVLE = 12;
		int[][] pascalsTriangle = new int[LEVLE][];
		
		for(int i = 0; i < LEVLE; i++){
			pascalsTriangle[i] = new int [i+1];
			for(int j = 0; j < pascalsTriangle[i].length; j++){
				
				if(j == 0 || j == pascalsTriangle[i].length - 1){
					pascalsTriangle[i][j] = 1;
				}
				else{
					pascalsTriangle[i][j] = pascalsTriangle[i - 1][j - 1] + pascalsTriangle[i - 1][j];
				}
			}
		}
		
		print(pascalsTriangle);
		
	}
	
	public static void print(int[][] pascalsTriangle){
		for(int i = 0; i < pascalsTriangle.length; i++){
			for(int j = 0; j < pascalsTriangle[i].length; j++){
				System.out.print(pascalsTriangle[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
