package specs.robolectric;

import com.xtremelabs.robolectric.RobolectricConfig;
import com.xtremelabs.robolectric.RobolectricTestRunner;
import org.junit.runners.model.InitializationError;

import java.io.File;

// NOTE:
// http://testingdroids.wordpress.com/2012/02/18/extend-roboletrictestrunner-avoiding-linking-issues-related-to-androidmanifest-xml-location/
// https://groups.google.com/forum/?fromgroups=#!topic/robolectric/QX2vDYVVyWs
public class CustomRobolectricTestRunner extends RobolectricTestRunner {

    private static final String ProjectPath = "./LoneWolf";

    public CustomRobolectricTestRunner(Class testClass) throws InitializationError {
        super(testClass, new RobolectricConfig(new File(ProjectPath)));
    }
}
