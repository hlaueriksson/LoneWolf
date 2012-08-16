package specs.junit.lonewolf.core.actionchartmanager;

import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.verify;

public class When_display extends Given_ActionChartManager {

    protected void given() {
        super.given();
        Mockito.when(resourceHandler.getHtmlTemplate()).thenReturn("%1%s, %2%s, %3%s, %4%s, %5%s");
    }

    protected void when() {
        manager.display();
    }

    @Test
    public void then_the_renderer_should_load_the_content_data() {
        verify(renderer).loadData(anyString(), anyString(), anyString());
    }
}
