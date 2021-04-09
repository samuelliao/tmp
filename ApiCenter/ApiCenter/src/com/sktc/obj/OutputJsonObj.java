package com.sktc.obj;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class OutputJsonObj implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6025550539233440371L;

	public OutputJsonObj() {
		this.message = "";
		this.status = 0;
		this.detail = null;
	}

	public OutputJsonObj(int stat, String msg, Object obj) {
		this.message = msg;
		this.detail = obj;
		this.status = stat;
	}

	@XmlElement
	String message;
	@XmlElement
	int status;
	@XmlElement
	Object detail;

}
