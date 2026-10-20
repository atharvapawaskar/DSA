class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int q = queries.length;

        int[] prefix = new int[n];
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        
        int plates =0;
        int lastCandle=-1;

        for(int i =0;i<n;i++){
            if(s.charAt(i) == '*'){
                plates++;
            }else{
                lastCandle=i;
            }

            prefix[i]=plates;
            leftCandle[i]=lastCandle;
        }

        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='|'){
                lastCandle=i;
            }
            rightCandle[i]=lastCandle;
        }
        int[] answer =  new int[q];

        for(int i=0;i<q;i++){
            int left =queries[i][0];
            int right = queries[i][1];

            int start = rightCandle[left];
            int end = leftCandle[right];

            if(start != -1 && end != -1 && start<end){
                answer[i]= prefix[end] - prefix[start];
            }else{
                answer[i]=0;
            }
        }
        return answer;
    }
}