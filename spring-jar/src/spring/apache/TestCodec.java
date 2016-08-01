package spring.apache;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 使用commons-codec包加密字符串(MD5,SHA1,BASE64)
 * @author gp
 */
public class TestCodec {

	
	public static void main(String[] args) {
		
		//1.MD5
		String str = "abc";
		System.out.println(DigestUtils.md5Hex(str));
	
		//2.SHA1
		System.out.println(DigestUtils.shaHex(str));
		
		
		//可逆算法
		//常规加密解密算法：BASE64
		//加密
		String strA= "abc"; // abc为要加密的字符串
		byte[] b1 = Base64.encodeBase64(strA.getBytes(), true);
		System.out.println(new String(b1));

		//解密 
		String strB = "YWJj"; // YWJj为要解密的字符串
		byte[] b2 = Base64.decodeBase64(strB.getBytes());
		System.out.println(new String(b2));
		
	}
	
	
	
	
	
}
