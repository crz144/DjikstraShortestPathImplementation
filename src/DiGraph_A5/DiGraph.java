package DiGraph_A5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import MinBinHeap_A3.*;

public class DiGraph implements DiGraph_Interface {

	private int size;
	private int numEdges;
	HashMap<String, Node> nodes;
	private HashMap<Long, Edge> edges;
	private HashSet<Long> nodeIDs;
	private HashSet<Long> edgeIDs;

  public DiGraph() {
	  size = 0;
	  numEdges = 0;
	  edges = new HashMap<Long, Edge>();
	  nodes = new HashMap<String, Node>();
	  nodeIDs = new HashSet<Long>();
	  edgeIDs = new HashSet<Long>();
  }

  @Override
  public boolean addNode(long idNum, String label) {
	  if (idNum < 0 || nodeIDs.contains(idNum)
			  || nodes.containsKey(label)
			  || label == null) {
		  return false;
	  }
	  
	  nodeIDs.add(idNum);
	  nodes.put(label, new Node(idNum, label));
	  size++;
	  return true;
  }

  public boolean addEdge(long idNum, String sLabel, String dLabel, long weight, String eLabel) {
	  if (idNum < 0 || edgeIDs.contains(idNum) || !nodes.containsKey(sLabel)
			  || !nodes.containsKey(dLabel) || nodes.get(sLabel).edgesTo.contains(dLabel)) {
		  return false;
	  }
	  
	  nodes.get(sLabel).edgesToIDs.put(dLabel, idNum);
	  nodes.get(sLabel).edgesTo.add(dLabel);
	  nodes.get(sLabel).edgesToNum++;
	  nodes.get(dLabel).edgesFrom.add(sLabel);
	  nodes.get(dLabel).edgesFromNum++;
	  edgeIDs.add(idNum);
	  edges.put(idNum, new Edge(idNum, sLabel, dLabel, weight, eLabel));
	  numEdges++;
	  return true;
  }

  @Override
  public boolean delNode(String label) {
	  if (!nodes.containsKey(label)) { // Return false if the node 
		  return false;				   // isn't in the graph.
	  }
	  
	  for (String edgeTo : nodes.get(label).edgesTo) {
		  delEdge(label, edgeTo);
	  }
	  
	  for (String edgeFrom : nodes.get(label).edgesFrom) {
		  delEdge(edgeFrom, label);
	  }
	  nodeIDs.remove(nodes.get(label).id);
	  nodes.remove(label);
	  size--;
	  return true;
  }

  @Override
  public boolean delEdge(String sLabel, String dLabel) {
	  if (nodes.get(sLabel) != null && nodes.get(dLabel) != null &&
			  nodes.containsKey(dLabel) && 
			  nodes.get(sLabel).edgesTo.contains(dLabel) && 
			  nodes.containsKey(sLabel)) { 
			
			edgeIDs.remove(nodes.get(sLabel).edgesToIDs.get(dLabel));
			nodes.get(sLabel).edgesTo.remove(dLabel);
			nodes.get(sLabel).edgesToNum--;
			nodes.get(dLabel).edgesFrom.remove(sLabel);
			nodes.get(dLabel).edgesFromNum--;
			numEdges--;
			return true;
		}
		return false;
  }

  @Override
  public long numNodes() {
	  return size;
  }

  @Override
  public long numEdges() {
	  return numEdges;
  }
  
  public ShortestPathInfo[] shortestPath(String label) {
	  	MinBinHeap prQueue = new MinBinHeap();
		ShortestPathInfo[] shortestPaths = new ShortestPathInfo[size];
		Set<String> k = nodes.keySet();
		int i = 0;
		if (nodes.containsKey(label)) {
			nodes.get(label).distance = 0;			
			prQueue.insert(new EntryPair(label, 0));
			boolean firstNode = true;
			while (prQueue.size() != 0) {
				if (!firstNode) {
					prQueue.delMin(); 
				}
				if (prQueue.getMin() != null) {
					Node currentNode = nodes.get(prQueue.getMin().value);
					if (currentNode != null) {
						if(!currentNode.visited) {
							for(Node n : currentNode.getEdgesTo(nodes)) {
								if (n != null) {
									if (!n.visited) {
										int distance = currentNode.distance + 
												(int) edges.get(currentNode.edgesToIDs.get(n.name)).weight;
										if (n.distance > distance) {
											n.distance = distance;
										}
										prQueue.insert(new EntryPair(n.name, n.distance));
									}
								}
							}
							currentNode.visited = true;
							shortestPaths[i] = new ShortestPathInfo(prQueue.getMin().value, 
																	prQueue.getMin().priority);
							k.remove(currentNode.name);
							firstNode = false;
						}
					}
					if (i < size && currentNode != null) {
						i++;	
					}
				}
			}
		}
		
		
		if (i != size - 1) {
			for (String key : k) {
				shortestPaths[i] = new ShortestPathInfo(key, -1);
				i++;
			}
		}
		return shortestPaths;
	}
  }