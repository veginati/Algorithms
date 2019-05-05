package com.vveginati.dynamicprogramming;


// Any number of transactions.

public class BuyAndSellStocks2 {
	
	public static void main(String[] args) {
		
		
		System.out.println(new BuyAndSellStocks2().maxProfit(new int[] {12,54,1,2,3,35}));
		
	}
	
	public int maxProfit(final int[] A) {
        int[][] profitArray = new int[A.length+1][A.length+1];
        
        int maxProfit =0;
        
        for(int i=1;i<profitArray.length;i++){
            
            for(int j=i;j<profitArray[i].length;j++){
                
                int temp =  Math.max(profitArray[i][i] + A[j-1]-A[i-1],profitArray[i][j-1]);
                
                profitArray[i][j] = Math.max(temp,profitArray[i-1][j]);
                
                if(profitArray[i][j]>maxProfit){
                    maxProfit = profitArray[i][j];
                }
                
            }
        }
        
        for(int i=0;i<profitArray.length;i++){
            
            for(int j=0;j<profitArray.length;j++){
                
                System.out.print(profitArray[i][j]+" ");
            }
            System.out.println("");
        }
        
        return maxProfit;
    
    }

}
