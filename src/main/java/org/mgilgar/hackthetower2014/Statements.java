package org.mgilgar.hackthetower2014;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonAutoDetect;

import com.google.common.collect.Lists;


@JsonAutoDetect
public class Statements {
	private List<Statement> statements;

	public Statements() {
		statements = Lists.newArrayList();
	}
	
	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}
}
