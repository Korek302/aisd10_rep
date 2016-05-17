package aisd10_rep;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Vertex>
{
    public int compare(Vertex x, Vertex y)
    {
        return x.pr - y.pr;
    }
}
