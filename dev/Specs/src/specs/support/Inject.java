package specs.support;

import com.hoffenkloffen.lonewolf.controllers.section.SectionState;
import com.hoffenkloffen.lonewolf.controllers.section.injections.JavascriptInjection;

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
