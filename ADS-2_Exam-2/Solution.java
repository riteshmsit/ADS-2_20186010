import java.util.*;
public class Solution {
	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...
		Scanner sc = new Scanner(System.in);
		int cities = sc.nextInt();
		int roadlines = sc.nextInt();
		sc.nextLine(); // for reading string in nextline
		EdgeWeightedGraph edge = new EdgeWeightedGraph(cities);
		// The Time Complexity is O(E)
		// The road lines is the number of edges
		for (int i = 0; i < roadlines; i++) {
			String[] tokens = sc.nextLine().split(" ");
			edge.addEdge(new Edge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]),
				Double.parseDouble(tokens[2])));
		}
		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(edge);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] input = sc.nextLine().split(" ");
			DijkstraSP shortest = new DijkstraSP(
                edge, Integer.parseInt(input[0]));
            double distance = shortest.distTo(Integer.parseInt(input[1]));
            if (!shortest.hasPathTo(Integer.parseInt(input[1]))) {
            	System.out.println("No Path Found.");
            } else {
            	System.out.println(distance);
            }
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			
			break;

		default:
			break;
		}
	}
}
