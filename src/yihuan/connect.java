package yihuan;
import java.sql.*;
public class connect { 	
    private Connection con =null;
    private Statement state =null;
 	private PreparedStatement prepared =null;
 	ResultSet result = null;
 	String str;
 	int count = 0;
 	private void lianjie() {
    	try { 		
            Class.forName("com.hxtt.sql.access.AccessDriver");
     		System.out.println("已连接驱动"); 	
        }
     	catch(ClassNotFoundException e) {
     		System.out.println(e); 	
        }
        try { 
    		String url="jdbc:Access:///E://医患系统初稿.mdb";
     		con = (Connection) DriverManager.getConnection(url,"","007890");
        }
         catch (SQLException e) { 						
        e.printStackTrace(); 		}}
 	private void guanbilianjie() { 		
        try {
    		if(result != null) con.close(); 		}
        catch(SQLException e) {
 			e.printStackTrace();
 		}
     	}
    private void guanbijieguo() { 		
        try { 			
            if(result != null)  				
            result.close(); 		
        } 		
        catch(SQLException e) { 			
            e.printStackTrace(); 		
        } 	
    } 	
    private void guanbiprestat() { 		
        try { 			
            if(result != null)  				
            con.close(); 		
        } 		
        catch(SQLException e) { 			
            e.printStackTrace(); 		
        } 	
    } 	
    public int insert(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8) { 		
        try { 			
            lianjie(); 			
            str = "insert into patient (患者编号,姓名,性别,门诊类型,病症所属科室,入院时间,所在地,是否为新冠患者)values(?,?,?,?,?,?,?,?)"; 			
            prepared = con.prepareStatement(str); 			
            prepared.setString(1, s1); 			
            prepared.setString(2, s2); 			
            prepared.setString(3, s3); 			
            prepared.setString(4, s4); 			
            prepared.setString(5, s5); 			
            prepared.setString(6, s6); 			
            prepared.setString(7, s7); 			
            prepared.setString(8, s8); 			
            count = prepared.executeUpdate(); 		
        } 		
        catch(SQLException e) { 			
            e.printStackTrace(); 		
        } 		
        guanbiprestat(); 		
        guanbilianjie(); 		
        return count; 	
    } 	
    public int update(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8) { 		
        try { 			
            lianjie();
 			str = "update patient set 姓名=?,性别=?,门诊类型=?,病症所属科室=?,入院时间=?,所在地=?,是否为新冠患者=? where 患者编号=?"; 			
            prepared = con.prepareStatement(str); 			
            prepared.setString(1, s1); 			
            prepared.setString(2, s2); 			
            prepared.setString(3, s3); 			
            prepared.setString(4, s4); 			
            prepared.setString(5, s5); 			
            prepared.setString(6, s6); 			
            prepared.setString(7, s7); 			
            prepared.setString(8, s8); 			
            count = prepared.executeUpdate(); 		
        } 		
        catch(SQLException e) { 			
            e.printStackTrace(); 		
        } 		
        guanbiprestat(); 
        guanbilianjie(); 		
        return count; 	
    } 	
    public int shanchu(String s) { 		
        try { 			
            lianjie(); 			
            str = "delete from patient  where 患者编号 =?"; 			
            prepared = con.prepareStatement(str); 			
            prepared.setString(1, s); 			
            count = prepared.executeUpdate(); 		
        } 		
        catch(SQLException e) { 			
            e.printStackTrace(); 		
        } 		
        guanbiprestat(); 		
        guanbilianjie(); 		
        return count; 	
    } 	
    public ResultSet chaxun(String s) { 		
        try { 			
            lianjie(); 			
            prepared = con.prepareStatement(s); 			
            result = prepared.executeQuery(); 		
        } 		
        catch(SQLException e) { 			
            e.printStackTrace(); 		
        } 		
        return result; 	
    } 
}