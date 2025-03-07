
class AgeNotValidException extends Exception {
    public AgeNotValidException(String message) {
        super(message);  
    }
}

public class MyException{
    public static void checkAge(int age) throws AgeNotValidException {
        if (age < 0) {
            throw new AgeNotValidException("Age cannot be negative!");
        } else if (age < 18) {
            throw new AgeNotValidException("You must be at least 18 years old.");
        } else {
            System.out.println("Age is valid.");
        }
    }

    public static void main(String[] args) {
        try {
            checkAge(-5);  
        } catch (AgeNotValidException e) {
            System.out.println("Caught a user-defined exception: " + e.getMessage());
        }
    }
}

