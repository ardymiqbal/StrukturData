package DFS;

class DFS {
    private int numVertices;
    private int[][] adjMatrix;
    private boolean[] visited;

    // Constructor
    public DFS(int vertices) {
        numVertices = vertices;
        adjMatrix = new int[vertices][vertices];
        visited = new boolean[vertices];
    }

    // Add edges
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // If the graph is undirected
    }

    // DFS algorithm
    public void DFS(int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        DFS g = new DFS(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("Depth First Traversal starting from vertex 0:");
        g.DFS(0);
    }
}
