package com.duomei.bases.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.duomei.bases.logger.DuomeiLogger;


public class StringUtil {
	static DuomeiLogger logger = DuomeiLogger.getLogger(StringUtil.class);
	public static final Pattern getURLPattern = Pattern.compile("(?<=://)[^/?:&%]+");
	
	public static final String BASE64_STR = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static final String BASE62_STR = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	/**
	 * 文件名称转换函数。去除空格、Tab、斜线、反斜线
	 * @param str 文件名称
	 * @return 转换后的文件名称
	 */
	public static String fileNameEncode(String str){
		str=str.replace(" ", "_");//replace space
		str=str.replace("	", "_");//replace tab
		str=str.replace("/", "_");//replace /
		str=str.replace("\\", "_");//replace \
		return str;
	}
	public static String xmlEncode(String str){
		str=str.replace("<", "stmzdyh");
		str=str.replace(">", "stmzxyh");
		return str;
	}

	public static Date replaceDateNull(Date date){
		if(date==null){
			return new Date();
		}else{
			return date;
		}
	}
	
	public static int replaceIntegerNull(Integer integer){
		if(integer==null){
			return 0;
		}else{
			return integer.intValue();
		}
	}
	
	public static String replaceStringNull(String str){
		if(str==null){
			return "";
		}else{
			return str;
		}
	}
	public static String replaceStringNull(String str,String fill){
		if(str==null){
			return fill;
		}else{
			return str;
		}
	}
	
	public static String tagRetrieve(String content) {
		content = content.replaceAll("&lt", "<");
		content = content.replaceAll("&gt", ">");
		return content;
	}

	public static String htmEncode(String s) {
		StringBuffer stringbuffer = new StringBuffer();
		int j = s.length();
		for (int i = 0; i < j; i++) {
			char c = s.charAt(i);
			switch (c) {
			case 60:
				stringbuffer.append("&lt;");
				break;
			case 62:
				stringbuffer.append("&gt;");
				break;
			case 38:
				stringbuffer.append("&amp;");
				break;
			case 34:
				stringbuffer.append("&quot;");
				break;
			case 169:
				stringbuffer.append("&copy;");
				break;
			case 174:
				stringbuffer.append("&reg;");
				break;
			case 165:
				stringbuffer.append("&yen;");
				break;
			case 8364:
				stringbuffer.append("&euro;");
				break;
			case 8482:
				stringbuffer.append("&#153;");
				break;
			/*
			 * case 13: if (i < j - 1 && s.charAt(i + 1) == 10) {
			 * stringbuffer.append("<br>"); i++; } break;
			 */
		/*	case 32:
				if (i < j - 1 && s.charAt(i + 1) == ' ') {
					stringbuffer.append(" &nbsp;");
					i++;
					break;
				}*/
			case 13:
				stringbuffer.append("<br>");
				break;
			case 32:
				stringbuffer.append("&nbsp;");
				break;
			default:
				stringbuffer.append(c);
				break;
			}
		}
		return new String(stringbuffer.toString());
	}
	
	public static String decimalInttoBase62(int input){
		String my62mediaId = "";
		int r = 0;
		char c = 0;
		int 	spotsPlanId2=input;
		if(spotsPlanId2==0){
			my62mediaId ="+";
		}else{
			while (spotsPlanId2 > 0) {
				r = spotsPlanId2 % 62;
				c = BASE62_STR.charAt(r);
				my62mediaId = c + my62mediaId;
				spotsPlanId2 = spotsPlanId2/ 62;
            }
        }
		return my62mediaId;
	}
	
	public static int base62toDecimalInt(String base62){
		char indexChar = 0;
		int index = 0;
		int power = 0;
		int total = 0;
				
		if (base62 != null){
			for (int i = 0; i < base62.length(); i++){
				indexChar = base62.charAt(i);
				index = BASE62_STR.indexOf(indexChar);
				power = base62.length() - i - 1;
				total += index*Math.pow(62, power);
			}
		}
		return total;
	}
	
	public static void main(String[] args){
		int i = 1234565678;
		String s = decimalInttoBase64(100902746);
		System.out.println(s);
		System.out.println(base62toDecimalInt(s));
		System.out.println(base62toDecimalInt("5wk"));
		System.out.println(base64toDecimalInt("3zDVA"));
	}
	
	public static String base62toDecimalStr(String base62){
		char indexChar = 0;
		int index = 0;
		int power = 0;
		int total = 0;
				
		if (base62 != null){
			for (int i = 0; i < base62.length(); i++){
				indexChar = base62.charAt(i);
				index = BASE62_STR.indexOf(indexChar);
				power = base62.length() - i - 1;
				total += index*Math.pow(62, power);
			}
		}
		return String.valueOf(total);
	}
	
	/**
	 * 截去改字符串首尾的空格,回车和换行字符
	 * @param str
	 * @return
	 */
	public static String trimSRN(String str){
		if(str==null){
			return "";
		}	else {
			str = str.trim();			
			if(str.endsWith("\r\n") || str.endsWith("\n\r")){
				str = str.substring(0, str.length()-2);
			}else if(str.endsWith("\r") || str.endsWith("\n")){
				str = str.substring(0, str.length()-1);
			}			
			if(str.startsWith("\r\n") || str.startsWith("\n\r")){
				str = str.substring(2, str.length());
			}else if(str.startsWith("\r") || str.startsWith("\n")){
				str = str.substring(1, str.length());
			}			
			return str;
		}
	}
	
	public static String trimLastComma(String str) {	    
	    if (null == str) {
	        return "";
	    } else {
	        if (str.endsWith(",")) {
	            return str.substring(0, str.length() - 1);
	        } else {
	            return str;
	        }
	    }	    
	}
	
	public static String trimQuotedString(String str){
		if(str==null){
			return "";
		}else {
			if(str.startsWith("\"") || str.startsWith("\'")) {
				str = str.substring(1, str.length());
			}			
			if(str.endsWith("\"") || str.endsWith("\'")) {
				str = str.substring(0, str.length()-1);
			}
			return str;
		}
	}
	public static String toBase62(int input)
	{
		String b62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String my62mediaId = "";
		int r = 0;
		char c = 0;
		int 	spotsPlanId2=input;
		if(spotsPlanId2==0){
			my62mediaId ="+";
		}else{
			while (spotsPlanId2 > 0) {
				r = spotsPlanId2 % 62;
				c = b62.charAt(r);
				my62mediaId = c + my62mediaId;
				spotsPlanId2 = spotsPlanId2/ 62;
            }
        }
		return my62mediaId;
	}
	
    /**
	 * 判断s字符串是不是数字格式 
	 * 
	 * @return
	 */
	public static boolean isNumber(String s) {
		Pattern numberPattern = null;
		if(s==null){
			return false;
		}
		if (numberPattern == null){
			numberPattern = Pattern.compile("[\\+-]?[0-9]+");
		}
		return numberPattern.matcher(s).matches();
	} 
	/**
	 * 获取某一个月有多天的函数
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getDayOfMonth(int year, int month) {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, month);
		return c.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
	public static int getCurrentYear(){
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);//获取年份
		return year;
	}
	
	 public static String getOrderNumber(String latestOrderNumber){
			Integer index;	
			String orderNumber;
			if(latestOrderNumber!=null && latestOrderNumber.length()>9){
				index = Integer.valueOf(latestOrderNumber.substring(8));
				index++;
			}else{
				index = 1;
			}
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			DecimalFormat   df   =   new   DecimalFormat("000");  
			String   formatIndex  =   df.format(index);
			orderNumber = sdf.format(new Date())+formatIndex;
			return orderNumber;
		 }

	 public static String sheetNameEncode(String name){
		 if(name==null){
			 return "";
		 }
		 if(name.length()>31){
			 name=name.substring(0,31);
		 }
		 String[] specilCharacters=new String[]{"/", "?", "*", "[", "]"};
		 String[] replaceCharacters=new String[]{"／","?","*","[","]"};
		 for(int i=0;i<specilCharacters.length;i++){
				if(name.indexOf(specilCharacters[i])!=-1){
					name=name.replaceAll(specilCharacters[i], replaceCharacters[i]);
				} 
		 	}
		 return name;
	 }
	 
	 public static String GetOFieldHashCode(String oFieldURL) {
			if (oFieldURL == null || oFieldURL.length() == 0) {
				return null;
			}
			String hashCode = null;
			String oFieldURLlocal = null;
			
			Matcher matcher = getURLPattern.matcher(oFieldURL);
	        String temp = null;
	        if(matcher.find()){
	        	temp=matcher.group();
	        	oFieldURLlocal = "scv_v3" + temp;
	        	hashCode = "3";
	        } else {
	        	oFieldURLlocal = "scv_v2" + oFieldURL;
	        	hashCode = "2";
	        }
			
			int hash = 5381;
			char[] oFieldURLCharArray = oFieldURLlocal.toCharArray();
			for (char c : oFieldURLCharArray) {
				hash = ((hash << 5) + hash) + c;
			}
			hashCode += Integer.toHexString(hash);
			return hashCode;
		}
	 
	// 文件名中不能包含\/:*?"<>|中的任意字符
	// 半角空格（ ） 水平制表符（\t） 竖直制表符 回车（\r） 换行（\n） 换页符（\f）
	private static Pattern isValidFileNamePattern = Pattern
			.compile("[^\\s\\\\/:\\*\\?\\\"<>\\|](\\x20|[^\\s\\\\/:\\*\\?\\\"<>\\|])*[^\\s\\\\/:\\*\\?\\\"<>\\|\\.]$");

	public static boolean isValidFileName(String fileName) {
		if (fileName==null || fileName.length()>255)
			return false;
		else
			return isValidFileNamePattern.matcher(fileName).matches();
	}
	
	private static Pattern validFileNamePattern = Pattern
			.compile("[  \t\r\n\f\\\\/:\\*\\?\\\"<>\\|]");

	public static String getValidFileName(String fileName) {
		if(fileName==null || fileName.length()==0){
			return fileName;
		}
		if(fileName.length() > 255){
			fileName = fileName.substring(0, 255);
		}
		Matcher m = validFileNamePattern.matcher(fileName);
		return m.replaceAll("_");
	}
	/**
	 * 去掉字符串中的空格和各种制表符
	 * @description getStringNoBlank:
	 * @param str
	 * @return
	 * String
	 * @author zhangxihe@miaozhen.com 2014-1-16 下午3:03:09
	 */
	public static String getStringNoBlank(String str) {   
        if(StringUtils.isNotBlank(str)) {   
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");   
            Matcher m = p.matcher(str);   
            String strNoBlank = m.replaceAll("");   
            return strNoBlank;   
        }else {   
            return str;   
        }        
	}public static String toBase64(int input) {
        String my64mediaId = "";
        int r = 0;
        char c = 0;
        int spotsPlanId2 = input;
        if (spotsPlanId2 == 0) {
            my64mediaId = "+";
        } else {
            while (spotsPlanId2 > 0) {
                r = spotsPlanId2 % 64;
                c = BASE64_STR.charAt(r);
                my64mediaId = c + my64mediaId;
                spotsPlanId2 = spotsPlanId2 / 64;
            }
        }
        return my64mediaId;
    }
    
    public static int base64toDecimalInt(String base64) {
		char indexChar = 0;
		int index = 0;
		int power = 0;
		int total = 0;

		if (base64 != null) {
			for (int i = 0; i < base64.length(); i++) {
				indexChar = base64.charAt(i);
				index = BASE64_STR.indexOf(indexChar);
				power = base64.length() - i - 1;
				total += index * Math.pow(64, power);
			}
		}
		return total;
	}

	public static String base64toDecimalStr(String base64) {
		char indexChar = 0;
		int index = 0;
		int power = 0;
		int total = 0;

		if (base64 != null) {
			for (int i = 0; i < base64.length(); i++) {
				indexChar = base64.charAt(i);
				index = BASE64_STR.indexOf(indexChar);
				power = base64.length() - i - 1;
				total += index * Math.pow(64, power);
			}
		}
		return String.valueOf(total);
	}
	
    /**
     * str to list<string>, split by ,
     * @param str
     * @return
	 * @author zhangxihe@miaozhen.com
     */
	public static List<String> str2StrList(String str, String splitFlag){
		List<String> reList = null;
		if(StringUtils.isNotBlank(str)){
			String[] strArr = str.split(splitFlag);
			if(null != strArr && strArr.length > 0){
				reList = new ArrayList<>();
				for(String id:strArr){
					if(StringUtils.isNotBlank(id)){
						reList.add(id);
					}
				}
			}
		}
		return reList;
	}

	/**
	 * str to list<Integer>, split by ,
	 * @param str
	 * @return
	 * @author zhangxihe@miaozhen.com
	 */
	public static List<Integer> str2IntList(String str, String splitFlag){
		List<Integer> reList = null;
		if(StringUtils.isNotBlank(str)){
			String[] strArr = str.split(splitFlag);
			if(null != strArr && strArr.length > 0){
				reList = new ArrayList<>();
				for(String id:strArr){
					if(StringUtils.isNotBlank(id)){
						reList.add(Integer.valueOf(id));
					}
				}
			}
		}
		return reList;
	}
	
	/**
	 * decimalInttoBase64
	 * @param int 
	 * @return String
	 * @author jiasichao@miaozhen.com
	 */
	public static String decimalInttoBase64(int input) {
        String b64 = "+-0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String my64mediaId = "";
        int r = 0;
        char c = 0;
        int spotsPlanId2 = input;
        if (spotsPlanId2 == 0) {
            my64mediaId = "+";
        } else {
            while (spotsPlanId2 > 0) {
                r = spotsPlanId2 % 64;
                c = b64.charAt(r);
                my64mediaId = c + my64mediaId;
                spotsPlanId2 = spotsPlanId2 / 64;
            }
        }
        return my64mediaId;
    }
	
	/**
	 * 汉字转码
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static String getRightCode(String name){
		if(StringUtils.isNotBlank(name)){
			try{
				return new String(name.getBytes("ISO-8859-1"),"UTF-8");
			}catch(Exception e){
				logger.info("2 code error!");
			}
		}
	    return null;
	}
}
