class Heap{
    private int heap[];
    private int size;
    
    //constructor
    public Heap(int n){
        heap = new int[n];
        this.size = -1;
    }

    //void methods
    public void insert(int element){
        if(!full()) {
          size++;
          heap[size] = element;        
          if(size!=0){
              swiftUp(size);
          }
        }else{System.out.println("Heap is full");}        
    }

    public void printHeap(){
      for(int i=0; i<=size;i++){
        System.out.println(heap[i]);
      }
    }

    private void swiftDown(int index){
        int minIndex = index;
        int left = leftChild(index);
        int save;
        if (left<= size && heap[left]< heap[minIndex]){
            minIndex = left;
        }
        int right=rightChild(index);
        if (right<= size && heap[right]< heap[minIndex]){
            minIndex = right;
        }
        if(index!=minIndex){
            save = heap[index];
            heap[index] = heap[minIndex];
            heap[minIndex] = save;
            swiftDown(minIndex);
        }
    }

    private void swiftUp(int index){
        int save;
        while(index>=0 && heap[parent(index)]> heap[index]){
          save = heap[parent(index)];
          heap[parent(index)] = heap[index];
          heap[index] =save;
          index = parent(index);
        }
    }
    
    public boolean full(){return size == heap.length-1;}
    public int size(){return size+1;}
    public int getMin(){return heap[0];}
    private int parent(int index){return (index/2); }
    private int leftChild(int index){return (index*2); }
    private int rightChild(int index){return ((index*2)+1); }    
    public boolean empty(){return size == 0;}
    
    public int extractMin(){
        int answer = heap[0];
        heap[0]= heap[size];
        size--;
        if(size>=1){
            swiftDown(0);
        }        
        return answer;
    }            
}