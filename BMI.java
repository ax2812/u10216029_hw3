import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BMI extends JFrame{
	//new�X�Ӧ����F��
	JTextField Name1 = new JTextField(12);
	JTextField Age1 = new JTextField(5);
	JTextField Height1 = new JTextField(12);
	JTextField Weight1 = new JTextField(12);
	JButton BMI1 = new JButton("go!!!!!");
	JTextField Result1 = new JTextField(50);
	
	public BMI(){	
	JPanel p1 = new JPanel(new GridLayout(5, 6));	//�]�w������O	
	p1.add(new JLabel("�m�W")); //�NJLabel JTextField ��i�h
	p1.add(Name1);
	p1.add(new JLabel("�~��"));
	p1.add(Age1);
	p1.add(new JLabel("����"));
	p1.add(Height1);
	p1.add(new JLabel("�魫"));
	p1.add(Weight1);
	p1.add(new JLabel("  "));
	p1.add(BMI1);
	
	JPanel p2 = new JPanel(new GridLayout(2,1 )); // 2�Ӧa��
	p2.add(new JLabel("���G"));//�ΥX��X�d
	p2.add(Result1);
	
	add(p1, BorderLayout.CENTER); // ��m
	add(p2, BorderLayout.NORTH);
		
	BMI1.addActionListener(new Act()); //���s�ʧ@
	}
		
	
	class Act implements ActionListener{ //���s�ʧ@
		@Override
		public void actionPerformed(ActionEvent e){
			String a1 = Name1.getText();   // ��o��J��
			int b1 =  Integer.parseInt(Height1.getText());
			double c1 = Double.parseDouble(Weight1.getText());
			double d1 = Double.parseDouble(Height1.getText());			
			MathBMI result = new MathBMI(a1, b1, c1, d1);			 //���  MathBMI
			double bmi = result.getBMI();			//�NgetBMI()���ƭȮ��X��
			Result1.setText(String.format("�A��  BMI : %.2f �٦��A  " + result.getStatus(bmi) ,bmi )); //�I�O���G
		}
	}
	public static void main(String[] args){
		JFrame frame = new BMI(); // new�X��
		frame.setTitle("BMI"); //���D
		frame.setSize(500, 450);//�j�p
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}


class MathBMI{ //�N�ҥ���class �ԥX��
	  private String name;
	  private int age;
	  private double weight;
	  private double height;
	  public static final double KILOGRAMS_PER_POUND = 0.45359237;
	  public static final double METERS_PER_INCH = 0.0254;
	  
	  public MathBMI(String name , int age , double weight, double height){
		this.name = name;
		this.age  = age;
		this.weight = weight;
		this.height = height;
	  } 
	  public MathBMI(String name , double weight , double height){
		this(name , 20 , weight , height);  
	  }
	  public double getBMI(){
		double bmi = weight * KILOGRAMS_PER_POUND / ((height * METERS_PER_INCH) * (height * METERS_PER_INCH));
		return Math.round(bmi * 100)/100.0;
	  }
	  public String getStatus(double bmi){
		
		if(bmi < 18.5) // �襤��
			return "�A....��i���}��?";
		else if (bmi<25)
			return "�A�ӭ��n�F";
		else if (bmi < 30)
			return "�W���W�� �֥h�]�]�a�A!!!";
		else
			return "ԣ?";
	  }  
	}