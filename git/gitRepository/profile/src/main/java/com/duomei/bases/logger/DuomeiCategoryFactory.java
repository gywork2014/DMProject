package com.duomei.bases.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

/**
* @ClassName: MonitorCategoryFactory
* @Description: 日志工厂类用于和LOG4J整合
* @author yujiawei yujiawei@miaozhen.com
* @date 2011-3-25 下午04:56:10
*
*/
public class DuomeiCategoryFactory implements LoggerFactory {
	@Override
	public Logger makeNewLoggerInstance(String name) {
		return new DuomeiLogger(name);
	}
}
