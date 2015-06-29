package eleme.codedeploy.demojava.commons;

import java.io.File;
import java.util.List;

/**
 * Created by ww on 15/4/1.
 */
public class Appspace {
    private String version;
    private String os;
    private String language;
    private String apptype;
    private Hooks hooks;
    private List<Files> files;

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getApptype() {
        return apptype;
    }

    public void setApptype(String apptype) {
        this.apptype = apptype;
    }

    public Hooks getHooks() {
        return hooks;
    }

    public void setHooks(Hooks hooks) {
        this.hooks = hooks;
    }
}
