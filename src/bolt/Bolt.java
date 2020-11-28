package bolt;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
 
public class Bolt {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Bolt(){
      prepareGUI();
   }
   float i = 0;
   public static void main(String[] args){
  System.out.println("Loading...");
      Bolt  swingControlDemo = new Bolt();      
      swingControlDemo.showTextAreaDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Bolts holes V0.1");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   JTextArea commentTextArea;
   private void showTextAreaDemo(){
      headerLabel.setText("GCode generator"); 
      JLabel  commentlabel= new JLabel("Comments: ", JLabel.RIGHT);
      commentTextArea = 
         new JTextArea("GCODE GEN", 5, 20);

      JScrollPane scrollPane = new JScrollPane(commentTextArea);    
      JButton showButton = new JButton("Add Bolt");
      statusLabel.setText("Bolts = " + Math.abs((i - 1)) + ".");    
      showButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 
        	 {//GCODE GEN
        		 String out = "";
        		 float b = i;
        				float a = 0;
        				float c = 0;
        				while(a <= b) {
               			 out += "G00 X" + c;
                 		     out += "\nM00\n"; 
        				if(360 / b >= 360) {
        					c = 0;
        				} else {
        				   c += 360 / b;
        				}
        				a++;
        				}
        				commentTextArea.setForeground(Color.GREEN);
        				commentTextArea.setBackground(Color.BLACK);
        		 commentTextArea.setText(out);
        	 }
        	 
        	 i++;
            statusLabel.setText("Bolts = " + Math.abs((i - 1)) + ".");        
         }
      }); 
      controlPanel.add(commentlabel);
      controlPanel.add(scrollPane);        
      controlPanel.add(showButton);
      mainFrame.setVisible(true);  
   }

	}
