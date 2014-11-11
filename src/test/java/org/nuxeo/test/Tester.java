package org.nuxeo.test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.nuxeo.converter.Converter;
import org.nuxeo.converter.ConverterService;
import org.nuxeo.converter.impl.ConverterServiceImpl;


/**
 * Here are the unit tests that must be verified by the implementation
 * 
 * @author tiry
 *
 */
public class Tester {
    
    static ConverterService cs = new ConverterServiceImpl(); 
    
    protected static File getDataFile(String name) throws Exception {
        
        URL dataUrl = Tester.class.getClassLoader().getResource(name);
        assertNotNull(dataUrl);
        File dataFile = new File(URLDecoder.decode(dataUrl.getPath(), "UTF-8"));
        return dataFile;
        
    }
    
    @BeforeClass
    public static void initConvertersFromDataFile() throws Exception {
        
        File convertersDefinitions = getDataFile("converters.data");        
        List<Converter> converters = cs.loadConvertersFromFile(convertersDefinitions);
        assertEquals(13, converters.size());
        
    }
    
    /**
     * Verify that all converters have been loaded 
     * 
     * @throws Exception
     */
    @Test
    public void verifyConvertersLoaded() throws Exception {
        
        List<Converter> converters = cs.getAllConverters();        
        assertEquals(13, converters.size());
        for (int i = 0; i < converters.size(); i++) {
            assertEquals("Converter" + (i+1), converters.get(i).getName());            
        }
        
    }
    
    /**
     * Verify that converters can be found by their name
     * 
     * @throws Exception
     */
    @Test
    public void verifyFindConverterByName() throws Exception {
        
        assertNotNull(cs.getConverterByName("Converter1"));
        assertEquals("Converter1", cs.getConverterByName("Converter1").getName());        
        assertNull(cs.getConverterByName("Converter0"));        
        
    }

    /**
     * Verify that converters can be found according to their mime types
     * 
     * @throws Exception
     */
    @Test
    public void verifyFindConverterMimeType() throws Exception {
        
        assertEquals("Converter1", cs.findConverter("application/foo", "application/bar"));        
        assertNull( cs.findConverter("application/foo", "application/bar2"));        
        assertEquals("Converter4", cs.findConverter("application/bar", "application/fiz"));        
        assertEquals("Converter5", cs.findConverter("application/unknown", "application/fiz"));

    }
    
    /**
     * Verify that simple converter chains can be computed
     * 
     * @throws Exception
     */
    @Test
    public void verifySimpleChainedConverter() throws Exception {
        
        // simple converters
        assertEquals("Converter1", cs.computeConverterChain("application/foo", "application/bar").get(0));        
        assertNull( cs.computeConverterChain("application/foo", "application/bar2"));
        assertEquals("Converter4", cs.computeConverterChain("application/bar", "application/fiz").get(0));

        // chained converter
        List<String> converters = cs.computeConverterChain("text/plain", "application/bar");
        assertNotNull(converters);
        assertEquals("Converter3", converters.get(0));
        assertEquals("Converter1", converters.get(1));        

        // chained converter smallest chain first
        converters = cs.computeConverterChain("application/A", "application/C");
        assertNotNull(converters);
        assertEquals(1, converters.size());
        assertEquals("Converter8", converters.get(0));
        
    }
    
    /**
     * Build more complex converters chains !
     * 
     * @throws Exception
     */
    @Test
    public void verifyComplexChainedConverter() throws Exception {                
        
        // cheapest chain first and smallest chain first
        List<String>  converters = cs.computeConverterChain("application/A", "application/D1");
        assertNotNull(converters);
        assertEquals(2, converters.size());
        assertEquals("Converter6", converters.get(0));
        assertEquals("Converter10", converters.get(1));
        
        // chained converter with Cost Sorting         
        converters = cs.computeConverterChain("application/A", "application/E");
        assertNotNull(converters);
        assertEquals(3, converters.size());
        assertEquals("Converter6", converters.get(0));
        assertEquals("Converter10", converters.get(1));
        assertEquals("Converter12", converters.get(2));
               
    }

}
