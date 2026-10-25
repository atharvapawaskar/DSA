class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;

        if((long) m*k>n){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int bloom : bloomDay){
            low = Math.min(low,bloom);
            high = Math.max(high,bloom);
        }

        int ans = -1;

        while(low<=high){
            int mid = low + (int) (((long) high - low)/2);

            if(canBloom(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
        private boolean canBloom(int[] bloomDay,int m ,int k,int day){
            int bouquets =0;
            int consecutive=0;

            for(int bloom : bloomDay){
                if(bloom <= day){
                    consecutive++;

                    if(consecutive == k){
                        bouquets++;
                        consecutive=0;
                    }
                }else{
                    consecutive = 0;
                }
                if(bouquets >= m){
                    return true;
                }
            }
            return false;
        }
    
}