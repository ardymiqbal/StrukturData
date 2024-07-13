package BFS;

class Graph {
    private int numVertices;
    private int[][] adjMatrix;
    private int[] queue;
    private int front;
    private int rear;

    // Constructor
    public Graph(int vertices) {
        numVertices = vertices;
        adjMatrix = new int[vertices][vertices];
        queue = new int[vertices];
        front = -1;
        rear = -1;
    }

    // Add edges
    public void addEdge(int src, int dest) {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1; // If the graph is undirected
    }

    // Enqueue method for the queue
    private void enqueue(int item) {
        if (rear == queue.length - 1) {
            return; // Queue is full
        }
        if (front == -1) {
            front = 0;
        }
        queue[++rear] = item;
    }

    // Dequeue method for the queue
    private int dequeue() {
        if (front == -1 || front > rear) {
            return -1; // Queue is empty
        }
        return queue[front++];
    }

    // BFS algorithm
    public void BFS(int startVertex) {
        boolean[] visited = new boolean[numVertices];

        visited[startVertex] = true;
        enqueue(startVertex);

        while (front != -1 && front <= rear) {
            int vertex = dequeue();
            System.out.print(vertex + " ");

            for (int i = 0; i < numVertices; i++) {
                if (adjMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    enqueue(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        System.out.println("Breadth First Traversal starting from vertex 0:");
        g.BFS(0);
    }
}
