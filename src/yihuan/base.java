package yihuan;  
import java.sql.*; 
import javax.swing.*; 
import java.util.*; 
import javax.swing.table.AbstractTableModel;   
public class base extends AbstractTableModel{ 	
    Vector<Object>ziduan,jilu; 	
    connect yihuan =new connect(); 	
    public int getRowCount(){ 
        return jilu.size(); 	
    } 	
    public int getColumnCount() { 		
        return ziduan.size(); 	
    } 	
    public Object getValueAt(int row,int col) { 		
        return((Vector<?>)jilu.get(row)).get(col); 	
    } 	
    public String getColumnName(int e){ 		
        return (String)ziduan.get(e); 	
    } 	
    public void bianjisql(String sql) { 		
        ziduan = new Vector<Object>(); 		
        ziduan.add("患者编号"); 		
        ziduan.add("姓名"); 		
        ziduan.add("性别"); 		
        ziduan.add("门诊类型"); 		
        ziduan.add("病症所属科室"); 		
        ziduan.add("入院时间"); 		
        ziduan.add("所在地"); 		
        ziduan.add("是否为新冠患者"); 		
        jilu =new Vector<Object>(); 		
        try { 			
            ResultSet result = yihuan.chaxun(sql); 			
            while(result.next()) { 				
                Vector<Object>hang =new Vector<Object>(); 				
                hang.add(result.getString(1)); 				
                hang.add(result.getString(2)); 				
                hang.add(result.getString(3)); 				
                hang.add(result.getString(4)); 				
                hang.add(result.getString(5)); 				
                hang.add(result.getString(6)); 				
                hang.add(result.getString(7)); 				
                hang.add(result.getString(8)); 				
                jilu.add(hang); 			
            } 		
        } 		
        catch (SQLException e) { 			
            e.printStackTrace(); 		
        } 	
    }  	
    public base() { 		
        bianjisql("select * from patient"); 	
    } 	
    public base(String s) { 		
        bianjisql(s); 	
    } 
} 
