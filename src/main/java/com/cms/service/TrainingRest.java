package com.cms.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.cms.connection.DbConnection;
import com.cms.model.DBStatus;
import com.cms.model.Employee;
import com.cms.model.Menu_Item;
@Path("cms")

public class TrainingRest {
	public DbConnection db = new DbConnection();
	 
	
	 
	 @GET
	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	 @Path("login/{username}/{password}") //http://localhost:8080/RMSJava/api/rms/login/sonal/Sonal@123
	 public DBStatus getMembers(@PathParam("username") String username, @PathParam("password") String password){
	 EmployeeService es = new EmployeeService();
	 return es.Login(username, password);
	 }
	 
//	 @GET
//	 @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
//	 @Path("loginV/{username}/{password}") //http://localhost:8080/RMSJava/api/rms/login/sonal/Sonal@123
//	 public DBStatus getMembersV(@PathParam("username") String username, @PathParam("password") String password){
//	 VendorService vs = new VendorService();
//	 return vs.Login(username, password);
//	 }

}
