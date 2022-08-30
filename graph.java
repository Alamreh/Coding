 
import java.util.*;
 

public class graph {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of nodes v:");
       int v=sc.nextInt();
       System.out.println("Enter number of  Edges e:");
       int e=sc.nextInt();
       
       //Adajecency matrix;
      // int [][] adjmat=new int[v+1][v+1];
       
       ArrayList<ArrayList<Integer>> adjlist=new ArrayList<>();
       for(int i=0;i<=v;i++)
    	   adjlist.add(new ArrayList<>());
       
       for(int i=0;i<e;i++)
       {
    	   int source,dest;
    	   source=sc.nextInt();
    	   dest=sc.nextInt();
    	   addEdge(adjlist,source,dest,  false);
    	  
       }
      // printlist(adjlist,v);
      // BFS(v,adjlist);
     //  DFS(v,adjlist);
       System.out.println("Shortest path is "+sortestpath(adjlist,0,6));
       
       
	}
	
	static int sortestpath(ArrayList<ArrayList<Integer>> adjlist,int src,int dest)
	{
		int sortestpath[]=new int[adjlist.size()];
		Arrays.fill(sortestpath, Integer.MAX_VALUE);
		
		Queue<Integer> q=new LinkedList<>();
		q.add(src);
		sortestpath[src]=0;
		while(!q.isEmpty())
		{
			int val=q.poll();
			
			for(int it:adjlist.get(val))
			{
				if(sortestpath[val]+1<sortestpath[it])
				{
					sortestpath[it]=sortestpath[val]+1;
					q.add(it);
				}
			}
			
		}
		for(int i=0;i<adjlist.size();i++)
			System.out.print(sortestpath[i]+" ");
		
		return sortestpath[dest];
	}
	
	static void BFS(int vertex,ArrayList<ArrayList<Integer>> adjlist)
	{
		 boolean [] visited=new boolean[vertex+1];
		List<Integer> ans=new ArrayList<>();
		for(int i=1;i<=vertex;i++)
		{
			 if(!visited[i])
			   bfs(adjlist,visited,ans,i);
		}
		for(int i=0;i<ans.size();i++)
		{
			System.out.println(ans.get(i));
		}


	}
	
	private static void bfs(ArrayList<ArrayList<Integer>> adjlist, boolean [] visited, List<Integer> ans,
			int node) {
	 Queue<Integer> q=new LinkedList<>();
	 q.add(node);
	  visited[node]=false;
	 while(!q.isEmpty())
	 {
		 Integer frontNode=q.poll();
		 
		 ans.add(frontNode);
		 
		 for(Integer it:adjlist.get(node))
		 {
			 if(!visited[it])
			 {
				 visited[it]=true;
			      q.add(it);	 
			 }
		 }
		 
	 }
	 
	 
		
	}
	
	
	//Dfs traversal
	static void DFS(int vertex,ArrayList<ArrayList<Integer>> adjlist)
	{
		 boolean [] visited=new boolean[vertex+1];
		List<Integer> ans=new ArrayList<>();
		for(int i=1;i<=vertex;i++)
		{
			 if(!visited[i])
			   dfs(adjlist,visited,ans,i);
		}
		for(int i=0;i<ans.size();i++)
		{
			System.out.println(ans.get(i));
		}


	}
	
	private static void dfs(ArrayList<ArrayList<Integer>> adjlist, boolean [] visited, List<Integer> ans,
			int node) {
	 ans.add(node);
	 visited[node]=true;
	 for(Integer it:adjlist.get(node)) {
		 if(!visited[it])
			 dfs(adjlist,visited,ans,it);
	 }
	 
		
	}
 
 
	 
	static void addEdge(ArrayList<ArrayList<Integer>> adjlist,int source,int dest
			  ,boolean isDirected)
	{
		adjlist.get(source).add(dest);
		if(isDirected==false)
			adjlist.get(dest).add(source);
		 
	}
	static void printlist(ArrayList<ArrayList<Integer>> arr,int n)
	{
		for(int i=0;i<=n;i++)
		{
			System.out.print(i +" -> ");
			for(int j=0;j<arr.get(i).size();j++)
			{
				System.out.print(arr.get(i).get(j)+" ");
			}
			System.out.println();
		}
		
	}
}
  
 
