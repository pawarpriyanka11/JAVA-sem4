import java.util.*;

interface Accept {
    String CONST1 = "Enter value: ";

    void getInput();
}

interface Display {
    String CONST2 = "Result is: ";

    void displayResult();
}

interface Converter1 extends Accept, Display {
    double CONST3 = 9.0;
    double CONST4 = 5.0;
    double KM_TO_MILES = 0.621371;
    double KG_TO_POUNDS = 2.20462;
    double MINUTES_TO_HOURS = 1.0 / 60.0;

    void convert1();

    void convert2();

    void convert3();

    void convert4();
}

class Calculate1 implements Converter1 {
    Scanner sc = new Scanner(System.in);
    int in;
    double res;

    public void getInput() {
        System.out.println(CONST1);
        in = sc.nextInt();
    }

    public void convert1() {
        res = (in * CONST3 / CONST4) + 32;
    }

    public void convert2() {
        res = CONST4 / CONST3 * (in - 32);
    }

    public void convert3() {
        res = in * KM_TO_MILES;
    }

    public void convert4() {
        res = in / KM_TO_MILES;
    }

    public void convert5() {
        res = in * KG_TO_POUNDS;
    }

    public void convert6() {
        res = in / KG_TO_POUNDS;
    }

    public void convert7() {
        res = in * MINUTES_TO_HOURS;
    }

    public void convert8() {
        res = in / MINUTES_TO_HOURS;
    }

    public void displayResult() {
        System.out.println(CONST2 + res);
    }
}

public class UnitConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            System.out.println(
                    "1.Celcius to Farenhite\n2. Fahrenheit to Celsius\n3. Kilometers to Miles\n4. Miles to Kilometers\n5. Kilograms to Pounds\n6. Pounds to Kilograms\n7. Minutes to Hours\n8. Hours to Minutes\n9. Exit");
            System.out.print("\nEnter your choice: ");
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
                    cc.getInput();
                    cc.convert3();
                    cc.displayResult();
                    break;
                case 4:
                    cc.getInput();
                    cc.convert4();
                    cc.displayResult();
                    break;
                case 5:
                    cc.getInput();
                    cc.convert5();
                    cc.displayResult();
                    break;
                case 6:
                    cc.getInput();
                    cc.convert6();
                    cc.displayResult();
                    break;
                case 7:
                    cc.getInput();
                    cc.convert7();
                    cc.displayResult();
                    break;
                case 8:
                    cc.getInput();
                    cc.convert8();
                    cc.displayResult();
                    break;
                case 9:
                    System.out.println("Exiting the converter...");
                    break;

                default:
                    System.out.println("Invalid case!");
            }
        } while (ch != 9);
    }
}
