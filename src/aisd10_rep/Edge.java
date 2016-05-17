package aisd10_rep;

public class Edge
{
	Vertex start;
	Vertex end;
	int value;
	
	public Edge()
	{
		this.start = new Vertex(' ');
		this.end = new Vertex(' ');
		value = 0;
	}
	
	public Edge(Vertex start, Vertex end)
	{
		this.start = start;
		this.end = end;
		value = 0;
	}
	
	public Edge(Vertex start, Vertex end, int value)
	{
		this.start = start;
		this.end = end;
		this.value = value;
	}
	
	public String toString()
	{
		return ""+start.value+end.value+value+"";
	}
}
