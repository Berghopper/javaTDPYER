public class Ex7Ifs2 {
    public static void main(String[] args) {
        double x  = 2;
        double y = 8;
        // a.If x times y is 8, then set x to 1; otherwise, set x to 2.
        if ((x*y) == 8) {
            x = 1;
        } else {
            x = 2;
        }
        // b.If x is less than y, then double the value of x; otherwise, increment x by 1.
        if (x < y) {
            x = x*2;
        } else {
            x++;
        }
        // c. If x is greater than y, then increment both by 1; otherwise, decrement both by 1.
        if (x > y) {
            x++;
            y++;
        } else {
            x--;
            y--;
        }
    }
}
