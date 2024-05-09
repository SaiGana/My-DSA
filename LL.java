import java.util.*;

public class LL {
    public static void main(String[] args) {
        Node num1=new Node(1);
        Node head1=num1;
        for(int i=2;i<=5;i++){
            num1.next=new Node(i);
            num1=num1.next;
        }

        Node num2=new Node(10);
        num1.next=num2;
        Node head2=num2;
        for(int i=7;i<11;i++){
            num2.next=new Node(i);
            num2=num2.next;
        }
        //num2.next=num1;
        Node head3=new Node(11);
        head3.next=head3;
        LLOperations op=new LLOperations();
        System.out.println(op.detectLoop(head1));
        System.out.println(op.detectCycle2(head1));







    }


}



class  Node{
    int data;
    Node next;
    Node(int x){
        data=x;
        next=null;
    }
}
class LLOperations{

    boolean detectCycle2(Node head){
        //Optimized
        // In this method we use torotoise hare algorithm to detect loop;
        Node temp1=head;
        Node temp2=head;
        while(true){
            if(temp1==null || temp2==null|| temp2.next==null) return false;
            temp1=temp1.next;
            temp2=temp2.next.next;
            if(temp1==temp2) break;

        }
        // if we want to detect loop then we can return true here itself but
        // if we want to find where this loop starts then use floyd's algorithm which is extension;
        temp1=head;
        while(temp1!=temp2){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;
    }
    boolean detectLoop(Node head){
        //Naive Approach
        HashSet<Node> hs=new HashSet<>();
        Node temp1=head;
        while(temp1!=null){
            System.out.print(temp1.data+" ");
            if(hs.contains(temp1)){
                return true;
            }
            else{
                hs.add(temp1);
                temp1=temp1.next;
            }
        }

        return false;
    }


    Node intersectionPoint2(Node head1,Node head2){
        // Optimised Approach
        int length1=0;
        int length2=0;
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null){
            length1++;
            temp1=temp1.next;
        }
        while(temp2!=null){
            length2++;
            temp2=temp2.next;
        }
        temp1=head1;
        temp2=head2;
        if(length1!=length2){
            int diff=0;
            if(length1<length2){
                diff=length2-length1;
                while(diff!=0){
                    temp2=temp2.next;
                    diff--;
                }
            }
            else{
                diff=length1-length2;
                while(diff!=0){
                    temp1=temp1.next;
                    diff--;
                }
            }
        }
        while(temp1!=null && temp2!=null){
            if(temp1==temp2) return temp1;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return null;
    }

    Node intersectionPoint(Node head1,Node head2){
        // this method finds the intersetion point of two ll and return the intersection node;
        // Naive or brute force approach
        HashSet<Node> hs=new HashSet<>();
        Node temp1=head1;
        while(temp1!=null){
            hs.add(temp1);
            temp1=temp1.next;
        }
        Node temp2=head2;
        while(temp2!=null){
            if(hs.contains(temp2)){
                Node t=new Node(temp2.data);
                return t;

            }
            temp2=temp2.next;
        }
        return null;
    }
    Node addOne3(Node head){
        int carry=addOne2(head);
        if(carry==0){
            return head;
        }
        else{
            Node n=new Node(carry);
            n.next=head;
            return n;
        }
    }

    int addOne2(Node head){
        //Optimised approach
        if(head==null){
            return 1;
        }
        int carry=addOne2(head.next);
        int sum=head.data+carry;
        head.data=sum%10;
        carry=sum/10;
        return carry;

    }
    Node addOne(Node head){
        // Naive Approach.
        Node h=reverse(head);
        Node temp=h;
        int sum=0;
        int carry=1;


        while(temp!=null && carry!=0){
            sum=temp.data+carry;
            carry=sum/10;
            temp.data=sum%10;
            if(temp.next==null){
                if(carry!=0){
                    temp.next=new Node(carry);
                    break;
                }
            }
            temp=temp.next;

        }
        return reverse(h);

    }
    boolean Palindrome(Node head){
        if(head.next==null) return true;
        Node slow=head;
        Node fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node rev=reverse(slow.next);
        Node temp=head;
        while(rev!=null){
            if(temp.data!=rev.data) return false;
            rev=rev.next;
            temp=temp.next;
        }
        rev=reverse(slow.next);
        return true;

    }
    int NthNodeFromEnd(Node head,int pos){
        if(head==null) return -1;
        Node temp=head;
        int p=pos-1;
        while(temp!=null && p!=0){
            temp=temp.next;
            p--;
        }
        if(temp==null) return -1;
        Node result=head;
        while(temp.next!=null){
            temp=temp.next;
            result=result.next;
        }
        return result.data;

    }
    Node sortZeroOneTwo(Node head){
        if(head==null)return null;
        if(head.next==null) return head;
        Node zero=null;
        Node zero1=null;
        Node one=null;
        Node one1=null;
        Node two=null;
        Node two1=null;
        Node temp=head;
        while(temp!=null){
            if(temp.data==0){
                if(zero==null){
                    zero=temp;
                    zero1=temp;
                }
                else{
                    zero.next=temp;
                    zero=zero.next;
                }
            }
            else if(temp.data==1){
                if(one==null){
                    one=temp;
                    one1=temp;
                }
                else{
                    one.next=temp;
                    one=one.next;
                }
            }
            else{
                if(two==null){
                    two=temp;
                    two1=temp;

                }
                else{
                    two.next=temp;
                    two=two.next;
                }
            }
            temp=temp.next;

        }
        if(two!=null){
            two.next=null;
        }
        if(zero!=null){
            zero.next=one1;
            if(one1!=null){
                one.next=two1;
            }
        }
        return zero1;
    }
    Node oddEven(Node head){
        if(head==null) return null;
        if(head.next==null) return head;
        Node odd=head;
        Node even=head.next;
        Node itr=head.next;
        while(odd!=null && even!=null){
            boolean oddd=true;
            boolean evenn=true;
            if(odd.next!=null){
                if(odd.next.next!=null){
                    odd.next=odd.next.next;
                    odd=odd.next;
                    oddd=false;
                }
            }
            if(even.next!=null){
                if(even.next.next!=null){
                    even.next=even.next.next;
                    even=even.next;
                    evenn=false;
                }
            }
            if(oddd && evenn) break;
        }
        even.next=null;
        if(itr!=odd.next){
            odd.next=itr;
        }
        return head;
    }

    Node addTwoNumbers(Node num1,Node num2){
        // This method takes two LL which contains digits in reverse order. We need to find the sum and return a ll with contains digits in reverse order.
        /*if(num1==null && num2==null) return null;
        int digit=0;
        int carry=0;
        Node temp1=num1;
        Node temp2=num2;
        boolean h=false;
        Node head=new Node(0);
        Node temp=head;
        int sum;
        while(temp1!=null && temp2!=null){
            sum=temp1.data+temp2.data+carry;
            digit=sum%10;

            carry=sum/10;
            if(!h){
                head.data=digit;
                h=true;
            }
            else{
                temp.next=new Node(digit);
                temp=temp.next;

            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            sum=temp1.data+carry;
            digit=sum%10;
            carry=sum/10;
            temp.next=new Node(digit);
            temp=temp.next;
            temp1=temp1.next;
        }
        while(temp2!=null){
            sum=temp2.data+carry;
            digit=sum%10;
            carry=sum/10;
            temp.next=new Node(digit);
            temp=temp.next;
            temp2=temp2.next;
        }
        if(carry!=0){
            temp.next=new Node(carry);
        }
        return head;*/
        int carry=0;
        int sum=0;
        Node dummy=new Node(-1);
        Node curr=dummy;
        Node temp1=num1;
        Node temp2=num2;
        while(temp1!=null || temp2!=null){
            sum=carry;
            if(temp1!=null) sum+=temp1.data;
            if(temp2!=null) sum+=temp2.data;
            curr.next=new Node(sum%10);
            curr=curr.next;
            if(temp1!=null) temp1=temp1.next;
            if(temp2!=null) temp2=temp2.next;
            carry=sum/10;
        }
        if(carry!=0){
            curr.next=new Node(carry);
            curr=curr.next;
        }
        return dummy.next;


    }
    void print(Node head){
        // This method traveres the node and print all the elements in the linked list
        if(head==null) System.out.println("null");
        Node temp=head;
        if(temp==null) return;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }

    int length(Node head){

        Node temp=head;
        int length=0;
        while(temp!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }
    void recursivePrint(Node head){
        if(head==null) return;
        System.out.println(head.data);
        recursivePrint(head.next);
    }
    boolean search(Node head,int value){
        // this method search the given value.
        if(head==null) return false;
        Node temp=head;
        while(temp!=null){
            if(temp.data==value) return true;
            temp=temp.next;
        }
        return false;
    }
    boolean recursiveSearch(Node head,int value){
        // This method search the element using recursion
        if(head==null) return false;
        if(head.data==value){
            return true;
        }
        return recursiveSearch(head.next,value);
    }
    Node insertBeg(Node head,int value){
        // This method inserts the node at the beginning.
        if(head==null){
            return new Node(value);
        }
        Node temp=new Node(value);
        temp.next=head;
        return temp;
    }
    Node insertEnd(Node head,int value){
        // this method insert the given node at the end.
        if(head==null) {
            return new Node(value);
        }
        Node temp=new Node(value);
        Node itr=head;
        while(itr.next!=null){
            itr=itr.next;
        }
        itr.next=temp;
        return head;
    }
    Node deleteFirst(Node head){
        // This method deletes the first node
        if(head==null) return null;
        head=head.next;
        return head;
    }
    Node deleteLast(Node head){
        // This method delete the last node
        if(head==null || head.next==null) return null;
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=temp.next.next;
        return head;
    }

    Node insertPosition(Node head,int pos,int value){
        // this method inserts the given value at the given position and
        // if the position is greater than length+1 then it does not insert
        if(head==null) return null;
        Node temp=new Node(value);
        if(pos==1){
            temp.next=head;
            return temp;
        }
        Node itr=head;
        int p=1;
        while(p<=pos-2 && itr!=null){
            itr=itr.next;
            p++;
        }
        if(itr==null) return head;
        Node temp2=itr.next;
        itr.next=temp;
        temp.next=temp2;
        return head;

    }
    Node sortedInsert(Node head,int value){
        // this method inserts the element in a sorted order.
        Node temp=new Node(value);
        if(head==null) return temp;
        if(head.data>value){
            temp.next=head;
            return temp;
        }
        Node itr=head;
        while(itr.next!=null && itr.next.data<value){
            if(itr.data==value) return head;
            itr=itr.next;
        }
        Node temp2=itr.next;
        itr.next=temp;
        temp.next=temp2;
        return head;
    }
    int middle(Node head){
        //This method finds the middle element.

        Node temp=head;
        Node middle=head;
        while(temp!=null && temp.next!=null){
            temp=temp.next.next;
            middle=middle.next;
        }
        if(middle!=null)
        return middle.data;
        else return -1;
    }

    Node reverse(Node head){
        // this method reverse the linked list.
        if(head==null) return null;

        Node itr=head;
        Node temp=head.next;
        itr.next=null;

        while(temp!=null){
            Node temp2=temp.next;
            temp.next=itr;
            itr=temp;
            temp=temp2;
        }
        return itr;
    }

    Node reverseRecursive(Node head){
        // this method reverse the linked list
        if(head==null || head.next==null) return head;
        Node restHead=reverseRecursive(head.next);
        Node temp=head.next;
        temp.next=head;
        head.next=null;
        return restHead;
    }
    Node reverseRecursive2(Node head,Node prev){
        //This method reverses the Linked list
        if(head==null) return prev;
        Node next=head.next;
        head.next=prev;

        return reverseRecursive2(next,head);
    }
    Node removeDuplicates(Node head){
        // This method removes all the duplicates in a given sorted linked list.
        if(head==null || head.next==null) return head;
        Node temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.next.data==temp.data){
                temp.next=temp.next.next;
            }

            temp=temp.next;

        }
        return head;
    }

}

class DNode{


    int data;
    DNode next;
    DNode prev;

    DNode(int x) {
        data = x;
        next = null;
        prev = null;
    }

}
class DLOperations{
    public void print(DNode head){
        DNode temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;

        }
        System.out.println();
    }
    public DNode insertB(DNode head,int val){
        if(head==null){
            return new DNode(val);
        }
        DNode temp=new DNode(val);
        temp.next=head;
        head.prev=temp;
        return temp;
    }
    public DNode reverse(DNode head){
        if(head==null) return null;
        DNode temp=head;
        DNode temp2=head.next;
        temp.next=temp.prev;
        temp.prev=temp2;


        while(temp!=null && temp.prev!=null){
            temp=temp.prev;
            temp2=temp.next;
            temp.next=temp.prev;
            temp.prev=temp2;


        }
        return temp;
    }

}




