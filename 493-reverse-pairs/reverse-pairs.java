class Solution {
    public int reversePairs(int[] nums) {
        int[] arr = Arrays.copyOf(nums,nums.length);
        int n =nums.length;
        
        if(n<2){
            return 0;
        }

        return mergeSort(arr,0,n-1);
    }

    private int mergeSort(int[] arr,int left,int right){
        if(left>=right){
            return 0;
        }

        int mid = left + (right-left)/2;
        int pairs=0;

        pairs += mergeSort(arr,left,mid);
        pairs += mergeSort(arr,mid+1,right);
        pairs += countCrossPairs(arr,left,mid,right);
        mergedSortedHalves(arr,left,mid,right);

        return pairs;
    }

    private int countCrossPairs(int[] arr,int left,int mid,int right){
        int pairs = 0;
        int rightPointer = mid+1;

        for(int leftPointer = left;leftPointer<=mid;leftPointer++){
            long leftValue= arr[leftPointer];

            while(rightPointer<=right && leftValue > 2L * arr[rightPointer]){
                rightPointer++;
            }

            pairs += rightPointer - (mid+1);
        }
        return pairs;
    }

    private void mergedSortedHalves(int[] arr,int left,int mid,int right){
        int[] merged = new int[right-left+1];
        int first = left;
        int second = mid+1;
        int write = 0;

        while(first<=mid && second<=right){
            if(arr[first] <= arr[second]){
                merged[write]=arr[first];
                first++;
            }else{
                merged[write] = arr[second];
                second++;
            }
            write++;
        }

        while(first<=mid){
            merged[write]=arr[first];
            first++;
            write++;
        }

        while(second<=right){
            merged[write]=arr[second];
            second++;
            write++;
        }
        for(int index=0;index<merged.length;index++){
            arr[left+index]=merged[index];
        }
    }
}