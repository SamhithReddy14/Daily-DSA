class Solution {
    public boolean dfs(int node , int col , int color[] , int graph[][]) {
        int n = graph.length ;
        int m = graph[0].length ;
        color[node] = col ;
        for(int i=0 ; i<graph[node].length ; i++) {
            if(color[graph[node][i]] == -1) {
                if(!dfs(graph[node][i],1-col , color , graph)) return false ;
            }
            else if(color[graph[node][i]] == col) return false ;
        }
        return true ;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;
        int m = graph[0].length ;
        int color[] = new int[n];
        Arrays.fill(color,-1);
        for(int i=0 ; i<n ; i++) {
            if(color[i] == -1) {
                if(!dfs(i,0,color,graph)) return false ;
            }
        }
        return true ;
    }
}