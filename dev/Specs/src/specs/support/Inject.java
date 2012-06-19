package specs.support;

import com.hoffenkloffen.lonewolf.controllers.SectionState;
import com.hoffenkloffen.lonewolf.controllers.javascript.injections.JavascriptInjection;

import java.util.Collection;

public class Inject implements JavascriptInjection {
    private String script;

    public Inject(String script) {
        this.script = script;
    }

    @Override
    public String getScript(Collection<SectionState> states) {
        return script;
    }
}
