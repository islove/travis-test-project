package eleme.codedeploy.demojava.commons;

import java.util.List;

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
}
