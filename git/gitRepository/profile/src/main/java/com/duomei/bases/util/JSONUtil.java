package com.duomei.bases.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

public class JSONUtil {
	// private static TLSLogger logger = TLSLogger.getLogger(JSONUtil.class);

	public static Integer getIntJson(JSONObject argObject, String param) {
		if (null == argObject || StringUtils.isBlank(param)) {
			return null;
		}

		if (argObject.containsKey(param)) {
			return argObject.getInt(param);
		} else {
			return null;
		}
	}

	public static String getStrJson(JSONObject argObject, String param) {
		if (null == argObject || StringUtils.isBlank(param)) {
			return null;
		}

		if (argObject.containsKey(param)) {
			return argObject.getString(param);
		} else {
			return null;
		}
	}

	/**
	 * 从一个JSON 对象字符格式中得到一个java对象
	 * 
	 * @param jsonString
	 * @param beanCalss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T jsonToBean(String jsonString, Class<T> beanCalss) {
		JSONObject jsonObject = JSONObject.fromObject(jsonString);
		T bean = (T) JSONObject.toBean(jsonObject, beanCalss);
		return bean;
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param bean
	 * @return
	 */
	public static String beanToJson(Object bean) {
		JSONObject json = JSONObject.fromObject(bean);
		return json.toString();
	}

	/**
	 * 将java对象List集合转换成json字符串
	 * 
	 * @param beans
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String beanListToJson(List beans) {
		StringBuffer rest = new StringBuffer();
		rest.append("[");
		int size = beans.size();
		for (int i = 0; i < size; i++) {
			rest.append(beanToJson(beans.get(i)) + ((i < size - 1) ? "," : ""));
		}
		rest.append("]");
		return rest.toString();
	}

	/**
	 * 从json对象集合表达式中得到一个java对象列表
	 * 
	 * @param jsonString
	 * @param beanClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> jsonToBeanList(String jsonString,
			Class<T> beanClass) {
		JSONArray jsonArray = JSONArray.fromObject(jsonString);
		JSONObject jsonObject;
		T bean;
		int size = jsonArray.size();
		List<T> list = new ArrayList<T>(size);
		for (int i = 0; i < size; i++) {
			jsonObject = jsonArray.getJSONObject(i);
			bean = (T) JSONObject.toBean(jsonObject, beanClass);
			list.add(bean);
		}
		return list;
	}

	/**
	 * 
	 * @description outMessage:返回结果信息
	 * @param reMap
	 * @param errorBean
	 * @param response
	 * @throws Exception
	 *             void
	 * @author zhangxihe@miaozhen.com 2013-11-22 下午4:07:45
	 */
	public static <T> void outBeanMessage(T bean, HttpServletResponse response)
			throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (null != bean) {
			out.write(JSONUtil.beanToJson(bean));
		} else {// error
			response.setStatus(400);
			out.write("");
		}
		out.flush();
		out.close();
	}

	public static <T> void outMapMessage(Map<String, T> bean,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (null == bean) {// error
			response.setStatus(400);
			out.write("");
		} else {// the normal return value
			out.write(JSONUtil.beanToJson(bean));
		}
		out.flush();
		out.close();
	}

	public static <T> void outBeansMessage(List<T> beans,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (null == beans) {// error
			response.setStatus(400);
			out.write("");
		} else {// the normal return value
			out.write(JSONUtil.beanListToJson(beans));
		}
		out.flush();
		out.close();
	}

	public static <T> void outMapBeansMessage(List<Map<T, T>> beans,
			HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if (null == beans) {// error
			response.setStatus(400);
			out.write("");
		} else {// the normal return value
			out.write(JSONUtil.beanListToJson(beans));
		}
		out.flush();
		out.close();
	}

	public static void MapToJson(Map<String, String> map,HttpServletResponse response) throws Exception {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		if(null==map){
			response.setStatus(400);
			out.write("");
		}
		else{
			Set<String> keys = map.keySet();
		    String key = "";
		    String value = "";
		    StringBuffer jsonBuffer = new StringBuffer();
		    jsonBuffer.append("[{");    
		    for(Iterator<String> it = keys.iterator();it.hasNext();){
		        key =  (String)it.next();
		        value = map.get(key);
		        jsonBuffer.append("\""+key+"\":\""+value+"\"");
		        if(it.hasNext()){
		             jsonBuffer.append(",");
		        }
		    }
		    jsonBuffer.append("}]");
		    out.write( jsonBuffer.toString());
		} 
	} 

}
