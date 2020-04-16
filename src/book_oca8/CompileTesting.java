package book_oca8;


public class CompileTesting {
    public static void main(String[] args) {
        // float value = 102.0; <- does not compile. Either cast or add an f
        float value = 102.0f;
        float value1 = 102;
        float value2 = (int)102;
//        float value3 = 1f * 0.0;
        float value4 = 1f * (short)0.0;
//        float value5 = 1f * (boolean)0;

        int x = 0;
        while(++x < 5) { x+=1; }
        String message = x > 5 ? "Greater than" : "Less than";
        System.out.println(message+","+x);

    }
}
