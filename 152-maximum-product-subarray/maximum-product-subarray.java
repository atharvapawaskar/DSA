class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;

        if(n==0){
            return 0;
        }

        int currentMax=nums[0];
        int currentMin=nums[0];
        int maxProduct=nums[0];

        for(int index=1;index<n;index++){
            int currentValue=nums[index];

            int previousMax=currentMax;
            int previousMin = currentMin;

            currentMax = Math.max(currentValue,
            Math.max(previousMax*currentValue,previousMin*currentValue));

            currentMin = Math.min(currentValue,
            Math.min(previousMax*currentValue,previousMin*currentValue));

            if(currentMax>maxProduct){
                maxProduct = currentMax;
            }
        }
        return maxProduct;
    }
}