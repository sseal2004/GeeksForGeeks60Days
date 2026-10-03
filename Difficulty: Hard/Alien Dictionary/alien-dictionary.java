class Solution {
    public String findOrder(String[] words) {

        int k = 26;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        // Track characters actually present
        boolean[] exists = new boolean[k];

        for(String word : words) {
            for(char ch : word.toCharArray()) {
                exists[ch - 'a'] = true;
            }
        }

        // Compare adjacent words
        for(int i = 0; i < words.length - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            int minlen = Math.min(s1.length(), s2.length());

            for(int j = 0; j < minlen; j++) {

                if(s1.charAt(j) != s2.charAt(j)) {

                    int u = s1.charAt(j) - 'a';
                    int v = s2.charAt(j) - 'a';

                    adj.get(u).add(v);

                    // Only first different character matters
                    break;
                }
            }
        }

        // Calculate indegree
        int[] indegree = new int[k];

        for(int u = 0; u < k; u++) {
            for(int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // Kahn's Algorithm
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < k; i++) {

            if(exists[i] && indegree[i] == 0) {
                q.offer(i);
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!q.isEmpty()) {

            int temp = q.poll();

            ans.append((char)(temp + 'a'));

            for(int e : adj.get(temp)) {

                indegree[e]--;

                if(indegree[e] == 0) {
                    q.offer(e);
                }
            }
        }

        // If not all existing characters were processed,
        // there is a cycle
        int totalCharacters = 0;

        for(boolean x : exists) {
            if(x) {
                totalCharacters++;
            }
        }

        if(ans.length() != totalCharacters) {
            return "";
        }

        return ans.toString();
    }
}