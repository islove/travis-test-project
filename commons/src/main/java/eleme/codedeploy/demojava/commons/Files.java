package eleme.codedeploy.demojava.commons;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ww on 15/4/1.
 */
public class Files {
    private List<String> source;
    private String destination;

    public List<String> getSource() {
        return source;
    }

    public void setSource(List<String> source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    public boolean isOk(){
		String pattern = "(master|dev)";
		String branchName = "dev";
		Pattern p=Pattern.compile(pattern);
		Matcher m=p.matcher(branchName);
	    
		System.out.println(m.matches());
		System.out.println(m.find());
    	return true;
    }
}
