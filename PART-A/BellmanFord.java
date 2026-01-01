import java.util.*;

public class BellmanFord
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int n=sc.nextInt();
        int[][] graph=new int[n][n];
        System.out.println("Enter the weight of the graph(0-index base):");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                graph[i][j]=sc.nextInt();
            }
        }
        int source;
        System.out.println("Enter the source vertex:");
        source=sc.nextInt();
        bellmanFord(n,graph,source-1);
        sc.close();
    }

    public static void bellmanFord(int n,int[][] graph,int source)
    {
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[source]=0;
        for(int i=0;i<n-1;i++)
        {
            for(int u=0;u<n;u++)
            {
                for(int v=0;v<n;v++)
                {
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE&& dist[u]+graph[u][v]<dist[v])
                    {
                        dist[v]=dist[u]+graph[u][v];
                    }
                }
            }
        }


        for(int u=0;u<n;u++)
            {
                for(int v=0;v<n;v++)
                {
                    if(graph[u][v]!=0 && dist[u]!=Integer.MAX_VALUE&& dist[u]+graph[u][v]<dist[v])
                    {
                        System.out.println("Negative cycle detected");
                        return;
                    }
                }
            }

            printSolution(dist);


    }

    public static void printSolution(int[] dist)
    {
        System.out.println("Vertex\t\tDistance from the source\n");
        for(int i=0;i<dist.length;i++)
        {
            System.out.println((i+1)+"\t\t"+(dist[i]==Integer.MAX_VALUE?"Infinity":dist[i]));
        }
    }
}