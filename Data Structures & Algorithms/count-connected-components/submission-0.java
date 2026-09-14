class Solution {
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0;i < n;i++){
            if(!vis[i]){
                count++;
                bfs(i, vis, adj);
            }
        }
        return count;
    }
    private void bfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        vis[i] = true;

        while(!q.isEmpty()){

            int curr = q.poll();
            for (int neigh : adj.get(curr))  {

                if (!vis[neigh]) {
                    vis[neigh] = true;
                    q.add(neigh);
                }
            }
        }
    }
}
