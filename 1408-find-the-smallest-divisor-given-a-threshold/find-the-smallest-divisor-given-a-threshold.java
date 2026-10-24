class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left =1;
        int right =0;

        for(int num : nums){
            right = Math.max(right,num);
        }

        int ans = right;

        while(left<=right){
            int mid = left + (right-left)/2;
            long sum = 0;

            for(int i=0;i<nums.length;i++){
                sum += (nums[i] + mid-1)/mid;
            }

            if(sum<=threshold){
                ans = mid;
                right = mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}