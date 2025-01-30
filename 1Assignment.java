import java.io.*;
import java.util.Scanner;

class StudentDetails {

    private String name, prn, clas;
    private int roll;
    private String no;
    private Scanner sc = new Scanner(System.in);

    void get(String n, String p, int r, String c, String phone) {
        name = n;
        prn = p;
        roll = r;
        clas = c;
        no = phone;
    }

    void CalculateMarks() {
        System.out.print("\nEnter the total number of Subjects: ");
        int cnt = sc.nextInt();
        int[] arr = new int[cnt];
        int total = 0;
        int max = 50;

        for (int i = 0; i < cnt; i++) {
            System.out.println("Enter subject marks:" + (i + 1) + "from 0-" + max + ": ");
            arr[i] = sc.nextInt();

            // validate
            while (arr[i] < 0 || arr[i] > max) {
                System.out.println("INVALID MARKD!...Enter subject marks:" + (i + 1) + "from 0-" + max + ": ");
                arr[i] = sc.nextInt();
            }

            total += arr[i];
        }
        double per = (total * 100.0) / (cnt * max);

        System.out.print("Grade: ");
        if (per >= 80) {
            System.out.println("O");
        } else if (per >= 60) {
            System.out.println("A");
        } else if (per >= 40) {
            System.out.println("B");
        } else {
            System.out.println("Failed");
        }

    }

    void display() {
        System.out.println("\n\nInformation of Student: \nName: " + name + "\nRoll: " + roll + "\nPRN: " + prn
                + "\nClass: " + clas + "\nphone number: " + no);
    }
}

class Student {

    public static void main(String[] args) throws IOException {

        int ch, r;
        String n, p, c, phone;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of students in class:");
        int count = sc.nextInt();
        StudentDetails[] xx = new StudentDetails[count];

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        do {

            System.out.print("\n1. ACCEPT\n2. DISPLAY \n3. CALCULATE GRADE\n4.EXIT\nEnter your choice: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("ACCEPT DETAILS: ");

                    for (int i = 0; i < count; i++) {
                        xx[i] = new StudentDetails();
                        System.out.print("\n\nAccept for student " + (i + 1));

                        System.out.print("\nEnter name: ");
                        n = in.readLine();

                        System.out.print("Enter Prn: ");
                        p = in.readLine();

                        System.out.print("Enter Roll: ");
                        r = Integer.parseInt(in.readLine());
                        if (r <= 0) {
                            System.err.print("Invalid roll number!");
                            break;

                        }

                        System.out.print("Enter Class: ");
                        c = in.readLine();

                        System.out.print("Enter phone_no: ");
                        phone = in.readLine();
                        if (phone.length() > 10) {
                            System.err.print("Invalid phone number!");
                            break;
                        }

                        xx[i].get(n, p, r, c, phone);

                    }
                    break;

                case 2:
                    for (int i = 0; i < count; i++) {
                        System.out.print("\n\ndisplay for student " + (i + 1));
                        xx[i].display();
                    }
                    break;

                case 3:

                    for (int i = 0; i < count; i++) {
                        System.out.print("\n\ncalculate for student " + (i + 1));
                        xx[i].CalculateMarks();

                    }
                    break;

                case 4:
                    System.out.println("Exiting from the code!");
                    return;

                default:
                    System.out.println("inavlid case!");
                    break;
            }
        } while (ch != 4);
    }

}
