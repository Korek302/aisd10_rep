package aisd10_rep;

import java.util.Comparator;

public class ValueComparator implements Comparator<Edge>
{
    public int compare(Edge x, Edge y)
    {
        return x.value - y.value;
    }
}

