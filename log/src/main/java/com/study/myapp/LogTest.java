package com.study.myapp;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogTest {
	
//	private static final Logger log = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		log.error("error");
		log.warn("warn");
		log.info("info");
		log.debug("debug");
		log.trace("trace");
	}

}
