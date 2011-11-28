package com.pfm.handler

import org.apache.commons.logging.LogFactory;

abstract class EventHandler {
	
	static final log = LogFactory.getLog(this)
	
	def abstract Handle(Map msg)
}
