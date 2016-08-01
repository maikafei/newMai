package spring.apache;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


public class TestConfiguration {

	/*用来帮助处理配置文件的，支持很多种存储方式。
	1. Properties files
	2. XML documents
	3. Property list files (.plist)
	4. JNDI
	5. JDBC Datasource
	6. System properties
	7. Applet parameters
	8. Servlet parameters */
	  
 
	public static void main(String[] args) throws ConfigurationException {
		
		//Configuration config = new PropertiesConfiguration(""); 
		 
		/*String ip=config.getString("ip");  
		int port=config.getInt("port");  
		String title=config.getString("application.title");  */
		 
	    PropertiesConfiguration config = new PropertiesConfiguration("config.properties");  
	    //config.setProperty("colors.background", "#000000");  
	    //config.save();   
	    //config.save("config.backup.properties");//备份原文件
		
	    System.out.println(config.getString("db.username"));
	    
		
	}
	
	
	
}
