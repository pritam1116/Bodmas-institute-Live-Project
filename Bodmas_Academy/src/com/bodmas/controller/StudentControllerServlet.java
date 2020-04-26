package com.bodmas.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.DataSource;

import com.bodmas.dao.StudentDbUtil;
import com.bodmas.model.ContactUs;
import com.bodmas.model.Storage;
import com.bodmas.model.StudentRegister;


/*Author:Pritam */


/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/bodmas_app")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		//create our student db util ... and pass in the conn pool / datasource
		
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter 
			String theCommand =  request.getParameter("command");
			
			//if the command is missing, then default to fetch the data
			if(theCommand==null) {
				theCommand = "LIST";	
			}
			//route the appropriate method 
			switch (theCommand) {
			
			case "LIST":
				
				fetchingData(request,response);
				break;
			
			case "ADD":
				addStudent(request,response);
				break;
			
			case "FILES":
				System.out.println("Checking files");
				addStorage(request,response);
				break;
				
			case "CONTACT":
				addContact(request,response);
				break;

			default:
				fetchingData(request,response);
			}
			

		} catch (Exception e) {
			
			throw new ServletException(e);
		}
	}

	
	
	private void addContact(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String message = request.getParameter("message");
		
		
       
            ContactUs contact = new ContactUs(name, email, message);
            studentDbUtil.addContact(contact);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/home.jsp");
			dispatcher.forward(request, response);
		
		
	}
	
	

	private void fetchingData(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<Storage> theStorage = studentDbUtil.getStorage();
		request.setAttribute("STORAGE_LIST", theStorage);
		
		//send to the JSP page (view )
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-storage.jsp");
		dispatcher.forward(request, response);
		
	}

	private void addStorage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("Invoked add storage method");
		String details = request.getParameter("details");
		System.out.println("Invoked details data field "+details);

		InputStream inputStream = null;
		Part filePart = request.getPart("file");
		System.out.println("Checking");
        if (filePart != null) {
            // prints out some information for debugging
            System.out.println(filePart.getName());
            System.out.println(filePart.getSize());
            System.out.println(filePart.getContentType());
             
            // obtains input stream of the upload file
            inputStream = filePart.getInputStream();
            Storage storage = new Storage(details,inputStream);
            studentDbUtil.addStorage(storage);
            fetchingData(request, response);
			
        }
		
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//read the info from the data
				String firstName = request.getParameter("fname");
				String lastName = request.getParameter("lname");
				String userName = request.getParameter("uname");
				String password = request.getParameter("pwd");
				String c_password = request.getParameter("c_pwd");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String dob = request.getParameter("dob");
				Date date_of_birth = new SimpleDateFormat("dd-mmm-yyyy").parse(dob); 
				String gender = request.getParameter("gender");
				String address = request.getParameter("address");
				
				
				//create a new student object
				StudentRegister theStudent = new StudentRegister(firstName, lastName, userName, password, c_password,
						email,gender,date_of_birth,mobile,address);
				
				//add the student to the database
				studentDbUtil.addStudent(theStudent);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/html/index.html");
				dispatcher.forward(request, response);
				//send back to main page (the student list)
				//listStudents(request, response);
			}
		
	
		
	
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			
			//read the "command" parameter 
			String theCommand =  request.getParameter("command");
			
			//if the command is missing, then default to fetch the data
			if(theCommand==null) {
				theCommand = "LIST";	
			}
			//route the appropriate method 
			switch (theCommand) {
			
			case "LIST":
				
				fetchingData(request,response);
				break;
			
			case "ADD":
				addStudent(request,response);
				break;
			
			case "FILES":
				System.out.println("Checking files");
				addStorage(request,response);
				break;
				
			case "CONTACT":
				addContact(request,response);
				break;

			default:
				fetchingData(request,response);
			}
			

		} catch (Exception e) {
			
			throw new ServletException(e);
		}
	}

	
		
		
		
	}

