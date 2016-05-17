package aisd10_rep;

import java.util.ArrayList;

public class Vertex
{
	char value;
	Vertex parent;
	
	ArrayList<Vertex> list;
	boolean isVisited;
	
	int pr;
	Vertex prev;
	
	public Vertex(char value)
	{
		this.value = value;
		list = new ArrayList<Vertex>();
		isVisited = false;
	}
	
	public Vertex(char value, ArrayList<Vertex> list)
	{
		this.value = value;
		this.list = list;
		isVisited = false;
	}
	
	public String toStringL()
	{
		String out = value+"\t";
		for(Vertex e : list)
		{
			out += (e.value+" ");
		}
		return out;
	}
	
	public String toString()
	{
		return ""+value+"";
	}
}
