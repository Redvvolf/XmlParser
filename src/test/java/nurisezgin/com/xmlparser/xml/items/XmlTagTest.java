package nurisezgin.com.xmlparser.xml.items;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by nurisezgin on 05/12/2016.
 */
public class XmlTagTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldNeverInitializeWithNullTagName() {
        new XmlTag(null, null);
    }

    @Test
    public void shouldMergeOldText() {
        String sampleText = "Sample";
        XmlTag xmlTag = new XmlTag(null, null);
        xmlTag.addText(sampleText.substring(0, 3));
        xmlTag.addText(sampleText.substring(3));
        String xmlText = xmlTag.text();
        assertThat("After 2 different text will be ", xmlText, is(equalTo(sampleText)));
    }

    @Test
    public void shouldClearCorrect() throws Exception {
        new XmlTag(null, null).clear();
    }

}