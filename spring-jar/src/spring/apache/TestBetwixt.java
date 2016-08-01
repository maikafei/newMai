package spring.apache;

import java.beans.IntrospectionException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
 

import org.apache.commons.betwixt.io.BeanReader;
import org.apache.commons.betwixt.io.BeanWriter;
import org.xml.sax.SAXException;

import spring.apache.bean.User;

import java.io.StringReader;
import org.apache.commons.betwixt.io.BeanReader; 

/**
 *  XML与Java对象之间相互转换。
 * @author gp
 */
public class TestBetwixt {
	
	/**对象转换xml*/
	public static void beanToXml() throws IOException, SAXException, IntrospectionException {
		
		/**对象转换xml-------------------------------*/
   	     User u = new User();
	     u.setName("tom");
	     u.setAge("20");
	     u.setPass("123");
	     
       StringWriter outputWriter = new StringWriter();  
       
       outputWriter.write("<?xml version=’1.0′ encoding=’UTF-8′ ?>\n");  
       BeanWriter beanWriter = new BeanWriter(outputWriter);  
       beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);  
       beanWriter.getBindingConfiguration().setMapIDs(false);  
       beanWriter.enablePrettyPrint();  
       beanWriter.write("user", u);  
       System.out.println(outputWriter.toString()); 
       
       outputWriter.close();  
	}
	
	
	/**xml转换对象*/
	public static void xmlToBean() throws IOException, SAXException, IntrospectionException{
		
		/**解析xml为对象--------------------------------*/
        StringReader xmlReader = new StringReader("<?xml version='1.0' encoding='UTF-8' ?><user><name>Tom</name><age>25</age><pass>123</pass></user>");  
        
        
        //创建一个BeanReader实例，相当于转换器
        BeanReader beanReader = new BeanReader();
        //配置BeanReader实例
        beanReader.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanReader.getBindingConfiguration().setMapIDs(false); //不自动生成ID
        //注册要转换对象的类，并指定根节点名称
        beanReader.registerBeanClass("user", User.class);
        //将XML解析Java Object
        User user = (User) beanReader.parse(xmlReader);
        //在控制台输出对象
        System.out.println(user); 
        
	}
	
	/**对象转换xml保存到文件*/
	public static void beanToXmlFile() throws IOException, SAXException, IntrospectionException{
		
		//创建一个输出流，将用来输出Java转换的XML文件
        FileWriter outputWriter = new FileWriter("d:\\tttttttttt.txt");

        //输出XML的文件头
        outputWriter.write("<?xml version='1.0' ?>");

        //创建一个BeanWriter实例，并将BeanWriter的输出重定向到指定的输出流
        BeanWriter beanWriter = new BeanWriter(outputWriter);

        //配置BeanWriter对象
        beanWriter.getXMLIntrospector().getConfiguration().setAttributesForPrimitives(false);
        beanWriter.getBindingConfiguration().setMapIDs(false);
        beanWriter.enablePrettyPrint();

        User user = new User();
             user.setName("tom");
             user.setAge("20");
             user.setPass("123");
        beanWriter.write(user);

        //关闭输出流
        outputWriter.close(); 
	}
	
	
    public static void main(String[] args) throws IOException, SAXException, IntrospectionException {
		
    	//beanToXml();
	    
    	xmlToBean();
    	
    	//beanToXmlFile();
	}
    
    
    
    
    
}
