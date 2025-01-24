import java.io.*;

class Xyz {

    void get(String n, String p, int r) {
        if (r <= 0) {
            System.out.println("Roll number must not be negative!");

        } else {

            System.out.println("\n\nInformation of Student: \nName: " + n + "\nRoll: " + r + "\nPRN: " + p);
        }
    }

}

class Student {
    public static void main(String[] args) throws IOException {
        // System.out.println("hello");
        Xyz xx = new Xyz();

        System.out.println("Enter name: ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String n = in.readLine();

        System.out.println("Enter Prn: ");
        BufferedReader bin = new BufferedReader(new InputStreamReader(System.in));
        String p = bin.readLine();

        System.out.println("Enter Roll: ");
        BufferedReader bin1 = new BufferedReader(new InputStreamReader(System.in));
        int r = Integer.parseInt(bin1.readLine());

        xx.get(n, p, r);

    }
}