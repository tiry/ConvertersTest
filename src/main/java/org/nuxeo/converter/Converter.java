package org.nuxeo.converter;

/**
 * Interface for a Converter
 *
 * @author tiry
 */
public interface Converter extends Comparable<Converter> {

    /**
     * Returns the name of the converter.
     */
    String getName();

    /**
     * Returns the input mime type.
     */
    String getInputType();

    /**
     * Returns the output mime type.
     */
    String getOutputType();

    /**
     * Returns the cost associated to the converter.
     */
    Integer getCost();

    /**
     * Check mimetypes compatibility (i.e. check wild cards).
     *
     * @param mimeType
     * @return true of the mimeType value can be used as input of the target Converter
     */
    boolean matchInput(String mimeType);

}
