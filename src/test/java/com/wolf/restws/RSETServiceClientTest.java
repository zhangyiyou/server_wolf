package com.wolf.restws;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wolf.restws.dto.User;
import com.wolf.restws.impl.IUserInfoService;

public class RSETServiceClientTest {
	
	private static IUserInfoService infoService;
	@Before
	public void init(){
		  // 手动创建webClient对象，注意这里的地址是发布的那个/rest地址
		String url = "http://localhost:8080/server_wolf/services/rest/";
//		client = WebClient.create(url);
		// 从Spring Ioc容器中拿webClient对象
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-core-cxf.xml");
		IUserInfoService infoService= context.getBean("webClient",IUserInfoService.class);
		
	}
	
	@Test
	public void testUserName() {
		fail("Not yet implemented");
	}

	@Test
	public void testUserAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testDoGet() {
//		System.out.println(JAXRSClientFactory.create("http://localhost:8080/server_wolf/services/rest/", IUserInfoService.class).doGet());
		fail("Not yet implemented");
	}

	@Test
	public void testDoRequest() {
//		 System.out.println(client.path("sample/request/234234").accept(MediaType.TEXT_PLAIN).get(String.class));
		fail("Not yet implemented");
	}

	@Test
	public void testGetBean() {
//		 User user = client.path("sample/bean/{id}", 25).accept(MediaType.APPLICATION_XML).get(User.class);
		fail("Not yet implemented");
	}

	@Test
	public void testGetList() {
//		System.out.println(client.path("sample/list").accept(MediaType.APPLICATION_XML).get(Users.class).getUsers());
		fail("Not yet implemented");
	}

	@Test
	public void testGetMap() {
//		System.out.println(client.path("sample/map").accept(MediaType.APPLICATION_XML).get(MapBean.class).getMap());
		fail("Not yet implemented");
	}

	@Test
	public void testPostData() {
		User user = new User();
        user.setId(21432134);
        user.setAddress("hoojo#gz");
        user.setEmail("hoojo_@126.com");
        user.setName("hoojo");
//        System.out.println(client.path("sample/postData").accept(MediaType.APPLICATION_XML).post(user, User.class));
		fail("Not yet implemented");
	}

	@Test
	public void testPutData() {
		User user = new User();
        user.setId(21432134);
//        System.out.println(client.path("sample/putData/1").accept(MediaType.APPLICATION_XML).put(user).getEntity());
		fail("Not yet implemented");
	}

	@Test
	public void testDelData() {
		fail("Not yet implemented");
	}

	@After
	public void destory(){
		
	}
}
