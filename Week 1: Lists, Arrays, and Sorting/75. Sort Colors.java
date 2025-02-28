class Solution {
    public void sortColors(int[] nums) {
        int len = nums.length;
        int redpoint = 0;
        int temp=0;
        for(int i=0;i<len;i++){
            if (nums[i]==0){
                temp=nums[redpoint];
                nums[redpoint]=nums[i];
                nums[i]=temp;
                redpoint++;
            }
        }
        int whitepoint=redpoint;
        for(int i=redpoint;i<len;i++){
            if (nums[i]==1){
                temp=nums[whitepoint];
                nums[whitepoint]=nums[i];
                nums[i]=temp;
                whitepoint++;
            }
        }
    }
}
