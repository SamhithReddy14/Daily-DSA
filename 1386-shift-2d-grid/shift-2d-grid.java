class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int total = n * m;
        k %= total;
        List<Integer> flat = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flat.add(grid[i][j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        int start = (total - k) % total;
        for (int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                row.add(flat.get(start));
                start = (start + 1) % total;
            }
            ans.add(row);
        }
        return ans;
    }
}