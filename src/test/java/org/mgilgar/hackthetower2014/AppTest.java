package org.mgilgar.hackthetower2014;

import junit.framework.Assert;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.hasSize;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.springframework.web.client.RestTemplate;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
// TODO: No mocking, because I am using the test to run the methods.
public class AppTest 
{
	private App app;
	
	@Before
	public void setUp() {
		app = new App();
		app.setRestTemplate(new RestTemplate());
	}

	@Test
	public void doCreateShouldReturnNoErrors() {
		Response response = app.doCreateNodes();
		assertThat(response.getErrors(), hasSize(0));
	}
	
	@Test
	public void doDeleteNodesShouldReturnNoErrors() {
		Response response = app.doDeleteNodes();
		assertThat(response.getErrors(), hasSize(0));
	}
	
	@Test
	public void doGetRootShouldReturnAString() {
		String result = app.doGetRoot();
		System.out.println(result);
	}
	
}
