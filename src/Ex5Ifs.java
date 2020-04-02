public class Ex5Ifs {
    public static void main(String[] args) {
        double x  = 25;
        double y = 5;
        // a.If x divided by y is 5, then set x to 100
        if ((x/y) == 5) x = 100;
        System.out.println(x);
        System.out.println(y);
        System.out.println("===");
        // b.If x times y is 5, then set x to 1.
        x = 2;
        y = 2.5;
        if ((x*y) == 5) x = 1;
        System.out.println(x);
        System.out.println(y);
        System.out.println("===");
        // c.If x is less than y, then double the value of x.
        x = 50;
        y = 100;
        if (x < y) x = x*2;
        System.out.println(x);
        System.out.println(y);
        System.out.println("===");
        // d.If x is greater than y, then increment the value of x by 1
        x = 100;
        y = 50;
        if (x > y) x++;
        System.out.println(x);
        System.out.println(y);
        System.out.println("===");
    }
}
