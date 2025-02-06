import java.util.*;

abstract class Persons {
    protected String name;
    protected int age;

    Persons(String name, int age) {
        this.name = name;
        this.age = age;
    }

    abstract void display();
}

class Students extends Persons {

    protected int sID;

    Students(String name, int age, int sID) {
        super(name, age);
        this.sID = sID;

    }

    void display() {
        System.out.println("Student: " + name + ", Age: " + age + ", ID: " + sID);
    }

}

class DivB1 extends Students {
    protected String batch;

    DivB1(String name, int age, int sID, String batch) {
        super(name, age, sID);
        this.batch = batch;
    }

    void display() {
        super.display();
        System.out.println("Batch of student is: " + batch);
    }

}

class QuickLearners extends DivB1 {
    private final double gpa;

    QuickLearners(String name, int age, int sID, String batch, double gpa) {
        super(name, age, sID, batch);
        this.gpa = gpa;

    }

    void display() {
        super.display();
        System.out.println("gpa: " + gpa);
    }

    double getGpa() {
        return gpa;
    }

}

public class Assign2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int ch;
        int SearchId;
        boolean found = false;
        System.out.println("\nEnter the total number of records:");
        int record = sc.nextInt();
        QuickLearners[] ss = new QuickLearners[record];
        do {
            System.out.print(
                    "1.INSERT\n2.DISPLAY\n3.SEARCH\n4.UPDATE\n5.SORT-GPA\n6.REMOVE\n7.AVG OF GPA\n8.EXIT\nEnter your choice: ");
            ch = sc.nextInt();

            switch (ch) {

                case 1:
                    for (int i = 0; i < record; i++) {
                        System.out.println("Enter record for student: " + (i + 1));
                        System.out.print("Enter name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter sid: ");
                        int sID = sc.nextInt();
                        System.out.print("Enter batch: ");
                        sc.nextLine();
                        String batch = sc.nextLine();
                        System.out.print("Enter gpa: ");
                        double gpa = sc.nextDouble();

                        ss[i] = new QuickLearners(name, age, sID, batch, gpa);
                    }

                    break;

                case 2:
                    System.out.println("display");
                    for (int i = 0; i < record; i++) {
                        ss[i].display();
                    }
                    break;

                case 3:
                    System.out.println("Enter student id to search: ");
                    SearchId = sc.nextInt();
                    found = false;
                    for (int i = 0; i < record; i++) {
                        if (ss[i].sID == SearchId) {
                            System.out.println("found: ");
                            ss[i].display();
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("not found!");
                    }
                    break;

                case 4:
                    System.out.println("Enter student id to search: ");
                    SearchId = sc.nextInt();
                    found = false;
                    for (int i = 0; i < record; i++) {
                        if (ss[i].sID == SearchId) {
                            System.out.println("found: ");
                            System.out.print("Enter name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.print("Enter age: ");
                            int age = sc.nextInt();
                            System.out.print("Enter sid: ");
                            int sID = sc.nextInt();
                            System.out.print("Enter batch: ");
                            sc.nextLine();
                            String batch = sc.nextLine();
                            System.out.print("Enter gpa: ");
                            double gpa = sc.nextDouble();

                            ss[i] = new QuickLearners(name, age, sID, batch, gpa);

                            found = true;

                        }
                    }
                    if (!found) {
                        System.out.println("not found!");
                    }
                    break;

                case 5:
                    System.out.println("Students sorted by GPA in descending order.");
                    for (int i = 0; i < record - 1; i++) {
                        for (int j = 0; j < record - i - 1; j++) {
                            if (ss[j].getGpa() < ss[j + 1].getGpa()) {

                                QuickLearners temp = ss[j];
                                ss[j] = ss[j + 1];
                                ss[j + 1] = temp;
                            }
                        }

                    }
                    for (int i = 0; i < record; i++) {
                        System.out.println(ss[i].getGpa());
                    }

                    break;

                case 6:
                    System.out.println("Enter student id to search: ");
                    SearchId = sc.nextInt();
                    found = false;
                    for (int i = 0; i < record; i++) {
                        if (ss[i].sID == SearchId) {
                            System.out.println("found & removed ");
                            ss[i] = null;

                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("not found!");
                    }
                    break;

                case 7:
                    double totalGpa = 0;
                    for (int i = 0; i < record; i++) {
                        totalGpa += ss[i].getGpa();
                    }
                    System.out.println("Average GPA: " + (totalGpa / record));
                    break;

                case 8:
                    System.out.println("Exiting from the code!!!!!");
                    break;

                default:
                    System.out.println("Invalid case!");

            }

        } while (ch != 8);

    }

}
