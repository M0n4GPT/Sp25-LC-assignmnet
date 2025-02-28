class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] leftpro = new int[len];
        int[] rightpro = new int[len];
        int[] res = new int[len];
        for(int i=0;i<len;i++){
            if (i==0) leftpro[i]=1;
            else{
                leftpro[i]=leftpro[i-1]*nums[i-1];
            }
        }
        for(int i=len-1;i>=0;i--){
            if (i==len-1) rightpro[i]=1;
            else{
                rightpro[i]=rightpro[i+1]*nums[i+1];
            }        
        }
        for(int i=0;i<len;i++){
            res[i]=leftpro[i]*rightpro[i];
        }
        return res;
    }
}
