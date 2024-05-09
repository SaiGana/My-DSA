import java.util.*;

public class Arrayss {
    public static void main(String[] args) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(1,1);
        hm.put(2,2);
        for(var set:hm.entrySet()){
            System.out.println(set.getValue()+" "+set.getKey());
        }


    }
    public static int kadaneAlgorithm(int[] arr){
        int max_so_far=Integer.MIN_VALUE;
        int max_present=0;
        int start=0;
        int end=0;
        int start1=0;
        int end1=0;
        for(int i=0;i<arr.length;i++){

            max_present=max_present+arr[i];
            if(max_so_far<max_present){
                max_so_far=max_present;
                end=i;
                start1=start;
                end1=end;

            }
            if(max_present<0){
                max_present=0;
                start=i+1;
                end=i+1;
            }
        }
        System.out.print("[ ");
        for(int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println(" ]");

        return max_so_far;
    }
    public static int evenOdd(int[] arr){
        int maximum=Integer.MIN_VALUE;
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]%2==0 && arr[i-1]%2!=0){
                count++;
            }
            else if (arr[i]%2!=0 && arr[i-1]%2==0){
                count++;
            }
            else{
                maximum=Math.max(maximum,count);
                count=1;
            }
        }
        maximum=Math.max(maximum,count);
        return maximum;
    }

    public static void transpose(int[][] matrix){
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            int ii=i+1;
            while(ii<m){
                int temp=matrix[ii][i]^matrix[i][ii];
                matrix[ii][i]=temp^matrix[ii][i];
                matrix[i][ii]=temp^matrix[i][ii];
                ii++;
            }
        }

    }
    public static void matrixPrint(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int trappingRainWater(int[] arr){
        int sum=0;
        int i=1;
        int start=0;
        while(i<arr.length){
            while(i<arr.length && arr[i]>=arr[i-1]){

                   start=Math.max(arr[i],arr[i-1]);
                   i++;

            }
            int sum1=0;
            while(i<arr.length && arr[i]<=start){
                sum1+=start-arr[i];
                System.out.println(sum1);
                i++;
            }
            if(i<arr.length && arr[i]>=start){
                sum+=sum1;
            }
        }
        return sum;
    }
}
