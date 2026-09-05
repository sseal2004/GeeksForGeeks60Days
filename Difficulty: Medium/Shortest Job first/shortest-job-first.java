class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int time =0;int waitingTime =0;int n = bt.length;
        for(int i=0;i<n;i++){
            waitingTime += time;
            time += bt[i];
        }
        return waitingTime/n;
    }
}
