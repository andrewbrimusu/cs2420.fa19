public class DrawPattern {
    public static void pattern(int center)
    {
        if (center <=0) return;
        pattern(center-1);
        pattern(center-1);
        System.out.print(center + " ");
    }
    
    public static void main(String[] args) {
        pattern(4);
    }
}

