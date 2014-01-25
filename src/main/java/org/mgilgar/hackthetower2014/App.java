package org.mgilgar.hackthetower2014;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.common.collect.Lists;

import javax.annotation.Resource;


/**
 * Hello world!
 *
 */
/**
 * Query:
 * 
 * CREATE (article1:Article {title:"title1"})		
,(article2:Article {title:"title2"})		
,(article3:Article {title:"title3"})
,(author1:Author {name:"Miguel1"})		
,(author2:Author {name:"Miguel2"})		
,(author3:Author {name:"Miguel3"})
,(author1)-[:WROTE {date:2010}]->(article1)
,(author1)-[:WROTE {date:2010}]->(article2)
,(author2)-[:WROTE {date:2010}]->(article3)

create (article1)-[:INSPIRED]->(article2)
,(article1)-[:INSPITED]->(article3)
,(article3)-[:INSPIRED]->(article2)
 * 
 * @author mgilgar3
 *
 */
/*
 * Typical reponse after creation:
 * {"commit":"http://localhost:7474/db/data/transaction/102/commit","results":[{"columns":[],"data":[]}],"transaction":{"expires":"Sat, 11 Jan 2014 17:06:37 +0000"},"errors":[]}
 */
public class App 
{
	private RestTemplate restTemplate;
	
	// TODO: This method should go to a service/dao class
	public Response doCreateNodes() {
		String command = "CREATE (article1:Article {title:\"title1\"}) " 
					+ ",(article2:Article {title:\"title2\"})" 
					+ ",(article3:Article {title:\"title3\"})" 
					+ ",(author1:Author {name:\"Miguel1\"})"
					+ ",(author2:Author {name:\"Miguel2\"})"
					+ ",(author3:Author {name:\"Miguel3\"})"
					+ ",(author1)-[:WROTE {date:2010}]->(article1)"
					+ ",(author1)-[:WROTE {date:2010}]->(article2)"
					+ ",(author2)-[:WROTE {date:2010}]->(article3)"
					+ ",(article1)-[:INSPIRED]->(article2)"
					+ ",(article1)-[:INSPIRED]->(article3)"
					+ ",(article3)-[:INSPIRED]->(article2)"
					;
		
		return doStatements(Lists.newArrayList(command));
	}
	
	// TODO: This method should go to a service/dao class
	public Response doDeleteNodes() {

		Response response = doStatements(Lists.newArrayList("MATCH n-[r:WROTE]->nn DELETE r"
				,"MATCH n-[r:INSPIRED]->nn DELETE r"
				,"MATCH (n) DELETE n"));
		return response;
	}
	
	public String doGetRoot() {
		String result = restTemplate.getForObject("http://localhost:7474/db/data/", String.class);
		return result;
	}
	
	// TODO: Not all statements should be run with transaction/commit
	private Response doStatements(List<String> commands) {
		Statements statements = new Statements();
		for (String command: commands) {
			Statement statement = new Statement(command);
			statements.getStatements().add(statement);			
		}
		//statement.setParameters(parameters);
		ResponseEntity<Response> response = restTemplate.postForEntity("http://localhost:7474/db/data/transaction/commit", statements, Response.class);
		return response.getBody();
	}
	
	@Resource
	public void setRestTemplate(final RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        App app  = new App();
        System.out.println(app.doGetRoot());
    }
}
