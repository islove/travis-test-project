package eleme.codedeploy.demojava.commons;

import com.google.common.collect.Lists;
import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.representer.Representer;

import java.util.List;

/**
 * Created by ww on 15/4/1.
 */
public class Test {
    public static void main(String[] args) {
        Representer representer = new Representer();
        ;

        DumperOptions options = new DumperOptions();
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
        Appspace app = new Appspace();
        app.setVersion("1.0.0");
        app.setOs("linux");
        app.setLanguage("java");
        app.setApptype("app");

        List<Files> files = Lists.newArrayList();
        Files aFiles = new Files();
        aFiles.setDestination("conf/abc");
        List<String> src = Lists.newArrayList();
        src.add("111.txt");
        src.add("222.txt");
        aFiles.setSource(src);
        files.add(aFiles);

        List<ApplicationStart> list = Lists.newArrayList();
        ApplicationStart ass = new ApplicationStart();
        ass.setLocation("script/engine.sh stop");
        ass.setTimeout(180);
        list.add(ass);
        ass = new ApplicationStart();
        ass.setLocation("script/engine.sh start");
        ass.setTimeout(180);
        list.add(ass);

        List<ApplicationStop> list2 = Lists.newArrayList();
        ApplicationStop ass2 = new ApplicationStop();
        ass2.setLocation("script/engine.sh stop");
        ass2.setTimeout(180);
        list2.add(ass2);


        Hooks ahooks = new Hooks();
        ahooks.setApplicationStart(list);
        ahooks.setApplicationStop(list2);
        app.setHooks(ahooks);
        app.setFiles(files);

        Yaml yaml = new Yaml(representer, options);
        String output = yaml.dump(app);
        System.out.println(output);
    }
}
