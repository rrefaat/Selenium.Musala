package data;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadData {
	
	public static Properties userdata = readData (System.getProperty("user.dir")+"\\src\\main\\java\\properties\\userdata.properties"); 
	
	public static Properties readData(String path) {
		
		Properties prop = new Properties();
		try {			
			FileInputStream input = new FileInputStream(path);
			prop.load(input);
			
		} catch (Exception e) {
		System.out.println("Exception Occurs: "+ e.getMessage());
		}
		return prop;
	}

}
