import java.awt.*;
import java.applet.*;

/*
<applet code="MyApplet" width=400 height=200>
</applet>
*/

public class MyApplet extends Applet {
    public void paint(Graphics g) {
       
       
        //panel-IMG
        Panel panelI = new Panel();
        
        panelI.setLayout(new FlowLayout());
       
        Image img=new Image("abc.jpg");   
        panelI.add(img);
            
        add(panelI);
        
       
       
       //panel-1
        Panel panel1 = new Panel();
        
        panel1.setLayout(new FlowLayout());
        
        Label label1 = new Label("ID of Employee: ");
        TextField tf1 = new TextField(20);
   
        panel1.add(label1);
        panel1.add(tf1);
        
        add(panel1);
        
        
        
        //panel-2
        Panel panel2 = new Panel();
        
        panel2.setLayout(new FlowLayout());
        
        Label label2 = new Label("Name of Employee: ");
        TextField tf2 = new TextField(20);
   
        panel2.add(label2);
        panel2.add(tf2);
        
        add(panel2);
        
        
        //panel-3
        Panel panel3 = new Panel();
        
        panel3.setLayout(new FlowLayout());
        
        Label label3 = new Label("Salary of Employee: ");
        TextField tf3 = new TextField(20);
   
        panel3.add(label3);
        panel3.add(tf3);
        
        add(panel3);
        
        //panel-4
        Panel panel4 = new Panel();
        
        panel4.setLayout(new FlowLayout());
        
        Label label4 = new Label("Salary of Employee: ");
        TextField tf4 = new TextField(20);
   
        panel4.add(label4);
        panel4.add(tf4);
        
        add(panel4);
        
        
        //panel-5
        Panel panel5 = new Panel();
        
        panel5.setLayout(new FlowLayout());
        
        Button btn1 = new Button("INSERT");
        Button btn2 = new Button("UPDATE");
        Button btn3 = new Button("DELETE");
        Button btn4 = new Button("DISPLAY");
        Button btn5 = new Button("CALCULATE-SAL");
        
        panel5.add(btn1);
        panel5.add(btn2);
        panel5.add(btn3);
        panel5.add(btn4);
        panel5.add(btn5);
        
        add(panel5);
        
        
        
        
        
        
        
        
    }
}
