import java.io.*;
import java.util.Scanner;

class StudentDetails {

String name,prn,clas;
int roll;
String no;
Scanner sc=new Scanner(System.in);

    void get(String n, String p, int r,String c,String phone) {
        name=n;
        prn=p;
        roll=r;
        clas=c;
        no=phone;
    }
    
    void CalculateMarks()
    {
      System.out.println("Enter the total number of Subjects: ");
      int cnt=sc.nextInt();
      int[] arr=new int[cnt];
       int total=0;
      System.out.println("Total subjects are: "+cnt);
       
       
       System.out.println("Enter marks in range of 0 to 50");
      
      for(int i=0;i<cnt;i++)
      {
      System.out.println("Enter subject marks:"+(i+1));
         arr[i]=sc.nextInt();
         total+=arr[i];
               }
      
      
      if(total<=100&&total>=80)
      {
      System.out.println("Grade O");
      }
      else if(total<80&&total>=60)
      {
         System.out.println("Grade A");
      }
      else if(total<60&&total>=40)
      {
       System.out.println("Grade B");
      }
      else
      {
       System.out.println("Failed");
      }
      
      
      
      
      
    }


   void display()
   {
    System.out.println("\n\nInformation of Student: \nName: " + name + "\nRoll: " + roll + "\nPRN: " + prn+"\nClass: "+clas+"\nphone number: "+no);
   }
}

class Student {
    public static void main(String[] args) throws IOException {
    
    
        Scanner sc=new Scanner(System.in);
        
       // StudentDetails xx = new StudentDetails();
        System.out.println("Enter the number of students in class:");
        int count=sc.nextInt();
        StudentDetails[count] xx = new StudentDetails();
        

        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter name: ");
        String n = in.readLine();

        System.out.print("Enter Prn: ");
        String p = in.readLine();

        System.out.print("Enter Roll: ");
        int r = Integer.parseInt(in.readLine());
        
        System.out.print("Enter Class: ");
        String c=in.readLine();
        
        
        System.out.print("Enter phone_no");
        String phone=in.readLine();
        
        
        
        
        int temp=phone.length();    
      if (r <= 0&&temp>10) {
            System.out.println("Roll number must not be negative!\nand phone number should not excced 10 digit!");

        } 

        else{
        xx.get(n, p, r,c,phone);
        xx.display();

        }
        
        xx.CalculateMarks();
   
   

     

    }
}
