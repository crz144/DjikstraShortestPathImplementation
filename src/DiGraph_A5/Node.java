package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;

public class Node {
	
	String name;
	long id;
	HashMap<String, Long> edgesToIDs;
	HashSet<String> edgesFrom;
	HashSet<String> edgesTo;
	int edgesFromNum;
	int edgesToNum;
	boolean visited;
	int distance;
	
	public Node(long id, String name) {
		this.id = id;
		this.name = name;
		this.edgesTo = new HashSet<String>();
		this.edgesFrom = new HashSet<String>();
		this.edgesToIDs = new HashMap<String, Long>();
		edgesFromNum = edgesFrom.size();
		edgesToNum = edgesTo.size();
		visited = false;
		distance = Integer.MAX_VALUE;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public long getID() {
		return this.id;
	}
	
	public HashSet<Node> getEdgesTo(HashMap<String, Node> nodes) {
		HashSet<Node> edgesToNodes = new HashSet<Node>();
		
		for (String edge : edgesTo) {
			edgesToNodes.add(nodes.get(edge));
		}
		
		return edgesToNodes;
	}
	
}
