package utilities;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
	File src=new File("./Configuration files/Config.properties");
	
	try {
		 FileInputStream fis=new FileInputStream(src);
	     pro =new Properties();
	     pro.load(fis);
	}catch (Exception e) {
		System.out.println("Exception is" + e.getMessage());
		}}
	
	public String getChromePath()
	{
	String chromepath=pro.getProperty("chromepath");
	return chromepath;
	}
	
	
	public String getFirefoxPath()
	{
	String firefoxpath=pro.getProperty("firefoxpath");
	return firefoxpath;
	}

	public String getIEPath()
	{
	String iepath=pro.getProperty("iepath");
	return iepath;
	}

	
	public String getApplicationURL()
	{
		String baseurl=pro.getProperty("complete_url");
		return baseurl;
		
	}
	
	public String getEmail1()
	{
		String email=pro.getProperty("email");
		return email;
		
	}
	
	public String getUserName()
	{
		String username=pro.getProperty("First_name");
		return username;
	}
	
	public String getLastName()
	{
		String Lastname=pro.getProperty("Last_name");
		return Lastname;
	}
	
	public String getEmail()
	{
		String email=pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	
	}
	
	
	public String getDate() {
	    String date = pro.getProperty("date");
	    return date;
	}


	public String getMonth() {
	    String months = pro.getProperty("month");
	    return months;
	}

	public String getYear() {
	    String years = pro.getProperty("date");
	    return years;
	}
		
	}		
		