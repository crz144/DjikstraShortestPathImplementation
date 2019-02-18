package DiGraph_A5;

public class DiGraphPlayground {

  public static void main (String[] args) {
	  
      // edgeTest4();
	  // delEdgeTest1();
	  //numEdgeTest0();
      //System.out.println("Elapsed time: " + (System.currentTimeMillis() - sTime) + " ms");
    }
  
    public static void exTest(){
      DiGraph d = new DiGraph();
      d.addNode(0, "0");
      d.addNode(1, "1");
      d.addEdge(0, "0", "1", 1, null);
      for (Long i = (long) 2 ; i < 2000000; i++) {
    	  d.addNode(i, ""+i);
       	  d.addEdge(i-1, "" + (i-1), "" + i, 1, null);
      }
      System.out.println("numEdges: "+d.numEdges());
      System.out.println("numNodes: "+d.numNodes());
    }
    
    public static void edgeTest4() {
    	DiGraph d = new DiGraph();
    	d.addNode(1,"f");
    	d.addNode(3,"s");
    	d.addNode(7,"t");
    	d.addNode(6,"si");
    	d.addEdge(0,"f","s", 1, null);
    	Boolean b = d.addEdge(1, "f", "si", 1, null);
    	if (b) {
    		System.out.println("Test passed!");
    	} else {
    		System.out.println("Test failed :(");
    	}
    }
    
    public static void delEdgeTest1() {
    	DiGraph d = new DiGraph();
    	d.addNode(1,"f");
    	d.addNode(3,"s");
    	d.addEdge(0,"f","s", 1, null);
    	Boolean a = d.delEdge("f","x");
    	Boolean b = d.delEdge("x","f");
    	if (!a && !b) {
    		System.out.println("Test passed!");
    	} else {
    		System.out.println("Test failed :(");
    	}
    }
    
    public static void numEdgeTest0() {
    	DiGraph d = new DiGraph();
    	d.addNode(0, "a");
    	d.addNode(1, "b");
    	d.addNode(2, "c");
    	d.addNode(3, "d");
    	d.addNode(4, "e");
    	d.addEdge(0, "a", "b", 1, null);
    	d.addEdge(1, "b", "c", 1, null);
    	d.addEdge(2, "a", "c", 3, null);
    	d.addEdge(3, "c", "d", 2, null);
    	d.addEdge(4, "c", "e", 5, null);
    	d.addEdge(5, "b", "d", 2, null);
    	d.addEdge(6, "d", "e", 3, null);
    	d.addEdge(7, "b", "e", 7, null);
    	d.addEdge(8, "a", "e", 9, null);
    	d.addEdge(9, "a", "d", 5, null);
    	
    	System.out.println("On a :");
    	for (ShortestPathInfo a: d.shortestPath("a")) {
			System.out.println(a.getDest() + " -> " + a.getTotalWeight());
    	}
    }
}