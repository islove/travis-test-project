package eleme.codedeploy.demojava.commoms;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import eleme.codedeploy.demojava.commons.Files;
import eleme.codedeploy.demojava.commons.ValidateService;

public class DemoTest {
	Files files = new Files();
	ValidateService validateService = new ValidateService();
	@Test  
    public void test1(){  
        System.out.println("junit test1 is executed."); 
        
        files.setDestination("dog.liao");
        assertTrue("test1 result:", "dog.liao".equals(files.getDestination())); 
    }  
	
	@Test  
    public void test2(){  
        System.out.println("junit test2 is executed."); 
        validateService.setLocation("dog.liao");
        assertTrue("test2 result", "dog.liao".equals(validateService.getLocation())); 
    }  
	
	@Test
	public void test3(){
        System.out.println("junit test3 is executed."); 
       
        assertTrue("test3 result", files.isOk()); 
	}
}
