package com.orchestra.components;

import org.slf4j.LoggerFactory;

public class WorkflowLogger {

	private org.slf4j.Logger logger;

	private WorkflowLogger(Class clazz) {
		logger = LoggerFactory.getLogger(clazz);
	}

	public static WorkflowLogger getLogger(Class clazz) {
		return new WorkflowLogger(clazz);
	}

	public void debug(String msg) {
		logger.debug(msg);
	}

	public void info(String msg) {
		logger.info(msg);
	}

	public void error(String msg) {
		logger.error(msg);
	}

	public void trace(String msg) {
		logger.trace(msg);
	}
}
