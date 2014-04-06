import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BMI extends JFrame{
	
	JTextField Name1 = new JTextField(12);
	JTextField Age1 = new JTextField(5);
	JTextField Height1 = new JTextField(12);
	JTextField Weight1 = new JTextField(12);
	JButton BMI1 = new JButton("go!!!!!");
	JTextField Result1 = new JTextField(50);
	
	public BMI(){	
	JPanel p1 = new JPanel(new GridLayout(5, 6));		
	p1.add(new JLabel("姓名"));
	p1.add(Name1);
	p1.add(new JLabel("年齡"));
	p1.add(Age1);
	p1.add(new JLabel("身高"));
	p1.add(Height1);
	p1.add(new JLabel("體重"));
	p1.add(Weight1);
	p1.add(new JLabel("  "));
	p1.add(BMI1);
	JPanel p2 = new JPanel(new GridLayout(2,1 ));
	p2.add(new JLabel("結果"));
	p2.add(Result1);
	
	add(p1, BorderLayout.CENTER);
	add(p2, BorderLayout.NORTH);
		
	BMI1.addActionListener(new Act());
	}
		
	
	class Act implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			
		}
	}

	public static void main(String[] args){
		JFrame frame = new BMI();
		frame.setTitle("BMI");
		frame.setSize(500, 450);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}