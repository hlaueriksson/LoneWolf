package specs.support;

import com.hoffenkloffen.lonewolf.controllers.SectionResourceManager;
import com.hoffenkloffen.lonewolf.models.Illustration;

import java.io.IOException;

public class TestSectionResourceManager implements SectionResourceManager {

    @Override
    public String getHtmlTemplate() {
        String path = "\\LoneWolf\\res\\raw\\html_section_template.html";

        try {
            return TestSupport.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getHtmlTitle() {
        return "Title";
    }

    @Override
    public String getHtmlStyle() {
        return "/* style */";
    }

    @Override
    public String getHtmlScript() {
        return "/* script */";
    }

    @Override
    public String getHtmlContent(String number) {
        String path = "\\Specs\\src\\specs\\support\\data\\%s.xml";

        try {
            return TestSupport.readFile(String.format(path, number));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getBase64Image(Illustration illustration) {
        return "SWxsdXN0cmF0aW9u";
    }
}
