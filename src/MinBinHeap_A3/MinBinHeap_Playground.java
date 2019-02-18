package MinBinHeap_A3;
public class MinBinHeap_Playground {
  public static void main(String[] args){   
	long sTime = System.currentTimeMillis();
    //TestBuild();
	//TestInsert();
	TestLargeBuild();
    System.out.println("Test completed in " + (System.currentTimeMillis() - sTime + " milliseconds"));
  }
  
  public static void TestBuild(){ 
    MinBinHeap mbh= new MinBinHeap();
    EntryPair[] collection= new EntryPair[8];
    collection[0]=new EntryPair("i",3);
    collection[1]=new EntryPair("b",5);
    collection[2]=new EntryPair("c",1);
    collection[3]=new EntryPair("d",0);
    collection[4]=new EntryPair("e",46);
    collection[5]=new EntryPair("f",5);
    collection[6]=new EntryPair("g",6);
    collection[7]=new EntryPair("h",17);
    System.out.println("Beginning");
    mbh.build(collection);
    printHeapCollection(collection);
    printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void TestInsert() {
	  MinBinHeap mbh= new MinBinHeap();
	  EntryPair[] collection= new EntryPair[8];
	  collection[0]=new EntryPair("i",3);
	  collection[1]=new EntryPair("b",5);
	  collection[2]=new EntryPair("c",1);
	  collection[3]=new EntryPair("d",0);
	  collection[4]=new EntryPair("e",46);
	  collection[5]=new EntryPair("f",5);
	  collection[6]=new EntryPair("g",6);
	  collection[7]=new EntryPair("h",17); 
	  
	  for (int i = 0 ; i < collection.length; i++) {
		  mbh.insert(collection[i]);
	  }
	  printHeap(mbh.getHeap(), mbh.size());
	  System.out.println(mbh.size());
  }
  
  public static void TestLotsOfInserts() {
	  MinBinHeap mbh = new MinBinHeap();
	  for (int i = 1 ; i < 201 ; i++) {
		  mbh.insert(new EntryPair("", (int)Math.floor(Math.random()* 200)));
	  }
	  printHeap(mbh.getHeap(), mbh.size());
	  System.out.println(mbh.size());
  }
  
  public static void TestLargeBuild() {
	  MinBinHeap mbh = new MinBinHeap();
	  EntryPair[] collection = new EntryPair[10000];
	  int j = 9999;
	  collection[0] = new EntryPair("a", 70);
	  for (int i = 1 ; i < collection.length; i++) {
		  collection[i] = new EntryPair("",j);
		  j--;
	  }
	  System.out.println("Beginning build");
	  mbh.build(collection);
	  printHeapCollection(collection);
	  printHeap(mbh.getHeap(), mbh.size());
  }
  
  public static void printHeapCollection(EntryPair[] e) { 
    System.out.println("Printing Collection to pass in to build function:");
    for(int i=0;i < e.length;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
  
  public static void printHeap(EntryPair[] e,int len) { 
    System.out.println("Printing Heap");
    for(int i=1;i < len+1;i++){
      System.out.print("("+e[i].value+","+e[i].priority+")\t");
    }
    System.out.print("\n");
  }
}