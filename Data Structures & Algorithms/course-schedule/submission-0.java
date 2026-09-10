class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        // adj list 
        for (int i = 0; i < numCourses; i++) {
             graph.add(new ArrayList<>());
        }  

        int[] inDegree = new int[numCourses];
        // array to mainatain the indegree

        //populating the indegree and adj list
        for(int[] pre : prerequisites){ // [1,4]
            graph.get(pre[1]).add(pre[0]); //  4 ->{1}
            inDegree[pre[0]]++;

        } 

        Queue<Integer> q = new LinkedList<>();
        // populating the initial q

        for(int i = 0 ; i < numCourses ; i++){
            if(inDegree[i]== 0){
                q.offer(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            count++;
            for(int i : graph.get(curr)){
                inDegree[i]--;
                if(inDegree[i]== 0){
                    q.offer(i);
                }

            }
        }

        return count == numCourses ;
    }
}
