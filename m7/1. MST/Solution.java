import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method.
     * Time complexity : O(v).
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfvertices = sc.nextInt();
        int numberOfedges = sc.nextInt();
        sc.nextLine();
        EdgeWeightedGraph ewgraph = new EdgeWeightedGraph(numberOfvertices);
        while (sc.hasNextLine()) {
            String[] tokens = sc.nextLine().split(" ");
            Edge e = new Edge(Integer.parseInt(tokens[0]),
                              Integer.parseInt(tokens[1]),
                               Double.parseDouble(tokens[2]));
            ewgraph.addEdge(e);
        }
        KruskalMST mst = new KruskalMST(ewgraph);
        System.out.format("%.5f", mst.weight());
    }
}
