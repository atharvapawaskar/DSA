class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int revNum = 0;
        int dup = Math.abs(x);
        int temp = dup;
        while(temp !=0 ){
            int ld = temp%10;
            revNum = (revNum*10)+ld;
            temp = temp/10;
        }
        return revNum == dup;
    }
}