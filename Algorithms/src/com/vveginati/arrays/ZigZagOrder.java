
    /**
    Question : 1144. Decrease Elements To Make Array Zigzag

    Given an array nums of integers, a move consists of choosing any element and decreasing it by 1.

An array A is a zigzag array if either:

Every even-indexed element is greater than adjacent elements, ie. A[0] > A[1] < A[2] > A[3] < A[4] > ...
OR, every odd-indexed element is greater than adjacent elements, ie. A[0] < A[1] > A[2] < A[3] > A[4] < ...
Return the minimum number of moves to transform the given array nums into a zigzag array.

Submission : Runtime: 0 ms, faster than 100.00% of Java online submissions for Decrease Elements To Make Array Zigzag.
Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Decrease Elements To Make Array Zigzag.

     */
public class ZigZagOrder {

    public int movesToMakeZigzag(int[] nums) {
        int evenElementOrder =0;
        int oddElementOrder =0;
        
        int[] evenNums = nums.clone();
        int[] oddNums = nums.clone();
        
        for(int i=0,j=1;i<nums.length;i=i+2,j=j+2){
            
              if( i-1>=0 && evenNums[i-1] >= evenNums[i]){
                evenElementOrder +=(evenNums[i-1] - evenNums[i]+1);
                evenNums[i-1] -= evenNums[i-1] -evenNums[i] +1;
                } 
                            
                if( i+1<nums.length && evenNums[i+1] >= evenNums[i]){
                evenElementOrder +=(evenNums[i+1] - evenNums[i]+1);
                   evenNums[i+1] -= evenNums[i+1] -evenNums[i] +1;
                }   
        
            
             if(j<nums.length && oddNums[j-1] >= oddNums[j]){
                    oddElementOrder +=(oddNums[j-1] - oddNums[j]+1);
                    oddNums[j-1] -= oddNums[j-1] - oddNums[j] +1;
                } 
                            
                if(j+1<nums.length && oddNums[j+1] >= oddNums[j]){
                   oddElementOrder +=(oddNums[j+1] - oddNums[j]+1);
                   oddNums[j+1] -= oddNums[j+1] - oddNums[j] +1;
                }  
        }
        return Math.min(evenElementOrder, oddElementOrder);
    }
}