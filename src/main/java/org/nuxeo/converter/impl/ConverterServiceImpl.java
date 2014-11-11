package org.nuxeo.converter.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.nuxeo.converter.Converter;
import org.nuxeo.converter.ConverterService;

/**
 * 
 * This is where you should provide the implementation !
 * 
 * @author you
 *
 */
public class ConverterServiceImpl implements ConverterService {

    protected List<Converter> converters = new ArrayList<>();

    @Override
    public List<Converter> loadConvertersFromFile(File convertersDefinitions)
            throws Exception {
        throw new UnsupportedOperationException("Implement me !");
        
    }

    @Override
    public List<Converter> getAllConverters() {        
        throw new UnsupportedOperationException("Implement me !");    
    }

    @Override
    public String findConverter(String input, String output) {
        throw new UnsupportedOperationException("Implement me !");
    }

    @Override
    public Converter getConverterByName(String name) {
        throw new UnsupportedOperationException("Implement me !");
    }

    @Override
    public List<String> computeConverterChain(String input, String output) {
        throw new UnsupportedOperationException("Implement me !");
    }
}
