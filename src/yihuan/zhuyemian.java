package yihuan;  
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.table.JTableHeader; 
import java.sql.*;  
public class zhuyemian extends JFrame implements ActionListener{ 	
    JLabel name = new JLabel("请输入患者姓名："); 	
    JLabel  sex= new JLabel("请输入性别："); 	
    JTextField text1 = new JTextField(10); 	
    JTextField text2 = new JTextField(10); 	
    JButton btn1 = new JButton("查询"); 	
    JButton btn2 = new JButton("模糊查询"); 	
    JButton btn3 = new JButton("添加"); 	
    JButton btn4 = new JButton("修改"); 	
    JButton btn5 = new JButton("删除"); 	
    JPanel pan1 = new JPanel(); 	
    JPanel pan2 = new JPanel(); 	
    JPanel pan3 = new JPanel(); 	
    JTable table = new JTable(); 	
    JScrollPane jsp =new JScrollPane(table); 	
    base tf; 	
    String sql;
    connect yihuan = new connect(); 	
    public void init() { 		
        pan1.add(name); 		
        pan1.add(text1); 		
        pan1.add(btn1); 		
        pan2.add(sex); 		
        pan2.add(text2); 		
        pan2.add(btn2); 		
        this.add(pan1,"North"); 		
        pan2.setLayout(new BorderLayout()); 		
        tf = new base(); 		
        table.setModel(tf); 		
        pan2.add(jsp,"Center"); 		
        this.add(pan2,"Center"); 		
        btn1.addActionListener(this); 		
        btn2.addActionListener(this); 		
        pan3.add(btn3); 		
        pan3.add(btn4); 		
        pan3.add(btn5); 		
        this.add(pan3,"South"); 		
        btn3.addActionListener(this); 		
        btn4.addActionListener(this); 		
        btn5.addActionListener(this); 	
    } 	
    zhuyemian(){ 		
        this.setTitle("医患信息管理系统"); 		
        this.setBounds(600,600,600,300); 		
        init(); 		
        this.setVisible(true);		 	
    } 	
    public void actionPerformed(ActionEvent ae) { 		
        String s; 		
        if(ae.getSource() == btn1) { 			
            s = text1.getText().trim(); 			
            if(s.equals("")) { 				
                tf = new base(); 				
                table.setModel(tf); 			
            } 			
            else { 				
                sql = "select * from patient where 姓名 ='"+s+"'"; 				
                tf = new base(sql); 				
                table.setModel(tf); 			
            } 		
        } 		
        if(ae.getSource() == btn2) { 			
            s = text2.getText().trim(); 			
            if(s.equals("")) { 				
                tf = new base(); 				
                table.setModel(tf); 			
            } 			
            else { 				
                sql = "select * from patient where 性别 like'"+s+"'"; 				
                tf = new base(sql); 				
                table.setModel(tf); 			
            } 		
        } 		
        if(ae.getSource() == btn3) { 
            new zengjia(); 			
            this.dispose(); 			
        } 		
        if(ae.getSource() == btn4) { 			
            int i = table.getSelectedRow(); 			
            if(i == -1) { 				
                JOptionPane.showMessageDialog(this, "没有选中的记录"); 			
            } 			
            else { 				
                String t1 = (String)table.getValueAt(i, 0); 				
                String t2 = (String)table.getValueAt(i, 1); 				
                String t3 = (String)table.getValueAt(i, 2); 				
                String t4 = (String)table.getValueAt(i, 3); 				
                String t5 = (String)table.getValueAt(i, 4); 				
                String t6 = (String)table.getValueAt(i, 5); 				
                String t7 = (String)table.getValueAt(i, 6); 				
                String t8 = (String)table.getValueAt(i, 7); 				
                new xiugai(t1,t2,t3,t4,t5,t6,t7,t8);
            } 		
        } 		
        if(ae.getSource() == btn5) { 			
            int i = table.getSelectedRow(); 			
            if(i == -1) { 				
                JOptionPane.showMessageDialog(this, "没有选中删除的记录"); 			
            } 			
            else { 				
                int n = JOptionPane.showConfirmDialog(this, "确定要删除么","是否要删除选中记录",JOptionPane.YES_NO_OPTION); 				
                if(n == JOptionPane.YES_OPTION) { 					
                    String t1 = (String)table.getValueAt(i, 0); 					
                    yihuan.shanchu(t1);
                    tf = new base(); 				
                    table.setModel(tf); 					
                     				
                } 			
            } 		
        } 	
    } 
}