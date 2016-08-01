package spring.apache;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import spring.apache.bean.User;

/**
 * 1.对象克隆
 * 2.对象 -> map
 * 3.map ->对象
 * */
public class TestBeanUtils {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
		
		     /**克隆对象-----------------------------*/
			 User u = new User();
		     u.setName("tom");
		     u.setAge("20");
		     u.setPass("123");
		     
		     User user =  (User)BeanUtils.cloneBean(u);  //克隆bean 
		     //System.out.println(user.getName()+">>"+user.getAge());  
		
		     
		     
		  
		     /**将map转换为对象----------------------*/
		     Map map = new HashMap();  
		     map.put("name","丽丽");  
		     map.put("email","lili@163.com");  
		     map.put("age","21");  
		     
		     User user2 = new User();  
		     BeanUtils.populate(user2,map);       //populate填充
		     
		     //System.out.println("user2:"+user2.getName()+" "+user.getAge());  
		     
		     
		     
		     
		     /**将对象转换为Map----------------------*/
		     Map map2 = BeanUtils.describe(user2); //describe描述
		     
		     System.out.println("map:"+map2.get("name")+" "+map2.get("age"));  
		     
		    
		     
	}
	
	
}
