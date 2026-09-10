class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for(int[] pre : prerequisites){
            graph.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i]== 0){
                q.offer(i);
            }
        }
        int count = 0 ;
        ArrayList<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            result.add(curr);

            for(int neighbour : graph.get(curr)){
                inDegree[neighbour]--;
                if(inDegree[neighbour] == 0){
                    q.offer(neighbour);
                }
            }
        }
        if(count == numCourses){
            int[] arr = new int[result.size()];

            for (int i = 0; i < result.size(); i++) {
                arr[i] = result.get(i);
            }
            return arr;
            
        }
        return new int[]{ };

    }
}
