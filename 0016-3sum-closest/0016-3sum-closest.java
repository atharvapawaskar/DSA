class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        Arrays.sort(nums);

        int closestSum = nums[0]+nums[1]+nums[2];

        for(int fixed = 0;fixed<n-2;fixed++){
            int left= fixed+1;
            int right=n-1;

            while(left<right){
                int sum = nums[fixed]+nums[left]+nums[right];

                if(Math.abs(sum-target)<Math.abs(closestSum-target)){
                    closestSum=sum;
                }
                if(sum==target){
                    return sum;
                }else if(sum<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return closestSum;
    }
}