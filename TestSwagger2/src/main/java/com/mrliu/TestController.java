package com.mrliu;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.models.Path;

@Api(value = "测试控制器层")
@RestController
public class TestController {
	
    @RequestMapping("/hello")
    @ApiOperation(value = "sayhello 就是说hello的意思")
	@ApiImplicitParam(
			name = "sayhello",
			dataType = "String",
			required = false,
			paramType = "/sayhello")
   @ApiResponses({
	   @ApiResponse(code = 400,message = "参数没有设置好",response = String.class),
	   @ApiResponse(code = 200,message = "正常返回",response = String.class)
   })
  
    public String sayhello(String name)
	{
		return "hello world,"+name;
	}
}
