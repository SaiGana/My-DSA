class Heap {
    static int size=0;
    static int capacity=1;
    Heap(int x){
        arr=new int[x];
        capacity=x;
        size=0;
    }
    static int[] arr;

    int leftChild(int i){
        return 2*i+1;
    }
    void print(){
        for(int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    int sizee(){
        return size;
    }
    int rightChild(int i){
        return 2*i+2;
    }
    int parent(int i){
        if(i==0) return 0;
        return (i-1)/2;
    }
    void swap(int i,int j){
        int temp=arr[i]^arr[j];
        arr[i]=temp^arr[i];
        arr[j]=temp^arr[j];
    }
    void insert(int element){
        if(size==0){
            arr[0]=element;
            size++;
            return;
        }
        size++;
        arr[size-1]=element;
        int temp=size-1;
        while(temp!=0 && arr[parent(temp)]>arr[temp]){
            swap(parent(temp),temp);
            temp=parent(temp);
        }

    }

    void heapify(int i){
        int left=leftChild(i);
        int right=rightChild(i);
        int smallest=i;
        if(left<size && arr[i]>arr[left]){
            smallest=left;
        }
        if(right <size && arr[smallest]>arr[right]){
            smallest=right;
        }
        if(i!=smallest){
            swap(i,smallest);
            heapify(smallest);
        }


    }
    int extractMin(){
        if(size==0) return Integer.MIN_VALUE;
        if(size==1){
            size--;
            return arr[size];
        }
        size--;
        swap(0,size);
        heapify(0);
        return arr[size];
    }

    void decreaseKey(int index, int x){
        arr[index]=x;
        while(index!=0 && arr[parent(index)]>arr[index]){
            swap(index,parent(index));
            index=parent(index);
        }
    }
    void delete(int index){
        decreaseKey(index,Integer.MIN_VALUE);
        int k=extractMin();
    }
    void buildHeap(int[] array){
        for(int i=(array.length-2)/2;i>=0;i--){
            heapify(i);
        }
    }

}

public class Heapp {
    public static void main(String[] args) {
        Heap h=new Heap(10);
        for(int i=9;i>=0;i--){
            h.insert(i*10);
        }
        h.print();
        System.out.println();
        int[] arr=new int[10];
        for(int i=9;i>=0;i--){
            arr[i]=i*10;
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        h.buildHeap(arr);
        for( int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(h.extractMin());
        System.out.println(h.extractMin());
        h.print();
        h.delete(2);
        h.print();
        h.decreaseKey(5,10);
        h.print();




    }
}