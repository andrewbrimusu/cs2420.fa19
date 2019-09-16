public class PrintListRecursively {
    public static void main(String[] args) {
        int[] pi = {3, 1, 4, 1, 5, 9, 2, 6};
        for (int p : pi)
            System.out.print(p);
        System.out.println("");
        print(pi,0);
    }
    
    public static void print(int[] list, int index) {
        if (index == list.length) return;
        System.out.print(list[index]);
        //
        print(list, index+1);
    }
    
}