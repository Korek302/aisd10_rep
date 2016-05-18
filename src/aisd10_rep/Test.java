package aisd10_rep;

public class Test
{
	public static void main(String[] args)
	{
		Graph g = new Graph();
		Vertex a = new Vertex('a');
		Vertex b = new Vertex('b');
		Vertex c = new Vertex('c');
		Vertex d = new Vertex('d');
		Vertex e = new Vertex('e');
		g.makeSet(a);
		g.makeSet(b);
		g.makeSet(c);
		g.makeSet(d);
		g.makeSet(e);
		g.union(a, b, 10);
		g.union(a, c, 1);
		g.union(b, e, 2);
		g.union(c, d, 4);
		g.union(c, b, 2);
		g.union(d, b, 9);
		g.union(e, d, 8);
		
		System.out.println("vertex list: ");
		System.out.println(g.vertexList);
		System.out.println("edge list: ");
		System.out.println(g.edgeList);
		System.out.println("neighbour list: ");
		System.out.println(g.toStringL());
		System.out.println("BFS: ");
		g.BFS(a);
		System.out.println();
		System.out.println("algorytm Kruskala: \n"+g.kruskal());
		System.out.println("algorytm Dijkstry: ");
		g.dijkstra(a, e);
	}
}
