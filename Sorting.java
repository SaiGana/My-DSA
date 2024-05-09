import java.lang.reflect.Array;
import java.security.KeyPair;
import java.util.*;



public class Sorting {

    public static void main(String[] args) {


    }

    public static void threeWayPartitioning(int[] arr){
        /* This method partition the array of 0s,1s,and 2s in the order
        the time complexity is O(n).
        Try with Dutch National Flag Algorithm.
         */
        int left=-1;
        int right=arr.length;
        int index1=0;
        int index2=arr.length-1;
        int count=0;
        int count1=0;
        while(index1<=index2){
            if(arr[index1]==0){
                left++;
                swap(arr,left,index1);
            }

            if(arr[index2]==2){
                right--;
                swap(arr,right,index2);
            }
            while(arr[index1]!=0 && arr[index2]!=2){
                boolean b=true;
                swap(arr,index1,index2);
                if(arr[index1]==0){
                    left++;
                    swap(arr,left,index1);
                    b=false;

                }


                if(arr[index2]==2){
                    right--;
                    swap(arr,right,index2);
                    b=false;
                }
                if(b) break;




            }
            index1++;
            index2--;

        }
    }

    public static int kthSmallestElementQuickSelect(int arr[] ,int k){
        /* This method uses lomuto partition to find kth smallest element in an array.
        This method is applicable when array elements are unique.
         */
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int p=lomutoPartition(arr,left,right);
            if(p==k-1) return arr[p];
            else if(p<k-1) left=p+1;
            else right=p-1;

        }
        return -1;
    }
    public static int kthSmallestElement(int[] arr,int k){
        /* This method return kth smallest element in the given array.
        First we sort the array and find the kth smallest no. and return it if we can't find it then return -1.
        Time complexity is O(n*logn).
         */
        quickSortHoares(arr,0,arr.length-1);
        int count=0;

        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            else count++;
            if(count==k){
                return arr[i];
            }
        }
        return -1;
    }

    public static int countInversionMerge(int[] arr,int left,int right){
        int inv=0;
        if(left<right){
            int mid=left+(right-left)/2;
            inv+=countInversionMerge(arr,left,mid);
            inv+=countInversionMerge(arr,mid+1,right);
            inv+=countAndMerge(arr,left,mid,right);
        }
        return inv;
    }

    public static int countAndMerge(int[] arr,int left,int mid,int right){
        /*This method is used by countInversionMerge method to count
         no. of inversions in two sorted arrays invidividually and return total no. of inversions.
         */
        int inv=0;
        int n1=mid-left+1;
        int n2=right-mid;
        int[] arr1=new int[n1];
        int[] arr2=new int[n2];
        for(int i=0;i<n1;i++) arr1[i]=arr[left+i];
        for(int j=0;j<n2;j++) arr2[j]=arr[j+mid+1];
        int index1=0;
        int index2=0;
        int index=left;
        while(index1<n1 && index2<n2){
            if(arr1[index1]<=arr2[index2]){
                arr[index++]=arr1[index1++];
            }
            else{
                arr[index++]=arr2[index2++];
                inv+=n1-index1;
            }
        }
        while(index1<n1){
            arr[index++]=arr1[index1++];
        }
        while(index2<n2){
            arr[index++]=arr2[index2++];
        }
        return inv;

    }

    public static int countInversion(int[] arr){
        /*This method count the no. of inversions in the array.
        We use the Insertion sort for this .
        Inversion is defined as for i<j --> arr[i]>arr[j].
        Try another way using merge sort which reduces time complexity.
         */
        int count=0;
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];
            int left=i-1;
            while(left>=0 && temp<arr[left]){
                count++;
                arr[left+1]=arr[left];
                left--;

            }
            arr[left+1]=temp;
        }
        return count;
    }

    public static void unionOfTwoSortedArrays(int[] arr1,int[] arr2){
        /*This method prints the union of two sorted arrays in a sorted order.
        Prints only unique elements.
         */
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if(i>0 && arr1[i]==arr2[i-1]) {
                i++;
                continue;
            }
            if(j>0 && arr2[j]==arr2[j-1]){
                j++;
                continue;
            }
            if(arr1[i]<arr2[j]){
                System.out.println(arr1[i]);
                i++;
            }
            else if(arr1[i]>arr2[j]){
                System.out.println(arr2[j]);
                j++;
            }
            else{
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
        while(i<arr1.length){
            if(i>0 && arr1[i]!=arr1[i-1]) System.out.println(arr1[i]);
            i++;
        }
        while(j<arr2.length){
            if(j>0 && arr2[j]!=arr2[j-1]) System.out.println(arr2[j]);
            j++;
        }
    }
    public static void intersectionOfTwoSortedArrays(int[] arr1,int[] arr2){
        /* This method finds the intersection of two arrays and prints the elements.
        Two arrays are already sorted.
        Only print unique elements.
         */
        int i=0;
        int j=0;
        while(i<arr1.length && j<arr2.length){
            if( i>0 && arr1[i-1]==arr1[i]){
                i++;
                continue;
            }
            if(arr1[i]<arr2[j]){

                i++;
            }
            else if(arr1[i]>arr2[j]){
                    j++;
            }
            else{
                System.out.print(arr1[i]+" ");
                i++;
                j++;
            }
        }
    }

    public static int minDifference(int[] arr){
        /* This method finds the minimum difference in the array.
         */
        quickSortHoares(arr,0,arr.length-1);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++){
            int temp=Math.abs(arr[i]-arr[i-1]);
            min=Math.min(min,temp);
        }
        return min;

    }

    public static int shellSort(int[] arr){
        /* This method implements shell sort which is improvement to insertion sort to reduce no. of swaps
        The best time complexity is O(n*logn)
        The average time complexity is O(n*(logn)^2)
        The worst time complexity is O(n*n)
        This method returns the no. of swaps took place during sorting process.
         */
        int countSwap=0;
        int n=arr.length;
        for(int gap=n/2;gap>0;gap/=2){
            for(int i=gap;i<n;i++){
                int temp=arr[i];
                int j=i;
                for(j=i;j>=gap && arr[j-gap]>temp;j-=gap){
                    arr[j]=arr[j-gap];
                    countSwap++;
                }
                arr[j]=temp;
            }

        }
        return countSwap;
    }

    public static void bucketSort(int[] arr,int k){
        /*This method implements the bucket sort and where k is the no. of buckets.
        Best time complexity is O(n) and worst case is O(n*n)
        Best suitable to use if the data is uniformly distributed in the range.
         */
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            max=Math.max(max,arr[i]);
        }
        max++;
        ArrayList<ArrayList<Integer>> bucket=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<k;i++) bucket.add(new ArrayList<Integer>());
        for(int i=0;i<arr.length;i++){
            int temp=(k*arr[i])/max;
            bucket.get(temp).add(arr[i]);
        }
        for(int i=0;i<k;i++) Collections.sort(bucket.get(i));
        int index=0;
        for(int i=0;i<k;i++){
            for(int j=0;j<bucket.get(i).size();j++){
                arr[index]=bucket.get(i).get(j);
                index++;
            }
        }
    }
    public static void radixSort(int[] arr,int n){
        /*In this method we implement radix sort by calling count sort .
        In couting sort we make some modification to make count sort for radix sort.
        This method takes O(d*(n+b)) space where d is the no. of digits and b is the base.
        It is a stable algorithm.
         */
        int max=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        for(int exp=1;(max/exp)>0;exp=exp*10){
            countSort(arr,n,exp);
        }
    }
    public static void countSort(int[] arr,int n,int exp){
        // This method is used for radix sort.
        int[] count=new int[10];
        int[] output=new int[n];
        for(int i=0;i<n;i++) count[(arr[i]/exp)%10]++;
        for(int i=1;i<10;i++) count[i]=count[i]+count[i-1];
        for(int i=n-1;i>=0;i--){
            output[count[(arr[i]/exp)%10]-1]=arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for(int i=0;i<n;i++) arr[i]=output[i];
    }

    public static void countingSort(int[] arr,int k){
        /* This method implements the countingSort where the elements of an array are in range 0 to k
        Time complexity is O(n+k) and space complexity is O(n+k)
        It is stable and not inplace.
        The value of k should be maximum element in the array plus one.
        It is not a comparison based algorithm.
         */
        int n=arr.length;
        int[] count=new int[k];
        for(int i=0;i<n;i++) count[arr[i]]++;
        for(int i=1;i<k;i++) count[i]=count[i]+count[i-1];
        int[] output=new int[n];
        for(int i=n-1;i>=0;i--){
            output[count[arr[i]]-1]=arr[i];
            count[arr[i]]--;
        }
        for(int i=0;i<n;i++) arr[i]=output[i];
    }

    public static void quickSortHoares(int[] arr,int start_index,int end_index){
        /* This method implements quick Sort using Hoare's partition
        We can use tail recursion elimination to optimize the code.
         */
        if(start_index<end_index){
            int k=hoaresPartition(arr,start_index,end_index);
            quickSortHoares(arr,start_index,k);
            quickSortHoares(arr,k+1,end_index);
        }
    }

    public static void quickSortLomuto(int[] arr,int start_index,int end_index){
        /*This method implements quick Sort using lomuto partition

         */
        if(start_index<end_index){
            int k=lomutoPartition(arr,start_index,end_index);
            quickSortLomuto(arr,start_index,k-1);
            quickSortLomuto(arr,k+1,end_index);
        }
    }

    public static int lomutoPartition(int[] arr,int start_index,int end_index){
        /* This method partitions the array given the pivot as all the elements
        greater or equal are on the right side and lesser on left side.
        By default we consider pivot to be end index.
        Not stable.
        Time complexity is O(n) and space complexity is O(1);
        This method return index of the pivot after partition
         */

        int low=start_index-1;
        int pivot=arr[end_index];

        for(int i=start_index;i<arr.length;i++){
            if(arr[i]<pivot){
                low++;
                swap(arr,i,low);
            }
        }

        swap(arr,low+1,end_index);
        return low+1;
    }

    public static int hoaresPartition(int[] arr,int start_index,int end_index){
        /*This method also does partition but only difference is here we partition the element greater
        on one side and lesser on one side .
        Not stable.
        By default we consider first element as pivot.
        This method return the index of lesser than pivot elements window last index.
         */
        int pivot=arr[start_index];
        int i=start_index-1;
        int j=end_index+1;
        while(true){
            do{
                i++;
            }while(arr[i]<pivot);
            do{
                j--;
            }while(arr[j]>pivot);
            if(i>=j) return j;
            swap(arr,i,j);
        }
    }
    public static void mergeSort(int[] arr,int start,int end){
        /* This method implement Merge Sort which takes O(n*logn) time complexity
        this is a stable algorithm but not inplace
        this method uses recursion and also calls merge function.
         */
        if(end>start){
            int mid=start+(end-start)/2;
            mergeSort(arr,start,mid);
            mergeSort(arr,mid+1,end);
            merge(arr,start,mid,end);

        }
    }
    public static void merge(int[] arr,int start, int mid, int end){
        /* in this method sort an array in which first array from index 0 to mid
        and second array is from index mid+1 to end.
        This method is used for Merge Sort.

         */
        int[] arr1=new int[mid-start+1];
        int[] arr2=new int[end-mid];
        for(int i=0;i<mid-start+1;i++) arr1[i]=arr[start+i];
        for(int j=0;j<end-mid;j++) arr2[j]=arr[j+mid+1];

        int index_arr1=0;
        int index_arr2=0;
        int index_arr=start;
        while(index_arr1<arr1.length && index_arr2<arr2.length){

            if(arr1[index_arr1]<=arr2[index_arr2]){
                arr[index_arr]=arr1[index_arr1];
                index_arr1++;

            }
            else{
                arr[index_arr]=arr2[index_arr2];
                index_arr2++;
            }
            index_arr++;

        }
        while(index_arr1<mid-start+1){
            arr[index_arr]=arr1[index_arr1];
            index_arr++;
            index_arr1++;

        }
        while(index_arr2<end-mid){
            arr[index_arr]=arr2[index_arr2];
            index_arr++;
            index_arr2++;
        }
    }
    public static ArrayList<Integer> merge1(int[] arr1, int[] arr2){
        // in this method we take two sorted arrays and we merge these two arrays in a sorted manner.
        int i=0;
        int j=0;
        ArrayList<Integer> al=new ArrayList<>();
        while(i<arr1.length || j<arr2.length){
            if(i>=arr1.length && j<arr2.length){
                al.add(arr2[j]);
                j++;
                continue;
            }
            else if(i<arr1.length && j>=arr2.length){
                al.add(arr1[i]);
                i++;
                continue;
            }
            
            else if(arr1[i]<=arr2[j]){
                al.add(arr1[i]);
                i++;
            }
            else if(arr1[i]>arr2[j]){
                al.add(arr2[j]);
                j++;
            }
        }
        return al;


    }
    public static void bubbleSort(int[] arr){
        //time complexity is O(n*n)
        // stable and inplace
        for(int i=1;i<arr.length;i++){
            boolean isSwapped=false;
            for(int j=0;j<arr.length-i;j++){
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    isSwapped=true;

                }
            }
            if(!isSwapped) break;
        }
    }

    public static void selectionSort(int[] arr){
        // time complexity is O(n*n)
        // in place and not stable
        // used when we need less no. of memory writes.
        for(int i=0;i<arr.length-1;i++){
            int min_index=i;
            for(int j=i;j<arr.length;j++){
                if(arr[j]<arr[min_index]){
                    min_index=j;

                }
            }
            swap(arr,i,min_index);
        }
    }

    public static int insertionSort(int[] arr){
        // the best time complexity is O(n) when array is already sorted
        // the worst time complexity is O(n*n) when array is reversely sorted
        // generally used when array is of small size.
        int countSwap=0;
        for(int i=1;i<arr.length;i++){
            int temp=arr[i];

            int left=i-1;
            while(left>=0 && arr[left]>temp){
                arr[left+1]=arr[left];
                countSwap++;
                left--;
            }
            arr[left+1]=temp;


        }
        return countSwap;
    }
    public static void swap(int[] arr,int a,int b){
        int temp=arr[a]^arr[b];
        arr[a]=temp^arr[a];
        arr[b]=temp^arr[b];
    }
}
