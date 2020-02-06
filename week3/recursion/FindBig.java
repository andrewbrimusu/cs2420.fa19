public class FindBig {
    
    public static int findBig(int[] s, int low,int high){
        System.out.println("low: " + low + ", high: " + high);
        if (low == high) return s[low];
        int mid = (low+high)/2;
        int leftBig = findBig(s,low,mid);
        int rightBig = findBig(s,mid+1,high);
        if (leftBig>rightBig)
            return leftBig;
        return rightBig;
    }
    
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5, 9, 2, 6, 10, 100, 1000};
        System.out.println("Big: " + findBig(nums,0,7));
    }

}
