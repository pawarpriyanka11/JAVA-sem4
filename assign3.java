import java.util.*;

interface Accept {
    public void getInput();
}

interface Display {
    public void displayResult(); // Changed protected to public
}

interface Converter1 extends Accept, Display {
    public void convert1();
    public void convert2();
}

class Calculate1 implements Accept, Display {
    Scanner sc = new Scanner(System.in);
    int in;
    double res;

    public void getInput() { // Changed to public
        System.out.println("Enter value:");
        in = sc.nextInt();
    }

    public void convert1() {
        double ff = (in * 9 / 5) + 32;
        res = ff;
    }

    public void convert2() {
        double cc = 5 / 9 * (in - 32);
        res = cc;
    }

    public void displayResult() {
        System.out.println("Result is: " + res);
    }
}

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println("1. Celsius to Fahrenheit\n2. Fahrenheit to Celsius\n3. Exit\nEnter your choice:");
            ch = sc.nextInt();

            Calculate1 cc = new Calculate1();

            switch (ch) {
                case 1:
                    cc.getInput();
                    cc.convert1();
                    cc.displayResult();
                    break;

                case 2:
                    cc.getInput();
                    cc.convert2();
                    cc.displayResult();
                    break;

                case 3:
                    System.out.println("Exiting from the code");
                    break;

                default:
                    System.out.println("Invalid case!");
            }
        } while (ch != 3);
    }
}
