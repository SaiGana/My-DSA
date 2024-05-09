
class QueueArray{
    QueueArray() {
        int rear, front = 0;
        arr = new int[10];
    }
    int rear, front;
    int[] arr;
    public void enque(int value){
        if(rear==arr.length){
            System.out.println("overflow");
            return;

        }
        arr[rear]=value;
        rear++;
    }
    public void deque(){
        if(front==rear){
            System.out.println("empty");
            return;
        }
        for(int i=0;i<rear-1;i++){
            arr[i]=arr[i+1];
        }
        if(rear<arr.length){
            arr[rear]=0;
            rear--;
        }
    }
    public void print(){
        for(int i=0;i<rear;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }


}

public class Queue {
    public static void main(String[] args) {
        QueueArray q=new QueueArray();
        q.enque(10);
        q.enque(15);
        q.enque(11);
        q.print();
        q.deque();
        q.print();


    }
}
