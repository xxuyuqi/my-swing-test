package yihuan;  
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.table.JTableHeader; 
import java.sql.*; 
public class xiugai extends JFrame implements ActionListener {
    JLabel bianhao = new JLabel("患者编号：");
    JLabel name = new JLabel("姓名："); 	
    JLabel  sex= new JLabel("性别：");
    JLabel  mzlx= new JLabel("门诊类型：");
    JLabel  ks= new JLabel("病症所属科室：");
    JLabel  sj= new JLabel("入院时间：");
    JLabel  szd= new JLabel("所在地：");
    JLabel  xg= new JLabel("是否为新冠患者：");
    static String[] xb = {"男", "女"};
    DefaultComboBoxModel<String> comboModel = new DefaultComboBoxModel<String>(xb);
    JComboBox cmb = new JComboBox(comboModel);
    JTextField text1 = new JTextField(10); 	
    JTextField text2 = new JTextField(10);
    JTextField text3 = new JTextField(10); 
    JTextField text4 = new JTextField(10); 
    JTextField text5 = new JTextField(10); 
    JTextField text6 = new JTextField(10);
    JTextField text7 = new JTextField(10);  	
    JButton btn1 = new JButton("确定"); 	
    JButton btn2 = new JButton("取消"); 	
    connect yihuan = new connect();
    public void init(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8) {
        text1.setText(t1);
        text2.setText(t2);
        cmb.setSelectedItem(t3);		
        text3.setText(t4);
        text4.setText(t5);
        text5.setText(t6);
        text6.setText(t7);
        text7.setText(t8);
        this.add(bianhao);
        this.add(text1);
        this.add(name);
        this.add(text2);
        this.add(sex);
        this.add(cmb);
        this.add(mzlx);
        this.add(text3);
        this.add(ks);
        this.add(text4);
        this.add(sj);
        this.add(text5);
        this.add(szd);
        this.add(text6);
        this.add(xg);
        this.add(text7);
        this.add(btn1);
        this.add(btn2);
        this.setLayout(new GridLayout(9, 2, 10, 5));		
        btn1.addActionListener(this); 		
        btn2.addActionListener(this); 	
    }
    xiugai(String t1,String t2,String t3,String t4,String t5,String t6,String t7,String t8) { 		
        this.setTitle("修改患者信息"); 		
        this.setBounds(600,300,300,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
        init(t1,t2,t3,t4,t5,t6,t7,t8); 		
        this.setVisible(true);		 	
    } 	
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btn1) { 			
            this.dispose();
            new zhuyemian(); 		
        }
        if(ae.getSource() == btn2) { 			
            String t1 = text1.getText();
            String t2 = text2.getText();
            String t3 = (String)cmb.getSelectedItem();
            String t4 = text3.getText();
            String t5 = text4.getText();
            String t6 = text5.getText();
            String t7 = text6.getText();
            String t8 = text7.getText();
            yihuan.update(t1, t2, t3, t4, t5, t6, t7, t8);
            this.dispose();
            new zhuyemian();	
        }
    }
    // public static void main(String[] args){ 		
    //     new xiugai("1", "2","女","3","4","5","6","7");	
    // }
}
