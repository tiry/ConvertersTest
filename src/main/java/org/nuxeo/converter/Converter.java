package org.nuxeo.converter;

/**
 * Interface for a Converter
 * 
 * @author tiry
 *
 */
public interface Converter extends Comparable<Converter> {

    /**
     * Returns the name of the converter
     * 
     * @return
     */
    String getName();

    /**
     * Return the input mime type
     * 
     * @return
     */
    String getInputType();

    /**
     * Return the output mime type
     * 
     * @return
     */
    String getOutputType();

    /**
     * Return the cost associated to the converter
     * 
     * @return
     */
    Integer getCost();

    /**
     * Check mimetypes compatibility (i.e. check wild cards)
     * 
     * @param mimeType
     * @return true of the mimeType value can be used as input of the target
     *         Converter
     */
    boolean matchInput(String mimeType);

}
