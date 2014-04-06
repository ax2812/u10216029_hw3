import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class BMI extends JFrame{
	//new出該有的東西
	JTextField Name1 = new JTextField(12);
	JTextField Age1 = new JTextField(5);
	JTextField Height1 = new JTextField(12);
	JTextField Weight1 = new JTextField(12);
	JButton BMI1 = new JButton("go!!!!!");
	JTextField Result1 = new JTextField(50);
	
	public BMI(){	
	JPanel p1 = new JPanel(new GridLayout(5, 6));	//設定版面格是	
	p1.add(new JLabel("姓名")); //將JLabel JTextField 丟進去
	p1.add(Name1);
	p1.add(new JLabel("年齡"));
	p1.add(Age1);
	p1.add(new JLabel("身高"));
	p1.add(Height1);
	p1.add(new JLabel("體重"));
	p1.add(Weight1);
	p1.add(new JLabel("  "));
	p1.add(BMI1);
	
	JPanel p2 = new JPanel(new GridLayout(2,1 )); // 2個地區
	p2.add(new JLabel("結果"));//用出輸出攔
	p2.add(Result1);
	
	add(p1, BorderLayout.CENTER); // 放置
	add(p2, BorderLayout.NORTH);
		
	BMI1.addActionListener(new Act()); //按鈕動作
	}
		
	
	class Act implements ActionListener{ //按鈕動作
		@Override
		public void actionPerformed(ActionEvent e){
			String a1 = Name1.getText();   // 獲得輸入值
			int b1 =  Integer.parseInt(Height1.getText());
			double c1 = Double.parseDouble(Weight1.getText());
			double d1 = Double.parseDouble(Height1.getText());			
			MathBMI result = new MathBMI(a1, b1, c1, d1);			 //丟到  MathBMI
			double bmi = result.getBMI();			//將getBMI()的數值拿出來
			Result1.setText(String.format("你的  BMI : %.2f 還有你  " + result.getStatus(bmi) ,bmi )); //險是結果
		}
	}
	public static void main(String[] args){
		JFrame frame = new BMI(); // new出來
		frame.setTitle("BMI"); //標題
		frame.setSize(500, 450);//大小
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}


class MathBMI{ //將課本的class 拉出來
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
		
		if(bmi < 18.5) // 改中文
			return "你....營養不良嗎?";
		else if (bmi<25)
			return "你太剛剛好了";
		else if (bmi < 30)
			return "超重超重 快去跑跑吧你!!!";
		else
			return "啥?";
	  }  
	}