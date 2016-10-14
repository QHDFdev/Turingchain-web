
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_last_blockResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_last_blockResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_last_blockResult" type="{soap_rpc.models}LastBlock" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_last_blockResponse", namespace = "com.examples.rpc", propOrder = {
    "getLastBlockResult"
})
public class GetLastBlockResponse {

    @XmlElementRef(name = "get_last_blockResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<LastBlock> getLastBlockResult;

    /**
     * Gets the value of the getLastBlockResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LastBlock }{@code >}
     *     
     */
    public JAXBElement<LastBlock> getGetLastBlockResult() {
        return getLastBlockResult;
    }

    /**
     * Sets the value of the getLastBlockResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LastBlock }{@code >}
     *     
     */
    public void setGetLastBlockResult(JAXBElement<LastBlock> value) {
        this.getLastBlockResult = value;
    }

}
