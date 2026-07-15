class Solution {
    public boolean dfs(int node ,ArrayList<ArrayList<Integer>> list , boolean visited[] , boolean pathvisited[]) {
        visited[node] = true; 
        pathvisited[node] = true ;
        for(int neighbour : list.get(node)) {
            if(!visited[neighbour]) {
                if(dfs(neighbour,list,visited,pathvisited)) return true ;
            }
            else if(pathvisited[neighbour]) return true ;
        }
        pathvisited[node] = false ;
        return false ;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>() ;
        int n = prerequisites.length ;
        for(int i=0 ; i<numCourses ; i++) {
            list.add(new ArrayList<>()) ;
        }
        for(int i=0 ; i<n ; i++) {
            int u = prerequisites[i][0] ;
            int v = prerequisites[i][1];
            list.get(u).add(v);
            //list.get(v).add(u);
        }
        boolean visited[] = new boolean[numCourses];
        boolean pathvisited[] = new boolean[numCourses];
        for(int i=0 ; i<numCourses ; i++ ) {
            if(!visited[i]) {
                if(dfs(i,list,visited,pathvisited)) {
                    return false ;
                }
            }
        }
        return true ;
    }
}