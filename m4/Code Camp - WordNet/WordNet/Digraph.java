/**graphimplementation.**/
public class DiGraph {
    /**
     * variable.
     */
    private final int vertices;
    /**
     * variable.
     */
    private int edges;
    /**
     * variable.
     */
    private int size;
    /**
     * variable.
     */
    private Bag<Integer>[] adj;
    /**
     * variable.
     */
    private String[] vertex;
    /**
     * @brief [brief description]
     * @details [long description]
     * @param vert value.
     */
     public DiGraph(final int vert) {
        if (vert < 0) {
        throw new IllegalArgumentException(
            "Number of vertices must be nonnegative");
    }
        this.vertices = vert;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vert];
        vertex = new String[vert];
        for (int v = 0; v < vert; v++) {
            adj[v] = new Bag<Integer>();
        }
        size = 0;

    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(1)
     * @return value
     */
     public int vertex() {
        return vertices;
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(1)
     * @return value
     */
     public int edge() {
        return edges;
    }
    /**
     * @param v value
     * @return value
     */
    public Iterable<Integer> adj(final int v) {
        //validateVertex(v);
        return adj[v];
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N ^ 2)
     * @return value
     */
    public DiGraph reverse() {
        DiGraph reverse = new DiGraph(this.vertex());
        for (int v = 0; v < this.vertex(); v++) {
            for (int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(1)
     * @param v value
     * @param w value
     */
    public void addEdge(final int v, final int w) {

        // validateVertex(v);
        // validateVertex(w);
    // if (v == w) {
    //     System.out.println(vertices + " vertices, " + edges + " edges");
    //     System.out.println("No edges");
    //     return;
    // }
        edges++;
        adj[v].add(w);
       //adj[w].add(v);
    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(1)
     * @param s value
     */
    public void addvertices(final String s) {
        vertex[size++] = s;

    }
    /**
     * @brief [brief description]
     * @details [long description]
     * Time complexity is O(N ^ 2)
     * @return value
     */
     public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges" + "\n");
        for (int v = 0; v < vertices; v++) {
            s.append(vertex[v] + ": ");
            for (int w : adj[v]) {
                s.append(vertex[w] + " ");
                //s.substring(0,s.length() - 1);
            }
            s.append("\n");
        }
        return s.toString();
    }

}




