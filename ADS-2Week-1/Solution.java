import java.util.*;
class PageRank {
	Digraph dg;
	int outDegree;
	int inDegree;
	HashMap<Integer, ArrayList<Integer>> incomingVertices;
	HashMap<Integer, Double> values;
	PageRank(Digraph G, Integer vertices) {
		this.outDegree = G.outdegree(vertices);
		this.inDegree = G.indegree(vertices);
		this.dg = G;
		incomingVertices = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < G.V(); i++) {
			for (Integer j : G.adj(i)) {
				if (incomingVertices.containsKey(j)) {
					ArrayList<Integer> list = incomingVertices.get(j);
					list.add(j);
					incomingVertices.put(j, list);
				} else {
					ArrayList<Integer> list = new ArrayList<Integer>();
					list.add(i);
					incomingVertices.put(j, list);
				}
			} 
	}
    }
	double getPR(int v) {
		if (dg.outdegree(v) == 0) {
			return 0.0;
		}
		values = new HashMap<Integer, Double>();
		for (int i = 0; i < dg.V(); i++) {
			values.put(i , 1.0 / dg.V());
		}
		double rank = 0.0;
		for (int i = 0; i < v; i++) {
			ArrayList<Integer> vert = incomingVertices.get(v);
			System.out.println("vert" + vert);
			for (int j = 0; j < vert.size(); j++) {
				int key = vert.get(j);
				System.out.println("key : " + key);
				System.out.println("values : " + values.get(key));
				rank = values.get(key) / dg.outdegree(key);
				values.put(key , rank);
			}
		}
		return rank;
	}
	String toString(Digraph G) {
		System.out.println(G.V() + " vertices, " + G.E() + " edges ");
		for (int i = 0; i < G.V(); i++) {
			System.out.print(i + ": ");
			PageRank pr = new PageRank(dg, i);
			pgrank.add(pr);
			System.out.println(pgrank.getPR(i));
			for (Integer i : dg.adj(j)) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
class WebSearch {

}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// read the first line of the input to get the number of vertices
		int vertices = Integer.parseInt(sc.nextLine());
		Digraph dg = new Digraph(vertices);
		// iterate count of vertices times 
		while (vertices < 0) {
			String[] vertice = sc.nextLine().split(" ");
			int v = Integer.parseInt(vertice[0]);
			for (int w = 1; w < vertice.length; w++) {
				dg.addEdge(v, Integer.parseInt(vertice[w]));
			}
			vertices--;
		}
		// to read the adjacency list from std input
		// and build the graph
		ArrayList<PageRank> pgrank = new ArrayList<>();
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		
	}
}
  
