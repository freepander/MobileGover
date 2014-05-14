package com.myivcre.ga.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Test extends HttpServlet
{
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("textml;charset=UTF-8"); 
			PrintWriter out = response.getWriter();
		  
			FileItemFactory factory = new DiskFileItemFactory();     
			ServletFileUpload upload = new ServletFileUpload(factory);    
			List<FileItem> items = upload.parseRequest(request);
			
			String uploadPath = "d:\\upload\\";
		
			File file = new File(uploadPath);
			if (!file.exists())
			{
				file.mkdir();
			}
			String filename = "";    
			InputStream is = null;    
			for (FileItem item : items)
			{
				if (item.isFormField())
				{
					if (item.getFieldName().equals("filename"))
					{  
						if (!item.getString().equals(""))
							filename = item.getString("UTF-8");
					}
				}
				else if (item.getName() != null && !item.getName().equals(""))
				{   
					filename = item.getName().substring(
							item.getName().lastIndexOf("\\") + 1);
					is = item.getInputStream();    
				}
			}
			filename = uploadPath + filename;
			if (new File(filename).exists())
			{
				new File(filename).delete();
			}
			if (!filename.equals(""))
			{ 
				FileOutputStream fos = new FileOutputStream(filename);
				byte[] buffer = new byte[8192];  
				int count = 0;
				while ((count = is.read(buffer)) > 0)
				{
					fos.write(buffer, 0, count); 
				}
				fos.close();    
				is.close();     
				out.println(" jaja");
			}
		}
		catch (Exception e)
		{

		}
	}
}

