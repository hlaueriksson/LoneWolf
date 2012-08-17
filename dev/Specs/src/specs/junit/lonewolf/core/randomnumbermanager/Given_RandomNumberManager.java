package specs.junit.lonewolf.core.randomnumbermanager;

import com.hoffenkloffen.lonewolf.core.abstractions.ISectionManager;
import com.hoffenkloffen.lonewolf.core.RandomNumberManager;
import com.hoffenkloffen.lonewolf.core.section.Section;
import org.mockito.Mockito;
import specs.junit.BaseSpec;

public class Given_RandomNumberManager extends BaseSpec {
    protected RandomNumberManager manager;

    protected ISectionManager sectionManager;

    protected void given() {
        sectionManager = Mockito.mock(ISectionManager.class);
        Mockito.when(sectionManager.getCurrent()).thenReturn(new Section("1"));

        manager = new RandomNumberManager(sectionManager);
    }
}
