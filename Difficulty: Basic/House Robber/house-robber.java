class Solution {
    public int maximizeMoney(int n, int k) {
        // code here
        return n%2==0?(n/2)*k:(n/2+1)*k;
    }
}