import java.sql.Array;
import java.sql.SQLOutput;
import java.util.*;
class StackArray{
    int top=-1;


    int[] arr=new int[10];

    public void push(int value){
        if(top==arr.length-1){
            System.out.println("overflow");
        }
        else{
            top++;
            arr[top]=value;
            System.out.println(arr[top]);

        }

    }
    public void pop(){
        if(top==-1){
            System.out.println("underflow");
        }else{
            System.out.println(arr[top--]);
        }
    }
    public void peek(){
        if(top==-1){
            System.out.println("no peek");

        }
        else{
            System.out.println(arr[top]);
        }
    }


}
class StackLinkedList{
    static class Node{
        int data;
        Node next;
    }
    StackLinkedList(){
        this.top=null;
    }
    Node top;

    public void push(int value){
        Node temp=new Node();
        temp.data=value;
        temp.next=top;
        top=temp;
    }
    public void pop(){
        if(top==null){
            System.out.println("underflow");


        }
        else{
            Node temp=top;
            top=top.next;
            System.out.println(temp.data);
        }
    }
    public void peek(){
        if(top==null){
            System.out.println("Underflow");
        }
        else{
            System.out.println(top.data);
        }
    }
    public void print(){
        Node temp=top;
        if(top==null){
            System.out.println("empty");
            return;
        }
        while(temp.next!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.print(temp.data+" ");
        System.out.println();
    }
}
public class SStack {


    public static void main(String[] args) {
       

    }

}
