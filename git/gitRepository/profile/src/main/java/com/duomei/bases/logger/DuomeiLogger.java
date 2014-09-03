package com.duomei.bases.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.duomei.bases.util.ThreadAttributes;

/**
 * @ClassName: MonitiorLogger
 * @Description: 日志记录器整合到LOG4J
 * @author yujiawei yujiawei@miaozhen.com
 * @date 2011-3-25 下午04:55:41
 * 
 */
public class DuomeiLogger extends Logger {

	private static final String FQCN = DuomeiLogger.class.getName();

	protected DuomeiLogger(String name) {
		super(name);
	}

	@SuppressWarnings("unchecked")
	public static DuomeiLogger getLogger(Class clazz) {
		return (DuomeiLogger) Logger.getLogger(clazz.getName(),
				new DuomeiCategoryFactory());
	}

	@Override
	public void debug(Object message) {
		Integer userId = (Integer) ThreadAttributes
				.getThreadAttribute("");
		if (repository.isDisabled(Level.DEBUG_INT)){
			return;
		}
		if (Level.DEBUG.isGreaterOrEqual(this.getEffectiveLevel())) {
			forcedLog(FQCN, Level.DEBUG, "userId = " + userId + " " + message,null);
		}
	}

	@Override
	public void error(Object message) {
		if (repository.isDisabled(Level.ERROR_INT)){
			return;
		}
		if (Level.ERROR.isGreaterOrEqual(this.getEffectiveLevel())){
			forcedLog(FQCN, Level.ERROR, message, null);
		}
	}

	@Override
	public void info(Object message) {

		Integer userId = (Integer) ThreadAttributes
				.getThreadAttribute("");
		if (repository.isDisabled(Level.INFO_INT)){
			return;
		}
		if (Level.INFO.isGreaterOrEqual(this.getEffectiveLevel())){
			forcedLog(FQCN, Level.INFO, "userId = " + userId + " " + message,null);
		}

		// super.info(super.name + "userId = " + userId + " " + message);

	}
}
