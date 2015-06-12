package com.wolf.restws;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.wolf.restws.dto.TransMap;
import com.wolf.restws.dto.User;
import com.wolf.restws.dto.Users;
import com.wolf.restws.impl.IUserInfoService;

/**
 * 这里的@path定义了类的层次路径
 * 指定了资源类提供服务的URI路径
 * @author Administrator
 *
 */
@Path(value = "UserInfoService")
public class UserInfoService implements IUserInfoService{
	@Context
	private UriInfo uriInfo;//获取URI中的信息
	@Context
	private Request req;
	
	
	//@get表示方法会处理http get请求
	@GET
	//这里@Path定义了类的层次路径。指定了资源类提供服务的URI路径。
	@Path(value = "/name/{i}")
	//@Produces定义了资源类方法会生成的媒体类型。
	@Produces(value=MediaType.TEXT_XML)
	public String userName(@PathParam(value = "i")String i){// @PathParam向@Path定义的表达式注入URI参数值。
		String name = i;
		return "<User>" + "<Name>" + name + "</Name>" + "</User>";
	}
	
	@GET
	@Path("/age/{j}") 
	@Produces(MediaType.TEXT_XML)
	public String userAge(@PathParam("j") int j) {
		int age = j;
		return "<User>" + "<Age>" + age + "</Age>" + "</User>";
	}

	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	public String doGet() {
		return "this is get rest request";
	}

	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	@Path(value = "/request/{param}")
	public String doRequest(String param, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(request);
		System.out.println(response);
		System.out.println(request.getParameter("param"));
		System.out.println(request.getContentType());
		System.out.println(request.getCharacterEncoding());
		System.out.println(request.getContentType());
		return "success";
	}

	@GET
	@Path(value = "/bean/{id}")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User getBean(int id) {
		System.out.println("####getBean#####");
	    System.out.println("id:" + id);
	    System.out.println("Method:"+req.getMethod());
	    System.out.println("uri:"+uriInfo.getPath());
	    System.out.println(uriInfo.getPathParameters());
	    User user = new User();
        user.setId(id);
        user.setName("JojO");
        return user;
	}

	@GET
	@Path(value = "/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Users getList() {
		System.out.println("####getList#####");
	    System.out.println("Method:"+req.getMethod());
	    System.out.println("uri:"+uriInfo.getPath());
	    System.out.println(uriInfo.getPathParameters());
	    List<User> list = new ArrayList<User>();
	    User user = null;
	    for (int i = 0; i < 4;i ++) {
            user = new User();
            user.setId(i);
            user.setName("JojO-" + i);
            list.add(user);
        }
	    Users users = new Users();
        users.setUsers(list);
        return users;
	}

	@GET
	@Path(value = "/map")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public TransMap getMap() {
		System.out.println("####getMap#####");
		System.out.println("Method:"+req.getMethod());
	    System.out.println("uri:"+uriInfo.getPath());
	    System.out.println(uriInfo.getPathParameters());
	    
		return null;
	}

	@POST
	@Path(value = "/postData")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User postData(User user) throws IOException {
		System.out.println(user);
		user.setName("jojo##12321321");
		return user;
	}

	@PUT
	@Path(value = "/putData/{id}")
	@Consumes(value = MediaType.APPLICATION_XML)
	public User putData(int id, User user) {
		System.out.println("#####putData#####");
        System.out.println(user);
        user.setId(id);
        user.setAddress("北京望京");
        user.setEmail("zhangyiyou@126.com");
        user.setName("张益友");
        System.out.println(user);
        return user;
	}

	@DELETE
	@Path(value = "/removeData/{id}")
	public void delData(int id) {
		 System.out.println("#######deleteData#######" + id);
	}
	
}
