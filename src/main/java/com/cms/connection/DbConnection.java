package com.cms.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.cms.model.Employee;
import com.cms.model.Menu_Item;
import com.cms.model.Order;
import com.cms.service.EmployeeService;

import java.sql.Date;

public class DbConnection {
	static DAO dao;
	static Connection con;
	public ArrayList<Employee> ae= new ArrayList<Employee>();
	public ArrayList<Menu_Item> mi= new ArrayList<Menu_Item>();
	public ArrayList<Order> ot= new ArrayList<Order>();
	public void select(String table, String[] fields, HashMap<String, String> condition){

        dao = new DAO();
        con = dao.getConnection();
        String sql = "SELECT ";
        for (String field : fields) {
            sql = sql+field+",";
        }
        sql = sql.substring(0, sql.length()-1);
        sql = sql+" FROM "+ table;
        if (condition.size()>0){
            sql = sql+" WHERE ";
            for (Map.Entry<String, String> entry: condition.entrySet())
                sql = sql + entry.getKey()+ " = '"+ entry.getValue()+"' AND ";
            sql = sql.substring(0, sql.length()-4);
        }
        try{
        	
            if (!con.isClosed() || con!=null){
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int c=1;
                int columnsNumber = rsmd.getColumnCount();
                while (resultSet.next()){
                	if(table.equals("menu_item"))
                	{   
                		
                		mi.add(new Menu_Item(c,resultSet.getInt(1), resultSet.getString(2), resultSet.getFloat(3), resultSet.getString(4), resultSet.getInt(5)));
                		
                		c++;
                		 
                	}
                	else if(table.equals("cms.order"))
                	{
                		ot.add(new Order(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getInt(4), resultSet.getDate(5), resultSet.getTime(6),
                				resultSet.getInt(7), resultSet.getInt(8), resultSet.getFloat(9), resultSet.getInt(10),resultSet.getString(11)));
                		for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) System.out.print(",  ");
                            String columnValue = resultSet.getString(i);
                            System.out.print(rsmd.getColumnName(i) + "-->" +columnValue );
                        }
                        System.out.println("");
                	}
                	else
                	{
                		 for (int i = 1; i <= columnsNumber; i++) {
                             if (i > 1) System.out.print(",  ");
                             String columnValue = resultSet.getString(i);
                             System.out.print(rsmd.getColumnName(i) + "-->" +columnValue );
                         }
                         System.out.println("");
                	}
                   
                }
                con.close();
            }else{
                //return empty
            }
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public boolean delete(String table,String field, String value){
        dao = new DAO();
        con = dao.getConnection();
        boolean status = false;
        String sql = "DELETE from "+ table + "WHERE "+field+"="+value;
        try {
            if (!con.isClosed() || con != null) {
                PreparedStatement preparedStmt = con.prepareStatement(sql);
                int delete = preparedStmt.executeUpdate();
                if (delete != 0)
                    status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public boolean insert(String table,String[] fields, String[] values){
        dao = new DAO();
        con = dao.getConnection();
        boolean status = false;
        String sql = "INSERT INTO "+table+" (";
        for (String field : fields) {
            sql = sql+field+",";
        }
        System.out.println(sql);
        sql = sql.substring(0, sql.length()-1);
        System.out.println(sql);
        sql = sql+") VALUES (";
        System.out.println(sql);
        for (String value : values) {
            sql = sql+"'"+value+"',";
        }
        sql = sql.substring(0, sql.length()-1);
        sql = sql+")";
        System.out.println(sql);

        try {
            if (!con.isClosed() || con != null) {
                PreparedStatement preparedStmt = con.prepareStatement(sql);
                int count = preparedStmt.executeUpdate();
                if (count > 0)
                    status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }


    public boolean update(String table,HashMap<String, String> data, HashMap<String, String> condition){
        dao = new DAO();
        con = dao.getConnection();
        boolean status = false;
        String sql = "UPDATE "+table+" SET ";
        for (Map.Entry<String, String> entry: data.entrySet())
            sql = sql + entry.getKey()+ " = '"+ entry.getValue()+"', ";
        sql = sql.substring(0, sql.length()-2);
        //System.out.println(sql);

        if (condition.size()>0){
            sql = sql+" WHERE ";
            for (Map.Entry<String, String> entry: condition.entrySet())
                sql = sql + entry.getKey()+ " = '"+ entry.getValue()+"' AND ";
            sql = sql.substring(0, sql.length()-4);
        }
        //System.out.println("Condition: " +sql);
        try {
            if (!con.isClosed() || con != null) {
                PreparedStatement preparedStmt = con.prepareStatement(sql);
                int count = preparedStmt.executeUpdate();
                //System.out.println("update count -->"+count);
                if (count > 0)
                    status = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }

    public void select_query(String sql){

        dao = new DAO();
        con = dao.getConnection();

        try{
            if (!con.isClosed() || con!=null){
                PreparedStatement statement = con.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery();
                ResultSetMetaData rsmd = resultSet.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                while (resultSet.next()){
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        System.out.print(rsmd.getColumnName(i) + "-->" +columnValue );
                    }
                    System.out.println("");
                }
                con.close();
            }else{
                //return empty
            }
        }catch(Exception e) {
            System.out.println(e);
        }

    }
	public boolean loginEmp(String m_username,String  m_password) {
		try {
			dao = new DAO();
			con = dao.getConnection();
			EmployeeService es= new EmployeeService();
			String sql = "select * from employee where User_id='"+m_username+"' and User_password='"+m_password+"'";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet r=statement.executeQuery();
			
				if(r.next()) {
					if(r.getString("User_password").equals(m_password)) {
						return true;
					}
				}
				else
				{
					return false;
				}
				return false;
			}
		catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
	}

