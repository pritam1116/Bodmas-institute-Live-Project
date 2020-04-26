/**
 * 
 */
package com.bodmas.dao;


import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.bodmas.model.ContactUs;
import com.bodmas.model.Storage;
import com.bodmas.model.StudentRegister;


/**
 * @author Pritam Sinha
 *
 */
public class StudentDbUtil {
	
	private DataSource dataSource;
	public StudentDbUtil(DataSource theDataSource) {

		dataSource = theDataSource;
		
	}
	public void addStudent(StudentRegister theStudent) throws Exception {

		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			conn=dataSource.getConnection();
			
			//create sql for insert
			String sql = "insert into bodmas_student "
						+" (first_name,last_name,user_name,psd,c_psd,email,dob,mobile,address,gender) "
						+ " values (?,?,?,?,?,?,?,?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			//set the param values for the student 
			stmt.setString(1, theStudent.getFirst_name());
			stmt.setString(2, theStudent.getLast_name());
			stmt.setString(3, theStudent.getUser_name());
			stmt.setString(4, theStudent.getPassword());
			stmt.setString(5, theStudent.getNew_password());
			stmt.setString(6, theStudent.getEmail());
			
			//Date theStudent.getDate_of_birth() = Calendar.getInstance().getTime(); 
			//change date to string
			DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
			String d = dateFormat.format(theStudent.getDate_of_birth());  
			stmt.setString(7,d);
			stmt.setString(8,theStudent.getMobile());
			stmt.setString(9,theStudent.getAddress());
			stmt.setString(10,theStudent.getGender());
			
			
			
			//execute sql  insert
			stmt.executeQuery();
			
		}
		finally {
		//clean up JDBC objects
		close(conn, stmt, rs);
			
		}
		
	}
	private void close(Connection conn, Statement stmt, ResultSet rs) {

			
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}
	public void addStorage(Storage storage) throws Exception {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			System.out.println("invoked add Storage service class");
			conn=dataSource.getConnection();
			
			//create sql for insert
			String sql = "insert into bodmas_storage "
						+" (details,files) "
						+ " values (?,?)";
			stmt = conn.prepareStatement(sql);
			
			//set the param values for the student 
			stmt.setString(1, storage.getDetails());
			stmt.setBlob(2, storage.getFiles());
			
			
			
			
			
			//execute sql  insert
			stmt.executeQuery();
			
		}
		finally {
		//clean up JDBC objects
		close(conn, stmt, rs);
			
		}
		
	}
	public List<Storage> getStorage() throws Exception {
		
		List<Storage> storages = new ArrayList<Storage>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
		//get a connection
		conn = dataSource.getConnection();
		
		//create SQL statement
		String sql = "select * from bodmas_storage order by id";
		stmt = conn.createStatement();
		
		//execute query
		rs = stmt.executeQuery(sql);
		
		//process result set
		while(rs.next()) {
			
			//retrieve data from result set row 
			int id = rs.getInt("id");
			System.out.println(id);
			String details = rs.getString("details");
			System.out.println(details);
			Blob files = rs.getBlob("files");
			System.out.println(files);
			if(files!=null) {
				InputStream inputStream = files.getBinaryStream();
				System.out.println(inputStream);
				
				
			/*  StringWriter writer = new StringWriter();
		        IOUtils.copy(inputStream, writer, StandardCharsets.UTF_8);
		        String s =  writer.toString(); */
				
				
				
				//creating an InputStreamReader object
			      //InputStreamReader isReader = new InputStreamReader(inputStream);
			      //Creating a BufferedReader object
			 /*     BufferedReader reader = new BufferedReader(isReader);
			      StringBuffer sb = new StringBuffer();
			      String str;
			      while((str = reader.readLine())!= null){
			         sb.append(str);
			      }
			      String s = sb.toString(); */
			      
			      
			   /*   
			      BufferedImage bImage = ImageIO.read(new File("sample.jpg"));
			      ByteArrayOutputStream bos = new ByteArrayOutputStream();
			      ImageIO.write((RenderedImage) files, "jpg", bos );
			      byte [] data = bos.toByteArray();
			      ByteArrayInputStream bis = new ByteArrayInputStream(data);
			      BufferedImage bImage2 = ImageIO.read(bis);
			      ImageIO.write(bImage2, "jpg", new File("output.jpg") );  */
				
				
				
			    /*  InputStream is = new BufferedInputStream(
			              new FileInputStream("files"));
			        BufferedImage  image = ImageIO.read(is);  */
				
			        
				
				
				Storage tempStorage = new Storage(id, details,inputStream);
				System.out.println(tempStorage);
				//add it to the list of students
				storages.add(tempStorage);

			}
			
			
		/*	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			 
			while ((bytesRead = inputStream.read(buffer)) != -1) {
			    outputStream.write(buffer, 0, bytesRead);
			}
			 
			byte[] imageBytes = outputStream.toByteArray();
			 
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			 
			inputStream.close();
			outputStream.close(); */
			
			
			

					

		}
		
			return storages;	
		}
		finally {
			
			//close JDBC objects
			close(conn,stmt,rs);
		}

		
	}
	public void addContact(ContactUs contact) throws Exception {
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			
			conn=dataSource.getConnection();
			
			//create sql for insert
			String sql = "insert into bodmas_contactus "
						+" (name,email,message) "
						+ " values (?,?,?)";
			stmt = conn.prepareStatement(sql);
			
			//set the param values for the student 
			stmt.setString(1, contact.getName());
			stmt.setString(2, contact.getEmail());
			stmt.setString(3, contact.getMessage());
			
			
			
			
			
			//execute sql  insert
			stmt.executeQuery();
			
		}
		finally {
		//clean up JDBC objects
		close(conn, stmt, rs);
			
		}
		
	}

}
