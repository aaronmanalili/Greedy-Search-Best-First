package greedysearch;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GreedySearch {

	//Given a list of cities and the distances between each pair of cities, 
	// And find the the best shortest path to visit each city once and return to the starting city
	// The example for Greedy BFS is the Traveling Salesman Problem
	
	static ArrayList<ArrayList<edge> > adj = new ArrayList<>();
	
	//Function to add add edges to a graph
	static class edge implements Comparable<edge>{
		int vertice, cost;
		edge(int vertice, int cost){
			this.vertice = vertice;
			this.cost = cost;
		}
		@Override public int compareTo(edge o) {
			if(o.cost < cost) {
				return 1;
			}
			else {
				return -1;
			}
		}
	}
	
	public GreedySearch(int vertice) {
		for(int i = 0; i < vertice; i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	//Function to implelemt Best First Search
	//Gives an output path to get the lowest cost
	
	static void GreedyBestFirstSearch(int Start, int Target, int vertice) 
	{
		
		//MIN HEAP priority queue
		PriorityQueue<edge> pq = new PriorityQueue<>();
		boolean alreadyVisited[] = new boolean[vertice];
		
		//Sorting in PriorityQueue gets completed by the virst value of pair
		pq.add(new edge(Start, -1));
		while(!pq.isEmpty()) 
		{
			int a = pq.poll().vertice;
			System.out.println(a  +  " ");
			
			if(Target == a) {
				break;
			}
			for(edge adjacentNodeEdge : adj.get(a)) {
				if(!alreadyVisited[adjacentNodeEdge.vertice]) 
				{
					alreadyVisited[adjacentNodeEdge.vertice] = true;
					pq.add(adjacentNodeEdge);
				}
			}
		}
		
	}
	
	void addEdges(int x, int y, int cost) 
	{
		adj.get(x).add(new edge(y, cost));
		adj.get(y).add(new edge(x, cost));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int vertice = 8;
		
		GreedySearch graph = new GreedySearch(vertice);
		
		graph.addEdges(0, 1, 145);
		graph.addEdges(1, 2, 20);
		graph.addEdges(2, 3, 9);
		graph.addEdges(3, 4, 14);
		graph.addEdges(4, 5, 50);
		graph.addEdges(5, 6, 70);
	    graph.addEdges(6, 7, 80);
	
		
		int Start = 0;
		int Target = 6;
		
		GreedyBestFirstSearch(Start, Target, vertice);
		
	}

}
