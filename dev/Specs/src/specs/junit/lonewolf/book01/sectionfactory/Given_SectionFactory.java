package specs.junit.lonewolf.book01.sectionfactory;

import com.hoffenkloffen.lonewolf.book01.SectionFactory;
import com.hoffenkloffen.lonewolf.core.SectionManager;
import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import specs.junit.BaseSpec;

public class Given_SectionFactory extends BaseSpec {
    protected SectionFactory factory;
    protected ISectionManager manager;

    protected void given() {
        manager = new SectionManager(null, null, null);

        factory = new SectionFactory();
        factory.init(manager);
    }
}
