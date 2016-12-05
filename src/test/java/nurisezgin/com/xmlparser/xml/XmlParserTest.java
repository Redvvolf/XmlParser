package nurisezgin.com.xmlparser.xml;

import nurisezgin.com.xmlparser.tools.DefaultXmlTagHandler;
import nurisezgin.com.xmlparser.tools.XmlParserResultListener;
import nurisezgin.com.xmlparser.xml.items.XmlDoc;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.net.URI;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.core.IsNull.notNullValue;

/**
 * Created by nurisezgin on 05/12/2016.
 */
public class XmlParserTest {

    private final static String TEST_URI = "http://www.ntv.com.tr/gundem.rss";

    @Mock
    XmlParserResultListener mockListener;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldInitialize() {
        new XmlParser(null);
    }

    @Test
    public void shouldXmlDocumentCreateCorrect() throws Exception {
        XmlDoc doc = createXmlDoc(TEST_URI);
        assertThat("XmlDoc create successfully and ", doc, is(notNullValue()));
    }

    @Test
    public void shouldXmlDocumentClearAfterParseFinished() throws Exception {
        XmlDoc doc = createXmlDoc(TEST_URI);
        assertThat("XmlDoc reference was erased and after parse should be ", doc.getXmlTagStack(), is(empty()));
    }

    @Test
    public void shouldXmlDocumentAddTagsToDocument() throws Exception {
        XmlDoc doc = createXmlDoc(TEST_URI);
        assertThat("XmlDoc ", doc.hasChildren(), is(true));
    }

    @Test
    public void shouldXmlDocumentCollapseSuccessfully() throws Exception {
        XmlDoc doc = createXmlDoc(TEST_URI);
        doc.collapse();
    }

    private XmlDoc createXmlDoc(String link) throws Exception {
        DefaultXmlTagHandler tagHandler = new DefaultXmlTagHandler(mockListener);
        XmlParser parser = new XmlParser(tagHandler);
        parser.parser(URI.create(link));
        return tagHandler.getDocument();
    }

}