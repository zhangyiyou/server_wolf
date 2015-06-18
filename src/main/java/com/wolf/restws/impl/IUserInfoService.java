package com.wolf.restws.impl;

import java.io.IOException;

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

import com.wolf.restws.dto.TransMap;
import com.wolf.restws.dto.User;
import com.wolf.restws.dto.Users;

/**
 * @Path：定义资源基 URI。由上下文根和主机名组成，资源标识符类似于
 *             http://localhost:8080/RESTful/rest/hello。
 * @GET：这意味着以下方法可以响应 HTTP GET 方法。
 * @Produces：该标签标注资源类或方法返回的 MIME 类型 , 也就是资源方法产生并且返回给客户端的响应消息的类型。。
 * @Context： 使用该注释注入上下文对象，比如 Request、Response、UriInfo、ServletContext 等。
 * @Path("{contact ")：这是 @Path 注释，与根路径 “/contacts” 结合形成子资源的 URI。
 * @PathParam("contact")：该注释将参数注入方法参数的路径，在本例中就是联系人 id。其他可用的注释有 @FormParam、@QueryParam
 *                                                 等。
 * @Produces：响应支持多个 MIME 类型。在本例和上一个示例中，APPLICATION/XML 将是默认的 MIME 类型。
 * @author Administrator
 *
 */
@Path(value = "UserInfoService")
public interface IUserInfoService {

	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	public String doGet();

	@GET
	@Produces(value = MediaType.TEXT_PLAIN)
	@Path(value = "/request/{param}")
	public String doRequest(@PathParam(value = "param") String param,
			@Context HttpServletRequest request,
			@Context HttpServletResponse response);

	@GET
	@Path(value = "/bean/{id}")
//	@Consumes(value ={ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User getBean(@PathParam(value = "id") int id);

	@GET
	@Path(value = "/list")
	@Produces(value = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Users getList();

	@GET
	@Path(value = "/map")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public TransMap getMap();

	/**
	 * @Consumes：声明该方法使用 HTML FORM。
	 * @FormParam(value = "")：注入该方法的 HTML 属性确定的表单输入。
	 */
	@POST
	@Path(value = "/postData")
	@Produces(value = { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public User postData(User user) throws IOException;

	@PUT
	@Path(value = "/putData/{id}")
	@Consumes(value = MediaType.APPLICATION_XML)//该标签标注资源类或方法可以接受的请求消息的类型，也就是客户端发送的请求中可以包含的 Http Entity 的类型
	public User putData(@PathParam("id") int id, User user);

	@DELETE
	@Path(value = "/removeData/{id}")
	public void delData(@PathParam("id") int id);

	@GET
	// 这里@Path定义了类的层次路径。指定了资源类提供服务的URI路径。
	@Path(value = "/name/{i}")
	// @Produces定义了资源类方法会生成的媒体类型。
	@Produces(value = MediaType.TEXT_XML)
	String userName(String i);

	@GET
	@Path("/age/{j}")
	@Produces(MediaType.TEXT_XML)
	String userAge(int j);

}
