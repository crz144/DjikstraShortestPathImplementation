package DiGraph_A5;


public class Edge {
	
	long id;
	String source;
	String destination;
	long weight;
	String label;
	
	public Edge(long idNum, String source, String destination, long weight, String label) {
		id = idNum;
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.label = label;
	}
	
	public long getID() {
		return this.id;
	}
	
	public String getSource() {
		return this.source;
	}
	
	public String getDestination() {
		return this.destination;
	}
	
	public long getWeight() {
		return this.weight;
	}
	
	public String getLabel() {
		if (this.label == null) {
			return "";
		} else {
			return this.label;
		}
	}
}
