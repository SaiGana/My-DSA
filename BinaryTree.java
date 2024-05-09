public class BinaryTree {
    public static void main(String[] args) {
        TOperations Operation=new TOperations();
        TNode a1=new TNode(10);
        TNode a2=new TNode(20);
        TNode a3=new TNode(30);
        TNode a4=new TNode(40);
        TNode a5=new TNode(50);
        TNode a6=new TNode(60);
        TNode a7=new TNode(70);
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        a3.left=a6;
        a3.right=a7;
        a7.right=new TNode(80);
        a7.right.right=new TNode(90);
        Operation.inorder(a1);
        System.out.println();
        Operation.preorder(a1);
        System.out.println();
        Operation.postorder(a1);
        System.out.println();
        Operation.kDistance(a1,5);
        System.out.println(Operation.size(a2));
        System.out.println(Operation.max(a3));




    }
}
class TOperations{
    void inorder(TNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.data+" ");
        inorder(root.right);

    }
    void postorder(TNode root){
        if(root==null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data+" ");
    }
    void preorder(TNode root){
        if(root==null) return;
        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right);
    }
    int height(TNode root){
        if(root==null) return 0;
        return 1+Math.max(height(root.right),height(root.left));
    }
    void kDistance(TNode root,int k){
        if(root==null) return;
        if(k==0 && root!=null){
            System.out.print(root.data+" ");
        }
        else{
            kDistance(root.left,k-1);
            kDistance(root.right,k-1);
        }

    }
    int size(TNode root){
        if(root==null) return 0;
        return 1+size(root.right)+size(root.left);
    }
    int max(TNode root){
        if(root==null) return 0;
        return Math.max(root.data,Math.max(max(root.right),max(root.left)));
    }
}
class TNode{
    int data;
    TNode left;
    TNode right;
    TNode(int x){
        data=x;
        left=null;
        right=null;
    }
}
