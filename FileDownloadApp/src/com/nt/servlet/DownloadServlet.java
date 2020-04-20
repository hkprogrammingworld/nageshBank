package com.nt.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;





@WebServlet("/downloadurl")
public class DownloadServlet extends HttpServlet {


	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("DownloadServlet.doGet()");
		
		File file=null;
		String fname=null;
		String mimeType=null;
		InputStream is=null;
		OutputStream os=null;
		ServletContext sc=null;
		
		//create outputStream pointing to response object
		os=res.getOutputStream();
		
		//read file name to be downloaded as additional req param value from hyperlinks
		fname=req.getParameter("filename");
		
		//create file object locating and holding the file to be downloaded
		file=new File("E:/store/"+fname);
		
		//get the length of the file and make it as response content length
		res.setContentLengthLong(file.length());
		
		//get servlet context object
		sc=getServletContext();
		
		//get mime type of the file and meke it response MIME type
		mimeType=sc.getMimeType("E:/store/"+fname);
		res.setContentType(mimeType!=null?mimeType:"application/octet-stream");
		
		//create inputStream pointing to the file to be downloaded
		is=new FileInputStream(file);
		
		//create output stream pointing to output stream
		os=res.getOutputStream();
		
		//set value to content-disposition response header
		res.setHeader("content-disposition","attechment;fileName="+fname);
		
		//copy the file content to response object
		IOUtils.copy(is,os);
		
		is.close();
		os.close();
	}
	
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			System.out.println("DownloadServlet.doPost()");
			
			doGet(request, response);
		}
	
	}
		

