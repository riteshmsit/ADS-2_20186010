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
            // The time complexity is O(1)
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
			String[] str1 = sc.nextLine().split(" ");
			boolean flag1 = false;
			boolean flag2 = false;
			double distance1 = 0.0;
			double distance2 = 0.0;
			DijkstraSP shortest1 = new DijkstraSP(edge, Integer.parseInt(str1[0]));
			// Time Complexity: O(1)
			if (shortest1.hasPathTo(Integer.parseInt(str1[1]))) {
				flag1 = true;
				distance1 = shortest1.distance(Integer.parseInt(str1[1]));
			}
			DijkstraSP shortest2 = new DijkstraSP(edge, Integer.parseInt(str1[1]));
			// Time Complexity: O(1)
			if (shortest2.hasPathTo(Integer.parseInt(str1[2]))) {
				flag2 = true;
				distance2 = shortest2.distance(Integer.parseInt(str1[2]));
			}
			double Distance = distance1 + distance2;
			// Time Complexity: O(1)
			if (flag1 && flag2) {
			// Displays output upto 1 decimal point
			System.out.format("%.1f", Distance);
			} else {
				System.out.println("No Path Found.");
			}
			System.out.println();
            ArrayList<Integer> path = new ArrayList<>();
            for (Edge eachlink : shortest1.pathTo(Integer.parseInt(str1[1]))) {
                int either = eachlink.either();
                int other = eachlink.other(eachlink.either());
                if (!path.contains(other)) {
                    path.add(other);
                }
                if (!path.contains(either)) {
                    path.add(either);
                }
                }
                for (Edge eachlink1 : shortest2.pathTo(Integer.parseInt(str1[2]))) {
                    int either1 = eachlink1.either();
                    int other1 = eachlink1.other(eachlink1.either());
                    if (!path.contains(other1)) {
                        path.add(other1);
                    }
                    if (!path.contains(either1)) {
                        path.add(either1);
                    }
                }
                for (int everyval : path) {
                    System.out.print(everyval + " ");
                }
			break;
		default:
			break;
		}
	}
}
