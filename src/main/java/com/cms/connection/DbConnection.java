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
import com.cms.service.EmployeeService;

import java.sql.Date;

public class DbConnection {
	static DAO dao;
	static Connection con;
	public ArrayList<Employee> ae= new ArrayList<Employee>();
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
                int columnsNumber = rsmd.getColumnCount();
                while (resultSet.next()){
                	if(table.equals("menu_item"))
                	{
                		System.out.println("table printed");
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
	public void loginEmp(int name) {
		try {
			dao = new DAO();
			con = dao.getConnection();
			EmployeeService es= new EmployeeService();
			String sql = "select * from employee where user_id='"+name+"'";
			PreparedStatement statement = con.prepareStatement(sql);
			ResultSet r=statement.executeQuery();
			if(r.next())
			{
				
				ae.add(new Employee(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getString(6),r.getString(7),r.getFloat(8)));
				System.out.println(ae.get(0).getEmployeeId());
			}
			else {
				
			}
				
			}
			catch(Exception e) {
				System.out.println(e);
			}	
	}
	
	
	

}
