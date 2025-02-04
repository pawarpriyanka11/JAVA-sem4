import java.util.*;
class Person {
  String name;
  int age;
  
  Person(String name,int age)
  {
  this.name=name;
  this.age=age;
     
  }
 /* Person(int age)
  {
    this.age=age;
  }*/
  void display()
  {
  System.out.println(age);
  }
}


class AllStudents extends Person {
int roll;
String clas;

 AllStudents(int roll,String clas)
 {
   this.roll=roll;
   this.clas=clas;
 
 }
   void display()
  {
  }
}


class DivB extends AllStudents{
 String co_ordinator;
 int classRoom;
 
 DivB(String co_ordinator,int classRoom)
 {
   this.co_ordinator=co_ordinator;
   this.classRoom=classRoom;
   
 }
   void display()
  {
  }
 
}







class QuickLearner extends DivB{
  int id;
  String level;
  
  	QuickLearner(int id,String level)
  	{
  	  this.id=id;
  	  this.level=level;
  	} 
  	  void display()
  {
  }
}







public class Sstudent {
   public static void main(String[] args)
   {
      //QuickLearner ql=new QuickLearner();
      Person pp=new Person("priyanka",19);
      //Person ppp=new Person(20);
   }
}
