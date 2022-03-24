package yihuan;
import java.awt.*; 
import java.awt.event.*; 
import javax.swing.*; 
import javax.swing.table.JTableHeader;
import java.sql.*;  
public class login extends JFrame implements ActionListener{ 	
    JLabel labname = new JLabel("用户名"); 	
    JLabel labpwd =new JLabel("密码"); 	
    JTextField textname = new JTextField(20); 	
    JPasswordField textpwd = new JPasswordField(20); 	
    JButton btnlogin = new JButton("登录"); 	
    JButton btnexit = new JButton("取消"); 	
    JPanel pan1 = new JPanel(); 	
    JPanel pan2 = new JPanel(); 	
    JPanel pan3 = new JPanel(); 	
    JPanel pan4 = new JPanel(); 	
    JPanel pan5 = new JPanel(); 	
    connect yihuan = new connect(); 	
    login(){ 		
        this.setTitle("欢迎使用该系统"); 		
        this.setBounds(600,600, 300, 200); 		
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 		
        init(); 		
        this.setVisible(true); 	
    } 	
    public void init() { 		
        pan1.setBorder(BorderFactory.createTitledBorder("登录")); 		
        pan1.setLayout(new GridLayout (2,1)); 		
        pan2.add(labname); 		
        pan2.add(textname); 		
        pan3.add(labpwd); 		
        pan3.add(textpwd); 		
        pan1.add(pan2); 		
        pan1.add(pan3); 		
        pan4.add(btnlogin); 		
        pan4.add(btnexit); 		
        pan5.add(pan1); 		
        this.add(pan5,"Center");		 		
        this.add(pan4,"South"); 		
        textname.addActionListener(this); 		
        textpwd.addActionListener(this); 		
        btnlogin.addActionListener(this); 		
        btnexit.addActionListener(this); 		
        textname.requestFocus(); 	
    } 	
    public void actionPerformed(ActionEvent ae) { 		
        if(ae.getSource() == btnexit) { 			
            System.exit(0); 		
        } 		 		
        else if(ae.getSource() == btnlogin) { 			
            String str = "select * from 登录  where 用户名 = '"+textname.getText()+"'and 密码 = '"+new String(textpwd.getPassword())+"'"; 			
            try { 				
                ResultSet rs = yihuan.chaxun(str); 				
                if(rs.next()) { 					
                    JOptionPane.showMessageDialog(this, "成功","信息",JOptionPane.INFORMATION_MESSAGE); 					
                    new zhuyemian(); 					
                    this.dispose(); 				
                } 				 				
                else { 					
                    JOptionPane.showMessageDialog(this, "失败","用户名或密码不正确",JOptionPane.INFORMATION_MESSAGE); 					
                    textname.requestFocus(); 					
                    textname.setText(null); 					
                    textpwd.setText(null); 				
                } 			
            } 			
            catch(SQLException e) { 				
                e.printStackTrace(); 			
            } 		
        } 	
    } 	
    public static void main(String[] args){ 		
        new login();	
    } 	 
}
