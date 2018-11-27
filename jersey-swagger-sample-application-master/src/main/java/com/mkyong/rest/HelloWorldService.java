package com.mkyong.rest;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.sun.jersey.spi.resource.PerRequest;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiImplicitParam;
import com.wordnik.swagger.annotations.ApiImplicitParams;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
 
@Path("/hello")
@Api(value = "/hello", description="Test Hello world API")
/*@Produces({MediaType.TEXT_PLAIN})*/
public class HelloWorldService 
{
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.TEXT_PLAIN)
	@ApiOperation(value = "/{param}",
				  notes = "Test API to say hello to a person",
				  response = Response.class)
	@ApiResponses( {
	    @ApiResponse( code = 404, message = "URL not found" ),
	    @ApiResponse( code = 200, message = "Saying hello to person" )  
	} )
	public Response getMsg(@ApiParam( value = "Message to say hello", required = true ) @PathParam("param") String msg) 
	{
 		String output = "Jersey say : " + msg;
 		return Response.status(200).entity(output).build();
 	}
	
	@ApiOperation(value="adding Employee data to the display",notes="Add employee", response=Employee.class)
	@ApiImplicitParams(
			{
				@ApiImplicitParam(name="body",paramType="body",dataType="Employee",required=true)
			})
	
	@POST	
	@Path("/addEmployee")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addEmployeeData( @ApiParam(defaultValue= "Employee", value="Employee details in JSON")String name) {
		
		return name;
	}
	
//	@ApiOperation(value="adding Employee data to the display",notes="Add employee", response=Employee.class)
//	@POST	
//	@Path("/addEmployee")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Employee addEmployeeData( Employee name) {
//		
//		return name;
//	}
 
}