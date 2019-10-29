package com.cms;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Scanner;

import com.cms.connection.DbConnection;
import com.cms.model.Employee;
import com.cms.model.Menu_Item;
import com.cms.model.Order;
import com.cms.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        DbConnection db = new DbConnection();
//        EmployeeService ef = new EmployeeService();
//        Employee e = new Employee();
//        Scanner input=new Scanner(System.in);
//		String selection = "";
//		
//		HashMap<String, String> conditions=new HashMap<String, String>();   
//	        //while loop to display menu
//       while(!selection.equals("x"))
//       {
//           //show the menu
//    	   System.out.println();
//           System.out.println("Please make your selection");
//           System.out.println("1: Login as Employee");
//           System.out.println("2: Login as Vendor");
//           System.out.println("3: Login as Admin");
//           System.out.println("x: Finish the simulation");
//           
//           //get the input
//           System.out.println();
//           selection = input.next();
//           
//           if(selection.equals("1"))
//           {
//        	   System.out.println("Enter user Id");
//               int id=input.nextInt();
//               System.out.println("Enter user password");
//               String pass=input.next();
//           	   boolean login=ef.loginEmp(id,pass,"employee");
//               if(login) 
//               {
//            	   System.out.println("Hello "+ef.db.ae.get(0).getEmployeeName());
//            	   System.out.println("Welcome to Food Stop");
//            	   while(!selection.equals("x"))
//                   {
//                       //show the menu
//                       System.out.println();
//                       System.out.println("Please make your selection");
//                       System.out.println("1: Menu Item");
//                       System.out.println("2: Profile");
//                       System.out.println("3: Add Balance");
//                       System.out.println("4: Cart");
//                       System.out.println("5: Edit Order");
//                       System.out.println("6: Order History");
//                       System.out.println("x: LogOut");
//                       
//                       //get the input
//                       System.out.println();
//
//                       selection = input.next();
//                       
//                       if(selection.equals("1"))
//                       {
//                       		//call function from orderservice
//                          	System.out.println("Select item to add to cart");
//                          	ef.showMenu();
//                      		for(Menu_Item m:ef.db.mi)
//                      		{
//                      			System.out.println(m.getN()+": "+m.getItemName()+"  "+m.getItemPrice());
//                      		}
//                      		System.out.println("To select item enter item number");
//                      		int item=input.nextInt();
//                      		if(ef.addToCart(item,id,ef.db.ae.get(0).getBalance()))
//                      		{
//                      			System.out.println("Added to the cart");
//                      		}
//                      		else
//                      		{
//                      			System.out.println("Insufficient Balance");
//                      			;
//                      		}
//                      		
//                      		
//                       }
//                       else if(selection.equals("2"))
//                       {
//                    	    System.out.println("ID : "+ef.db.ae.get(0).getEmployeeId());
//                    		System.out.println("Name : "+ef.db.ae.get(0).getEmployeeName());
//                    		System.out.println("Email : "+ef.db.ae.get(0).getEmployeeEmail());
//                    		System.out.println("Contact : "+ef.db.ae.get(0).getEmployeeContact());
//                    		System.out.println("Image : "+ef.db.ae.get(0).getImage());
//                    		System.out.println("Balance : "+ef.db.ae.get(0).getBalance());
//                           ;
//                       }
//                       else if(selection.equals("3"))
//                       {
//                       	//call addbalance function in employeeservice
//                    	   System.out.println("Enter Amount");
//                    	   float amount=input.nextFloat();
//                    	   ef.addBalance(amount);
//                           
//                       }
//                       else if(selection.equals("4"))
//                       {
//                       	
//                           //call addtocart function in employeeservice
//                    	   ef.viewCart(id);
//                       }
//                       else if(selection.equals("5"))
//                       {
//                       	ef.showOrder(id);
//                       	System.out.println("Enter order number that you want to edit or delete or enter 0 to go back");
//                       	int order=input.nextInt();
//                       	for(Order o:ef.db.ot)
//                       	{
//                       		if(o.getOrderId()==order)
//                       		{
//                       			System.out.println("Order ID: "+o.getOrderId()+" Item: "+o.getItemId()+" quantity:"+o.getQuantity());
//                       			System.out.println("Make your selection for edit or delete");
//                               	while(!selection.equals("x"))
//                               	{
//                               		System.out.println("1: Edit");
//                                   	System.out.println("2: Delete");
//                                   	System.out.println("x: Go Back");
//                                   	selection=input.next();
//                                   	if(selection.equals("1"))
//                                   	{
//                                   		System.out.println("Enter quantity");
//                                   		int q=input.nextInt();
//                                   		if(ef.editOrder(order,q, o.getTotalPrice()))
//                                   		{
//                                   			System.out.println("Order Updated");
//                                   		}
//                                   		else
//                                   		{
//                                   			System.out.println("Failed to update order");
//                                   		}
//                                   	}
//                                   	else if(selection.equals("2"))
//                                   	{
//                                   		
//                                   	}
//                                   	else if(selection.equals("x"))
//                                   	{
//                                   		;
//                                   	}
//                               	}
//                       		}
//                       	}
//                       	
//                       	
//                           
//                       }
//                       else if(selection.equals("6"))
//                       {
//                       	//call showorder history from employeeservice
//                           
//                       }
//                       else if(selection.equals("x"))
//                       {
//                           //go out
//                           System.exit(0);
//                       }
//                   }
//               }
//               else if(e.isPass())
//               {
//               		System.out.print("Wrong Password Entered");
//               }
//               else if(e.isR())
//               {
//            	    System.out.print("No Employee with the id "+id+" found");
//               }
//               else
//               {
//            	   System.out.print("Wrong User Id Entered");
//               }
//               
//           }
////           else if(selection.equals("2"))
////           {
////        	   boolean login=ef.loginVen(id,pass);
////               if(login) 
////               {
////            	   while(!selection.equals("x"))
////                   {
////                       //show the menu
////                       System.out.println();
////                       System.out.println("Please make your selection");
////                       System.out.println("1: Menu Item");
////                       System.out.println("2: Profile");
////                       System.out.println("3: Add Balance");
////                       System.out.println("4: Cart");
////                       System.out.println("5: Edit Order");
////                       System.out.println("6: Order History");
////                       System.out.println("7: LogOut");
////                       System.out.println("x: Finish the simulation");
////                       
////                       //get the input
////                       selection = input.nextLine();
////                       System.out.println();
////                       
////                       if(selection.equals("1"))
////                       {
////                       	//call function from orderservice
////                       	//db.select("menu_item",fields,conditions);
////                       }
////                       else if(selection.equals("2"))
////                       {
////                           //call profile function in employee service
////                       	
////                           
////                       }
////                       else if(selection.equals("3"))
////                       {
////                       	//call addbalance function in employeeservice
////                           
////                       }
////                       else if(selection.equals("4"))
////                       {
////                       	
////                           //call addtocart function in employeeservice
////                       }
////                       else if(selection.equals("5"))
////                       {
////                       	//call editorder function from orderservice
////                           
////                       }
////                       else if(selection.equals("6"))
////                       {
////                       	//call showorder history from employeeservice
////                           
////                       }
////                       else if(selection.equals("7"))
////                       {
////                       	
////                           //call logout function
////                       }
////                       else if(selection.equals("x"))
////                       {
////                           //go out
////                           ;
////                       }
////                   }
////               }
////               else if(e.isPass())
////               {
////               		System.out.print("Wrong Password Entered");
////               }
////               else if(e.isR())
////               {
////            	    System.out.print("No Vendor with the id "+id+" found");
////               }
////               else
////               {
////            	   System.out.print("Wrong Vendor Id Entered");
////               }
////               
////               
////           }
//           else if(selection.equals("3"))
//           {
//        	   System.out.println("Enter user Id");
//               int id=input.nextInt();
//               System.out.println("Enter user password");
//               String pass=input.next();
//        	   boolean login=ef.loginEmp(id,pass,"admin");
//               if(login) 
//               {
//            	   while(!selection.equals("x"))
//                   {
//                       //show the menu
//                       System.out.println();
//                       System.out.println("Please make your selection");
//                       System.out.println("1: View Vendors Profile");
//                       System.out.println("2: Add Vendors");
//                       System.out.println("3: Delete Vendors");
//                       System.out.println("4: Edit Vendors");
//                       System.out.println("5: LogOut");
//                       System.out.println("x: Finish the simulation");
//                       
//                       //get the input
//                       selection = input.nextLine();
//                       System.out.println();
//                       
//                       if(selection.equals("1"))
//                       {
//                       	//call function from orderservice
//                       	//db.select("menu_item",fields,conditions);
//                       }
//                       else if(selection.equals("2"))
//                       {
//                           //call profile function in employee service
//                    	    System.out.println("ID : "+db.ae.get(0).getEmployeeId());
//	                   		System.out.println("Name : "+db.ae.get(0).getEmployeeName());
//	                   		System.out.println("Email : "+db.ae.get(0).getEmployeeEmail());
//	                   		System.out.println("Contact : "+db.ae.get(0).getEmployeeContact());
//	                   		System.out.println("Image : "+db.ae.get(0).getImage());
//	                   		System.out.println("Balance : "+db.ae.get(0).getBalance());
//                           
//                       }
//                       else if(selection.equals("3"))
//                       {
//                       	//call addbalance function in employeeservice
//                           
//                       }
//                       else if(selection.equals("4"))
//                       {
//                       	
//                           //call addtocart function in employeeservice
//                       }
//                       else if(selection.equals("5"))
//                       {
//                       	//call editorder function from orderservice
//                           
//                       }
//                       else if(selection.equals("x"))
//                       {
//                           //go out
//                           ;
//                       }
//                   }
//               }
//               else if(e.isPass())
//               {
//               		System.out.print("Wrong Password Entered");
//               }
//               else if(e.isR())
//               {
//            	    System.out.print("No Admin with the id "+id+" found");
//               }
//               else
//               {
//            	   System.out.print("Wrong User Id Entered");
//               }
//               
//           }
//           else if(selection.equals("x"))
//           {
//               //go out
//               System.exit(0);
//
//           }
//       }
   }
}
