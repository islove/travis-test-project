package eleme.codedeploy.demojava.commons;

import java.util.List;

/**
 * Created by ww on 15/4/1.
 */
public class Hooks {
    private List<ApplicationStart> ApplicationStart;
    private List<ApplicationStop> ApplicationStop;
    private List<BeforeInstall> BeforeInstall;
    private List<ValidateService> ValidateService;
    private List<AfterInstall> AfterInstall;

    public List<AfterInstall> getAfterInstall() {
        return AfterInstall;
    }

    public void setAfterInstall(List<AfterInstall> afterInstall) {
        AfterInstall = afterInstall;
    }

    public List<BeforeInstall> getBeforeInstall() {
        return BeforeInstall;
    }

    public void setBeforeInstall(List<BeforeInstall> beforeInstall) {
        BeforeInstall = beforeInstall;
    }

    public List<ValidateService> getValidateService() {
        return ValidateService;
    }

    public void setValidateService(List<ValidateService> validateService) {
        ValidateService = validateService;
    }

    public List<ApplicationStart> getApplicationStart() {
        return ApplicationStart;
    }

    public void setApplicationStart(List<ApplicationStart> applicationStart) {
        ApplicationStart = applicationStart;
    }

    public List<ApplicationStop> getApplicationStop() {
        return ApplicationStop;
    }

    public void setApplicationStop(List<ApplicationStop> applicationStop) {
        ApplicationStop = applicationStop;
    }
}
