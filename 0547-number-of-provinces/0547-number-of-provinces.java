class Solution {

    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                // FIX 1: isCoonected -> isConnected
                // FIX 2: dfs -> visited
                dfs(isConnected, visited, i);
            }
        }

        return provinces;
    }

    private void dfs(int[][] graph, boolean[] visited, int city) {

        visited[city] = true;

        // FIX 3: n is not available here, use graph.length
        for (int i = 0; i < graph.length; i++) {

            // FIX 4: !visited=[i] -> !visited[i]
            if (graph[city][i] == 1 && !visited[i]) {

                // FIX 5: graph(dfs,visited,i) -> dfs(graph, visited, i)
                dfs(graph, visited, i);
            }
        }
    }
}