class Solution {
    public boolean validTree(int n, int[][] edges) {

        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i <n ; i++){
            adj.add(new ArrayList<>());
        }// populated adj list;

        for(int[] pre : edges){
            adj.get(pre[1]).add(pre[0]);
            adj.get(pre[0]).add(pre[1]);// populating adj list 
        }

        Set<Integer> visited = new HashSet<>();
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,-1});
        visited.add(0);
        
        // detect cycle in undirected graph using bfs
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int parent = curr[1];

            for(int j : adj.get(curr[0])){
                
                if(parent == j ){
                    continue;
                }
                    if(visited.contains(j)&& parent != j){
                        return false;
                    }
                    visited.add(j);
                    q.offer(new int[]{j,curr[0]});
            }
        }
        return visited.size()== n;
    }
}
