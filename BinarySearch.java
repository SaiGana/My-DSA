public class BinarySearch {
    public static void main(String[] args) {
        int[] nums={3,1,4,4,2};






    }
    
    public static int hIndex(int[] citations) {
        int n=citations.length;
        if(citations[0]>=n) return n;
        else if(citations[n-1]<n) return 0;

        int start=0;
        int end=n-1;
        int hvalue=0;
        while(start<=end){
            int mid=(start+end)/2;
            System.out.println(mid+"-");
            if(citations[mid]>=(n-mid)) {
                hvalue=Math.max(hvalue,n-mid);
                end=mid-1;
            }
            else if(citations[mid]<(n-mid)){
                start=mid+1;
            }

        }
        return hvalue;
    }

    public static int kRotation(int[] nums){
        if(nums[0]<nums[nums.length-1]) return 0;
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(end+start)/2;
            if(mid-1>=0 && nums[mid]<nums[mid-1]){
                return mid;
            }
            else if(mid-1>=0 && nums[mid]>nums[mid-1]){
                if(nums[mid]>nums[0]) start=mid+1;
                else end=mid-1;
            }
            else if(mid-1<0){
                start=mid+1;
            }
        }
        return -1;
    }
    public static int searchInRotatedArray(int[] nums,int target){
        if(nums.length==1){
            if(nums[0]==target) return 0;
            else return -1;
        }
        int k=kRotation(nums);
        int start=0+k;
        int end=nums.length-1+k;
        while(start<=end){
            int mid=(start+end)/2;
            int mid2=mid%nums.length;
            if(nums[mid2]==target) return mid2;
            else if(nums[mid2]>target) end=mid-1;
            else start=mid+1;
        }
        return -1;
    }
    public static boolean isPerfectSquare(int num) {
        int start=0;
        int end=46340;
        while(start<=end){
            int mid=start+(end-start)/2;
            //System.out.print(mid+" "+start+" "+end);
            //System.out.println();
            int mid2=mid*mid;
            if(mid2<num){
                start=mid+1;
            }
            else if(mid2>num){
                end=mid-1;
            }
            else{
                return true;
            }
        }
        return false;
    }

    public static int mySqrt(int x) {
        int start=0;
        int end=46340;

        while(start<end){
            int mid=(end+start)/2;
            System.out.print(start+" "+end+" "+mid+" ");
            if(mid*mid>x) {
                end=mid-1;
                if((mid-1)*(mid-1)<=x) return mid-1;
            }
            else if(mid*mid<x) {
                start=mid+1;
                if((mid+1)*(mid+1)>x) return mid;
                else if((mid+1)*(mid+1)==x) return mid+1;
            }
            else return mid;
            System.out.println();

        }
        return start;



    }
    public static int binary_Search(int[] arr,int value){
        // This method does binary search of a value for a sorted array.
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==value) return mid;
            else if(arr[mid]>value) right=mid-1;
            else if(arr[mid]<value) left =mid+1;
        }
        return -1;
    }
    public static int recursiveBinarySearch(int[] arr,int value,int right,int left){
        if(left>right) return -1;
        int mid=(left+right)/2;
        if(arr[mid]==value) return mid;
        else if(arr[mid]>value) right=mid-1;
        else if(arr[mid]<value) left=mid+1;
        return recursiveBinarySearch(arr,value,right,left);

    }
}
