package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; 
  private int size;
  private static final int arraySize = 10000;

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000);
  }
    
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

  @Override
  public void insert(EntryPair entry) {
	if (entry == null) {
		return;
	}
	
	if (size == 0) {
		array[1] = entry;
		size++;
		return;
	} else {
		array[size + 1] = entry;
		size++;
		bubbleUp(size);
		return;
	}
	
  }

  @Override
  public void delMin() {
	if (size == 0) {
		return;
	}
	
	array[1] = array[size];
	array[size] = null;
	size--;
	bubbleDownBuild(1);
	
  }

  @Override
  public EntryPair getMin() {
	return array[1];
  }

  @Override
  public int size() {
	return size;
  }

  @Override
  public void build(EntryPair[] entries) {
	  if (entries == null) {
		  return;
	  }
	  for (int i = 0 ; i < entries.length ; i++) {
		  if (entries[i] != null) {
			  array[i+1] = entries[i];
			  size++;
		  } else {
			  return;
		  }
	  }
	  if (size == 1) {
		  return;
	  }
	  
	  int i = (int) Math.floor(size/2);
	  
	  while (i > 0) {
		  bubbleDownBuild(i);
		  i--;
	  }
	
  }
  
  private void bubbleUp(int index) {
	  int height = (int) Math.ceil(Math.log(size) / Math.log(2));
	  int childIndex = index;
	  int parentIndex = (int) Math.floor(index/2);
	  for (int i = 0 ; i < height ; i++) {
		  if (array[parentIndex].priority < array[childIndex].priority) {
			  break;
		  } else if (array[parentIndex].priority > array[childIndex].priority) {
			  EntryPair temp = array[parentIndex];
			  array[parentIndex] = array[childIndex];
			  array[childIndex] = temp;
			  childIndex = parentIndex;
			  parentIndex = (int) Math.floor(parentIndex/2);
		  }
	  }
  }
  
  private void bubbleDownBuild(int index) {
	  int PI = index;
	  
	  if (hasChild(PI) == -1) {
		  return;
	  } else if (hasChild(PI) == 0) {
		  int LI = PI * 2;
		  if (array[PI].priority < array[LI].priority) {
			  return;
		  } else {
			  EntryPair temp = array[PI];
			  array[PI] = array[LI];
			  array[LI] = temp;
			  bubbleDownBuild(LI);
			  return;
		  }
	  } else {
		  int LI = PI * 2;
		  int RI = (PI*2) + 1;
		  if (array[LI].priority < array[RI].priority) {
			  if (array[LI].priority < array[PI].priority) {
				  EntryPair temp = array[PI];
				  array[PI] = array[LI];
				  array[LI] = temp;
				  bubbleDownBuild(LI);
				  return;
			  } else {
				  return;
			  }
		  } else {
			  if (array[RI].priority < array[PI].priority) {
				  EntryPair temp = array[PI];
				  array[PI] = array[RI];
				  array[RI] = temp;
				  bubbleDownBuild(RI);
				  return;
			  } else {
				  return;
			  }
		  }
	  }
  }
  
  private int hasChild(int index) {
	  if ((index * 2) > size) {
		  return -1;
	  } else if ((index*2) + 1 > size) {
		  return 0;
	  } else {
		  return 1;
	  }
  }
  
}