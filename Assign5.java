import java.util.*;

class InvalidAgeException extends Exception {
    InvalidAgeException(String s) {
        super(s);
    }
}

class UserDefineException1 {
    static void validate(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age is not valid for voting.");
        } else {
            System.out.println("Welcome to vote!");
        }
    }
}

class InbuiltException1 {
    static Scanner sca = new Scanner(System.in);

    static void check() throws ArithmeticException {
        System.out.println("Inside check function!");
        System.out.print("Enter the value of a: ");
        int a = sca.nextInt();
        System.out.print("Enter the value of b: ");
        int b = sca.nextInt();

        if (b == 0) {
            throw new ArithmeticException("Denominator should not be 0");
        } else {
            int res = a / b;
            System.out.println("Result = " + res);
        }
    }
}

public class ExceptionHandling1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("\nEnter your choice:");
            System.out.println("1. UserDefinedException");
            System.out.println("2. InbuiltException");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    try {
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        UserDefineException1.validate(age);
                    } catch (InvalidAgeException e) {
                        System.out.println("Exception occurred: " + e.getMessage());
                    } finally {
                        System.out.println("Execution completed!");
                    }
                    break;

                case 2:
                    try {
                        InbuiltException1.check();
                    } catch (ArithmeticException e) {
                        System.out.println("Caught: " + e);
                    } finally {
                        System.out.println("Execution completed!");
                    }
                    break;

                case 3:
                    System.out.println("Exiting the program!");
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        } while (ch != 3);

    }
}
