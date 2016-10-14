
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_key_pairResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_key_pairResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_key_pairResult" type="{soap_rpc.models}KeyPair" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_key_pairResponse", namespace = "com.examples.rpc", propOrder = {
    "getKeyPairResult"
})
public class GetKeyPairResponse {

    @XmlElementRef(name = "get_key_pairResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<KeyPair> getKeyPairResult;

    /**
     * Gets the value of the getKeyPairResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link KeyPair }{@code >}
     *     
     */
    public JAXBElement<KeyPair> getGetKeyPairResult() {
        return getKeyPairResult;
    }

    /**
     * Sets the value of the getKeyPairResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link KeyPair }{@code >}
     *     
     */
    public void setGetKeyPairResult(JAXBElement<KeyPair> value) {
        this.getKeyPairResult = value;
    }

}
