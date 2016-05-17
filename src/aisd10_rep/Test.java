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
		Vertex f = new Vertex('f');
		Vertex k = new Vertex('g');
		Vertex h = new Vertex('h');
		Vertex l = new Vertex('i');
		Vertex j = new Vertex('j');
		Vertex m = new Vertex('m');
		Vertex n = new Vertex('n');
		Vertex o = new Vertex('o');
		Vertex p = new Vertex('p');
		Vertex r = new Vertex('r');
		
		g.makeSet(a);
		g.makeSet(b);
		g.makeSet(c);
		g.makeSet(d);
		g.makeSet(e);
		g.makeSet(f);
		g.makeSet(k);
		g.makeSet(h);
		g.makeSet(l);
		g.makeSet(j);
		g.makeSet(m);
		g.makeSet(n);
		g.makeSet(o);
		g.makeSet(p);
		g.makeSet(r);
		
		g.union(a, b, 10);
		g.union(a, c, 1);
		g.union(b, e, 2);
		g.union(c, d, 4);
		g.union(c, b, 2);
		g.union(o, b, 9);
		g.union(e, d, 8);
		g.union(a, e, 10);
		g.union(a, f, 1);
		g.union(b, k, 2);
		g.union(b, l, 4);
		g.union(c, h, 2);
		g.union(d, j, 9);
		g.union(f, d, 8);
		g.union(j, r, 2);
		g.union(k, p, 4);
		g.union(c, o, 2);
		g.union(l, m, 9);
		g.union(f, n, 8);
		
		
		int sum = 0;
		int aasd = 0;
		for(int i = 0; i < 9; i++)
		{
			double start = System.nanoTime();
			g.kruskal();
			double end = System.nanoTime();
			aasd = (int) (end - start);
			sum += aasd;
		}
		System.out.println(sum/10);
		
	}
}
