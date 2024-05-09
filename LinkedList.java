
public class LinkedList {
    static Node head;
    static Node tail;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;

        }
    }
    public void insert(int value){
        Node curr_node=new Node(value);
        curr_node.next=null;
        if(head==null){
            head=curr_node;
            tail=curr_node;
        }
        else{
            tail.next=curr_node;
            tail=curr_node;
        }
    }
    public void delete(int value){
        Node curr_node=head;
        Node prev=null;
        if(curr_node.next!=null && curr_node.data==value){

                head=curr_node.next;
                return;

        }

        while (curr_node.next != null) {
            if (curr_node.data == value) {
                    prev.next = curr_node.next;
                    return;

            }
            prev = curr_node;
            curr_node = curr_node.next;
        }
        if (curr_node.data == value) {
            prev.next = curr_node.next;
        }

    }
    public void search(int value){
        Node temp=head;
        while(temp.next!=null){
            if(temp.data==value){
                System.out.println("Found");
                return;
            }
            temp=temp.next;
        }
        if(temp.data==value){
            System.out.println("Found");
        }
        else{
            System.out.println("not found");
        }
    }

    public void print(){
        if(head==null) return;
        Node temp=new Node(head.data);
        temp.next=head.next;
        while(temp.next!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.print(temp.data+" ");
        System.out.println();


    }

    public void sortedInsert(int val){
        Node insert=new Node(val);
        if(head==null){
            head=insert;
            return;
        }
        Node curr=head;
        Node prev=null;
        if(curr.data>insert.data){
            head=insert;
            insert.next=curr;
            return;
        }
        while(curr.next!=null){
            if(curr.next.data>insert.data && curr.data<=insert.data){
                insert.next=curr.next;
                curr.next=insert;
                return;
            }
            prev=curr;
            curr=curr.next;

        }
        if(curr.data>insert.data){
            insert.next=curr;
            prev=insert;
        }
        else{
            curr.next=insert;
        }


    }

    public void middleElement(){
        int length=0;

        if(head==null) return;
        Node temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        temp=head;
        length=(length/2)+1;
        for(int i=1;i<length;i++){
            temp=temp.next;
        }
        System.out.println(temp.data);

    }
    public void nthNodeFromEnd(int position){


        Node temp=head;
        int count=0;
        Node val=head;

        boolean isLength=false;

        while(temp!=null){

            if(count<position){
                temp=temp.next;
                count++;

            }
            else{
                isLength=true;
                val=val.next;
                temp=temp.next;


            }
        }
        if(count>=position || isLength) System.out.println(val.data);
    }
    public void reverse(){
        /*This method reverses the linked list

         */
        if(head==null) return;
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

        }
        head=prev;
    }
    public void reverseRecursive(Node h,Node prev){
        /* Implementation of reverse method using recursion.

         */
        if(h==null) return;

        Node temp=h.next;
        h.next=prev;
        prev=h;
        head=prev;
        reverseRecursive(temp,prev);


    }
    public void removeDuplicates(){
        /*This method remove duplicates from the linked list
        Works only when Linked List is sorted.
         */
        if(head==null) return;
        if(head.next==null) return;

        Node temp=head.next;
        Node prev=head;
        while(temp.next!=null){
            if(temp.data==prev.data){
                prev.next=temp.next;
                temp=temp.next;

            }
            else{
                prev=temp;
                temp=temp.next;
            }
        }
        if(temp.data==prev.data){
            prev.next=temp.next;
        }


    }

    public static void main(String[] args) {
        int a=10;
        



    }


}

