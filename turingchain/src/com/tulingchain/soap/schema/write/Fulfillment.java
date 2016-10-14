
package com.tulingchain.soap.schema.write;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Fulfillment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fulfillment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fid" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="current_owners" type="{com.examples.rpc}stringArray" minOccurs="0"/>
 *         &lt;element name="fulfillment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="input" type="{soap_rpc.models}Input" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fulfillment", propOrder = {
    "fid",
    "currentOwners",
    "fulfillment",
    "input"
})
public class Fulfillment {

    @XmlElementRef(name = "fid", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> fid;
    @XmlElementRef(name = "current_owners", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<StringArray> currentOwners;
    @XmlElementRef(name = "fulfillment", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> fulfillment;
    @XmlElementRef(name = "input", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<Input> input;

    /**
     * Gets the value of the fid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getFid() {
        return fid;
    }

    /**
     * Sets the value of the fid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setFid(JAXBElement<BigInteger> value) {
        this.fid = value;
    }

    /**
     * Gets the value of the currentOwners property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public JAXBElement<StringArray> getCurrentOwners() {
        return currentOwners;
    }

    /**
     * Sets the value of the currentOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public void setCurrentOwners(JAXBElement<StringArray> value) {
        this.currentOwners = value;
    }

    /**
     * Gets the value of the fulfillment property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getFulfillment() {
        return fulfillment;
    }

    /**
     * Sets the value of the fulfillment property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setFulfillment(JAXBElement<String> value) {
        this.fulfillment = value;
    }

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Input }{@code >}
     *     
     */
    public JAXBElement<Input> getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Input }{@code >}
     *     
     */
    public void setInput(JAXBElement<Input> value) {
        this.input = value;
    }

}
