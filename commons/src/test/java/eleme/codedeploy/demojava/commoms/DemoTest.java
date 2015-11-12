package eleme.codedeploy.demojava.commoms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eleme.codedeploy.demojava.commons.Files;
import eleme.codedeploy.demojava.commons.ValidateService;

public class DemoTest {
	
	@Test  
    public void test1(){  
        System.out.println("junit test1 is executed."); 
        Files files = new Files();
        files.setDestination("dog.liao");
        assertTrue("Result 为true ", "dog.liao".equals(files.getDestination())); 
    }  
	
	@Test  
    public void test2(){  
        System.out.println("junit test2 is executed."); 
        ValidateService validateService = new ValidateService();
        validateService.setLocation("dog.liao");
        assertTrue("Result 为true ", "dog.liao".equals(validateService.getLocation())); 
    }  
}
