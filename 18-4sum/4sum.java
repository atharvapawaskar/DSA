class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();

        if(n<4){
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        for(int first = 0; first <n-3;first++){
            if(first>0 && nums[first] == nums[first-1]){
                continue;
            }
            for(int second = first+1;second<n-2;second++){
                if(second>first+1 && nums[second] == nums[second-1]){
                    continue;
                }

                int left = second+1;
                int right = n-1;

                while(left<right){
                    long sum = 
                    (long) nums[first] + 
                    nums[second] + 
                    nums[left] + 
                    nums[right];

                    if(sum<target){
                    left++;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    answer.add(Arrays.asList(
                        nums[first],
                        nums[second],
                        nums[left],
                        nums[right]
                        ));

                        left++;
                        right--;

                while(left<right && nums[left] == nums[left-1]){
                    left++;
                }
                while(left<right && nums[right] == nums[right+1]){
                    right--;
                }
                }
                } 
            }
        }
        return answer;
    }
}