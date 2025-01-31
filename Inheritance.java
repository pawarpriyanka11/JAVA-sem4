import java.util.*;


 class Animal
{
   
   Animal()
   {
     System.out.println("Constructor of Grandparent!");
   }
   
   void makeSound(String ss)
   {
     System.out.println("The animal makes sound: "+ss);
   }
   
   
   
}

 class Cat extends Animal
{
  Cat()
  { 
   System.out.println("Constructor of Parent!");
  }
  void makeSound(String ss)
   {
   System.out.println("The cat makes sound: "+ss);
   }
   
  
  
}

 class Dog extends Animal
{
  Dog()
  {
   System.out.println("Constructor of child!");
  }
  void makeSound(String ss)
   {
     System.out.println("The animal makes sound: "+ss);
   }
   
  
  
}

public class Inheritance{
    public static void main(String[] args)
    {
      
      String sound;
      
      Scanner sc=new Scanner(System.in);
      
      System.out.print("\n\nEnter the sound of ANIMAL:");
      sound=sc.nextLine();  
      Animal an=new Animal();
      an.makeSound(sound);
      
      
      System.out.print("\n\nEnter the sound of CAT:");
      sound=sc.nextLine();      
      Cat c=new Cat();
      c.makeSound(sound);
      
      
      System.out.print("\n\nEnter the sound of DOG:");
      sound=sc.nextLine(); 
      Dog d=new Dog();
      d.makeSound(sound);
      
      
       
       
             
    }
}

