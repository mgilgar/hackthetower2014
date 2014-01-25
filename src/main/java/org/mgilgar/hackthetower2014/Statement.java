package org.mgilgar.hackthetower2014;

import org.codehaus.jackson.annotate.JsonAutoDetect;

@JsonAutoDetect
public class Statement {
	private String statement;
	
	private Parameters parameters;

	public Statement(String statement) {
		this.statement = statement;
	}
	
	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
}
