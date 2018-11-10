/**
 *class for edge.
 */
class Edge {
    /**
     *the variable to store.
     *vetexOne
     */
    private int v;
    /**
     *the variable to store.
     *other vertex.
     */
    private int w;
    /**
     *the variable to store the weight of.
     *each edge.
     */
    private double weight;
    /**
     *the constructor to initialize the.
     *vertices and their edge weight
     * @param      v  vertexOne
     * @param      w  vertexTwo
     * @param      cost  weight of edge
     */
    Edge(final int v, final int w,
         final double cost) {
        this.v = v;
        this.w = w;
        this.weight = cost;
    }
    /**
     *this method returns the weight of edge.
     *
     * @return  weight of edge
     * Time complexity is O(1).
     */
    public double weight() {
        return this.weight;
    }
    /**
     *this method returns one vertex.
     *
     * @return  one end of edge.
     * Time complexity is O(1).
     */
    public int either() {
        return v;
    }
    /**
     *returns the other end of vertex.
     *
     * @param      v already connected vertex
     *
     * @return another vertex
     * Time complexity is O(1).
     */
    public int other(final int vertex) {
        if (vertex == v) {
            return w;
        } else {
            return v;
        }
    }
    public int compareTo(final Edge that) {
        return Double.compare(this.weight, that.weight);
    }

    /**
     * Returns a string representation of this edge.
     *
     * @return a string representation of this edge
     */
    public String toString() {
        return String.format("%d-%d %.5f", v, w, weight);
    }
}

