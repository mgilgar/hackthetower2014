package org.mgilgar.hackthetower2014;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Parameters {
	private Props props;

	public Props getProps() {
		return props;
	}

	public void setProps(Props props) {
		this.props = props;
	}
}
