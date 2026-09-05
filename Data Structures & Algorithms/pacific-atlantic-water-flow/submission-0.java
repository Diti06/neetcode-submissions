class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        // Seed Pacific border cells (top row + left column)
        for (int c = 0; c < n; c++) {
            pacific[0][c] = true;
            pacQueue.offer(new int[]{0, c});
        }
        for (int r = 1; r < m; r++) {
            pacific[r][0] = true;
            pacQueue.offer(new int[]{r, 0});
        }

        // Seed Atlantic border cells (bottom row + right column)
        for (int c = 0; c < n; c++) {
            atlantic[m - 1][c] = true;
            atlQueue.offer(new int[]{m - 1, c});
        }
        for (int r = 0; r < m - 1; r++) {
            atlantic[r][n - 1] = true;
            atlQueue.offer(new int[]{r, n - 1});
        }

        // BFS for each ocean
        bfs(heights, pacQueue, pacific, directions, m, n);
        bfs(heights, atlQueue, atlantic, directions, m, n);

        // Collect cells reachable from both oceans
        List<List<Integer>> result = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(List.of(r, c));
                }
            }
        }
        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] reachable,
                     int[][] directions, int m, int n) {
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && !reachable[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                    reachable[nr][nc] = true;
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
    }
}