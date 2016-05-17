package aisd10_rep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph
{
	ArrayList<Vertex> vertexList;
	ArrayList<Edge> edgeList;
	
	ValueComparator c = new ValueComparator();
	
	public Graph()
	{
		this.vertexList = new ArrayList<Vertex>();
		this.edgeList = new ArrayList<Edge>();
	}
	
	public Graph(ArrayList<Vertex> vertexList, ArrayList<Edge> edgeList)
	{
		this.vertexList = vertexList;
		this.edgeList = edgeList;
		edgeList.sort(c);
	}
	
	void makeSet(Vertex x)
	{
		x.parent = x;
		vertexList.add(x);
	}
	
	void link(Vertex x, Vertex y)
	{
		y.parent = x;
		
	}
	
	Vertex find(Vertex x)
	{
		return x==x.parent ? x : find(x.parent);
	}
	
	void union(Vertex x, Vertex y)
	{
		link(find(x), find(y));
		x.list.add(y);
	}
	
	void union(Vertex x, Vertex y, int value)
	{
		link(find(x), find(y));
		x.list.add(y);
		edgeList.add(new Edge(x, y, value));
		edgeList.sort(c);
	}
	
	
	public void BFS(Vertex s)
	{
		Deque<Vertex> q = new ArrayDeque<Vertex>();
		for(Vertex e : vertexList)
		{
			e.isVisited = false;
		}
		s.isVisited = true;
		q.addLast(s);
		Vertex temp;
		while(!q.isEmpty())
		{
			temp = q.poll();
			
			System.out.print(temp);
			
			for(Vertex v : temp.list)
			{
				if(!v.isVisited)
				{
					v.isVisited = true;
					q.addLast(v);
				}
			}
		}
	}
	
	public ArrayList<Edge> kruskal()
	{
		Graph g = new Graph();
		ArrayList<Edge> mst = new ArrayList<Edge>();
		for(Vertex v : vertexList)
		{
			g.makeSet(v);
		}
		for(Edge e : edgeList)
		{
			if(g.find(e.start) != g.find(e.end))
			{
				mst.add(e);
				g.union(e.start, e.end);
			}
		}
		return mst;
	}
	
	PriorityComparator c2 = new PriorityComparator();
	Queue<Vertex> q = new PriorityQueue<Vertex>(c2);
	public void init(Vertex s)
	{
		
		for(Vertex v : vertexList)
		{
			v.pr = (int) Double.POSITIVE_INFINITY;
			q.add(v);
		}
		s.pr = 0;
		s.prev = null;
		q.add(s);
	}
	
	public Edge getEdge(Vertex u, Vertex v)
	{
		Edge out = new Edge();
		for(Edge e : edgeList)
		{
			if(e.start == u && e.end == v)
			{
				out = e;
			}
		}
		return out;
	}
	
	public void modPriority(Vertex v, int prior)
	{
		q.remove(v);
		v.pr = prior;
		q.add(v);
	}
	
	public void relax(Vertex u, Vertex v)
	{
		if(v.pr > (u.pr + getEdge(u, v).value))
		{
			modPriority(v, u.pr + getEdge(u, v).value);
			v.prev = u;
		}
	}
	
	public void print(Vertex s, Vertex v)
	{
		if(v == null)
		{
			System.out.println("this road does not exist\nintendet destionation: ");
			return;
		}
		if(v == s)
			System.out.println(s);
		else
		{
			print(s, v.prev);
			System.out.println(v);
		}
	}
	
	public void dijkstra(Vertex s, Vertex w)
	{
		init(s);
		Vertex u = new Vertex(' ');
		while(!q.isEmpty())
		{
			u = q.poll();
			for(Vertex v : u.list)
			{
				relax(u, v);
			}
		}
		print(s, w);
	}
	
	public String toStringL()
	{
		String out = "";
		for(Vertex e : vertexList)
		{
			out += (e.toStringL()+"\n");
		}
		return out;
	}
	
	public String toString()
	{
		String out = "";
		for(Vertex e : vertexList)
		{
			out += (e.toString()+"\n");
		}
		return out;
	}
}
