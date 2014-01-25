package org.mgilgar.hackthetower2014;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Props {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
