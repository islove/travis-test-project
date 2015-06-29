package com.elm.deploy.builder.rest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;



/**
 * 
 * @author yf.wu
 */
@Component
@Scope("prototype")
@Api(value = "/api/v1", description = "builder callback handler")
@Path("/api/v1")
public class QueryRes {
	
    @GET
	@Path("/show")
	@Produces({ MediaType.TEXT_PLAIN })
	@ApiOperation(value = "gitlab push handler", notes = "gitlab push handler", multiValueResponse = true, responseClass = "java.lang.String")
	//@Eloging(ElogingConstants.GITLAB_PUSH_WEBHOOK)
	public String gitlabPush() throws Exception{
    	String file=System.getProperty("CONF_DIR");
    	System.out.println("conf_dir:" + file);
    	return "{status:\"runing\",conf:\""+readFileByLines(file + "/app.conf")+"\"}";
	}
	
   
    public String readFileByLines(String fileName) {  
        File file = new File(fileName); 
        if(!file.exists()){
        	return "app.conf 文件不存在";
        }
        BufferedReader reader = null;  
        StringBuilder sb = new StringBuilder();
        try {  
            reader = new BufferedReader(new FileReader(file));  
            String tempString = null;  
                       
            while ((tempString = reader.readLine()) != null) {  
            	sb.append(tempString+"\n");  
                
            }  
            reader.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            if (reader != null) {  
                try {  
                    reader.close();  
                } catch (IOException e1) {  
                }  
            }  
        }  
        return sb.toString();
    }  
    
}
