package com.cms.service;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.cms.App;
import com.cms.connection.DbConnection;
import com.cms.model.Employee;
import com.cms.model.Menu_Item;
import com.cms.model.Vendor;

public class EmployeeService {
	

	 public DbConnection db = new DbConnection();
	 HashMap<String, String> conditions=new HashMap<String, String>();   
	 public boolean loginEmp(int name, String pass, String role)
	 {
		 Employee e= new Employee();
		 
//		 String selection = "";
//		 String[] fields= {"item_name","item_price"};
//		 HashMap<String, String> conditions=new HashMap<String, String>();   
	        
         db.loginEmp(name);
         if(db.ae.get(0).getEmployeeId()==name)  
         {
        	 if(db.ae.get(0).getEmployeePassword().equals(pass))
        	 {
        		 if(db.ae.get(0).getRole().equals(role))
        		 {
        			 return true;
        		 }
        		 else
        		 {
        			 e.setR(true);
        			 return false;
        		 }
        	 }
        	 else
        	 {
        		 e.setPass(true);
        		 return false;
        	 }
         }
         else
         {
        	 return false;
         }
                
     }
	 public boolean loginVen(int name, String pass)
	 {
//		 Vendor v= new Vendor();
//		 DbConnection db = new DbConnection();
//		 String selection = "";
//		 String[] fields= {"item_name","item_price"};
//		 HashMap<String, String> conditions=new HashMap<String, String>();   
//	     db.loginVen(name);
//         if(e.getEmployeeId()==name)  
//         {
//        	 if(e.getEmployeePassword().equals(pass))
//        	 {
//        		 if(e.getRole().equals(role))
//        		 {
//        			 return true;
//        		 }
//        		 else
//        		 {
//        			 e.setR(true);
//        			 return false;
//        		 }
//        	 }
//        	 else
//        	 {
//        		 e.setPass(true);
//        		 return false;
//        	 }
//         }
//         else
//         {
       	 return false;
//         }
//                
    }
	 
	public String addBalance(float amount)
	{
		
		HashMap<String, String> conditions=new HashMap<String, String>();   
		HashMap<String, String> data=new HashMap<String, String>();   
		if(amount<0)
		{
			return "Amount can not be negetive";
		}
		else if(amount>1000)
		{
			return "Amount can not be more than $1000";
		}
		else
		{
			float a=(db.ae.get(0).getBalance())+(amount);
			data.put("user_balance", Float.toString(a));
			conditions.put("user_id",Integer.toString(db.ae.get(0).getEmployeeId()));
			boolean update=db.update("employee", data, conditions);
			if(update)
			return "Balance added";
			else
				return "Not addedd";
		}
	}
	
	public void showMenu() {
		String[] fields= {"item_id","item_name","item_price","item_image","Vendor_id"};
		
		db.select("menu_item",fields,conditions);
	}
	public void addToCart(int item, int id) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    	LocalDate localDate = LocalDate.now();
    	Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        
		for(Menu_Item m:db.mi)
  		{
  			
  				if(m.getN()==item) 
  				{
  					String[] field= {"Order_id","item_id","user_id","quantity","date","time","token","Vendor_id","Tprice","Status","Msg"};
              		String[] values= {"101",Integer.toString(m.getItemId()),Integer.toString(id),"1",dtf.format(localDate),
              							sdf.format(cal.getTime()),"13",Integer.toString(m.getVendorId()),Float.toString(m.getItemPrice()),
              							"0",""};
              		db.insert("cms.order", field, values);
  				}
  			
  		}
	}
	public void viewCart(int id)
	{
		String sql="Select Order_id, mi.item_name, quantity, date, Tprice, v.Vendor_Name, Status "
				+ "from cms.order o, menu_item mi, vendor v where o.item_id=mi.item_id and o.Vendor_id=v.Vendor_id and Status='0'";
		 db.select_query(sql);
	}
}
