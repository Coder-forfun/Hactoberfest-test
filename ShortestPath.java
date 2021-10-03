//srishti1302
import java.util.*;
class ShortestPath
{
  int V;

  int minDistance(int dist[], Boolean sptSet[])
  {
    int v=0;
    int min = Integer.MAX_VALUE, min_index = -1;
    for(v=0;v<V;v++)
    {
      if(sptSet[v]==false && dist[v]<=min)
      {
        min = dist[v];
        min_index = v;
      }
    }
    return min_index;
  }
  void printSolution(int dist[])
  {
    System.out.println("Distance from source");
    int i=0;
    for(i=0;i<dist.length;i++)
      System.out.println(i + " tt " + dist[i]);
  }

  void dijkstra(int graph[][], int src)
  {
    int dist[] = new int[V];
    Boolean sptSet[] = new Boolean[V];
    int i=0,v=0;
    for(i=0;i<V;i++)
    {
      dist[i] = Integer.MAX_VALUE;
      sptSet[i] = false;
    }
    dist[src] = 0;
    for(i=0;i<V-1;i++)
    {
      int u = minDistance(dist,sptSet);
      sptSet[u] = true;
      for(v=0;v<V;v++)
      {
        if(!sptSet[v] && dist[u]!=Integer.MAX_VALUE && graph[u][v]!=0 && dist[u]+graph[u][v]<dist[v])
          dist[v] = dist[u] + graph[u][v];
      }
    }
    printSolution(dist);
  }

  public static void main(String[] args)
  {
    System.out.println("Enter number of vertices");
    Scanner s = new Scanner(System.in);
    int v = s.nextInt();
    System.out.println("Enter weights in adjacency matrix");
    int graph[][] = new int[10][10];
    int i=0,j=0;
    for(i=0;i<v;i++)
    {
      for(j=0;j<v;j++)
        graph[i][j] = s.nextInt();
    }
    ShortestPath t = new ShortestPath();
    t.V=v;
    t.dijkstra(graph,0);
  }
}