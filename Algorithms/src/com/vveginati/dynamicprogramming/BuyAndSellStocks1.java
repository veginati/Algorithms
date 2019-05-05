package com.vveginati.dynamicprogramming;

public class BuyAndSellStocks1 {

	// Atmost one transaction

	public int maxProfit(final int[] A) {

        int maxProfit = 0;
        
        if(A.length>0){
            
            int minValue = A[0];
            
            for(int i=1;i<A.length;i++){
                
                if(A[i]-minValue > maxProfit){
                    maxProfit = A[i] - minValue;
                }
                
                if(A[i]<minValue){
                    minValue= A[i];
                }
            }
            
        }
        
        return maxProfit;

        
	}
}
