class Solution {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int[] freq = new int[1001];

        for(int num:nums){
            freq[num]++;
        }

        int left =0;
        int right=n;
        int count =0;

        for(int f:freq){
            if(f==0){
                continue;
            }
            right -= f;
            count += left * f * right;
            left += f; 
        }
        return count;
    }
}