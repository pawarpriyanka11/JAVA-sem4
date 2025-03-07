public class Inuilt1{
    public static void main(String[] args) {
        try {
            int result = 10 / 0; 
        } catch (ArithmeticException e) {
            System.out.println("Caught an inbuilt exception: " + e);
        }
        finally
        {
          System.out.println("reset values to 0");
          result=0;
        }
    }
}

