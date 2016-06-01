package org.nuxeo.converter;

import java.io.File;
import java.util.List;

/**
 * Interface for the fake Conversion service
 *
 * @author tiry
 */
public interface ConverterService {

    /**
     * Loads the converters from a file containing the definition.
     * <p>
     * Input file has the following format:
     * <ul>
     * <li>Each line is a converter</li>
     * <li>Each line is composed of 4 blocks separated by a space</li>
     * <ul>
     * <li>Name (can not contain space)</li>
     * <li>Input mime type</li>
     * <li>Output mime type</li>
     * <li>Cost (an integer)</li>
     * </ul>
     * </ul>
     *
     * @param convertersDefinitions
     * @return the list of all loaded converters
     * @throws Exception
     */
    List<Converter> loadConvertersFromFile(File convertersDefinitions) throws Exception;

    /**
     * Returns all converters.
     *
     * @return
     */
    List<Converter> getAllConverters();

    /**
     * Find a converter by it's name.
     * <p>
     * If several converters have the same name, result is implementation dependent.
     *
     * @param name the name of the converter to retrieve
     * @return the {@link Converter}
     */
    Converter getConverterByName(String name);

    /**
     * Finds the converter that match both input and output mime type.
     * <p>
     * Mime types can contain wildcards, so for example, the converter accepting text/* as input can be used with
     * text/plain or text/html.
     * <p>
     * If several converters match, the implementation should return the cheapest converter
     * <p>
     *
     * @param input the source input MimeType
     * @param output the target input MimeType
     * @return the name of the converter that match the requirements.
     */
    String findConverter(String input, String output);

    /**
     * When no built-in converter exists, a chain can be defined to go from the source MimeType to the target MimeType.
     * <p>
     * The implementation should return (in order of preference):
     * <ul>
     * <li>a single converter if available</li>
     * <li>the shortest chain (if several chains are possible)</li>
     * <li>the cheapest chain (if several chains with the same size are available)</li>
     * </ul>
     *
     * @param input the source MimeType
     * @param output the target MimeType
     * @return the list of converters forming a chain
     */
    List<String> computeConverterChain(String input, String output);

}
