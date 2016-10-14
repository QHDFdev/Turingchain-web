
package com.tulingchain.soap.schema.read;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Condition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Condition">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="condition" type="{soap_rpc.models}ConditionDetail" minOccurs="0"/>
 *         &lt;element name="new_owners" type="{com.examples.rpc}stringArray" minOccurs="0"/>
 *         &lt;element name="cid" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Condition", propOrder = {
    "condition",
    "newOwners",
    "cid"
})
public class Condition {

    @XmlElementRef(name = "condition", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionDetail> condition;
    @XmlElementRef(name = "new_owners", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<StringArray> newOwners;
    @XmlElementRef(name = "cid", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> cid;

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionDetail }{@code >}
     *     
     */
    public JAXBElement<ConditionDetail> getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionDetail }{@code >}
     *     
     */
    public void setCondition(JAXBElement<ConditionDetail> value) {
        this.condition = value;
    }

    /**
     * Gets the value of the newOwners property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public JAXBElement<StringArray> getNewOwners() {
        return newOwners;
    }

    /**
     * Sets the value of the newOwners property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public void setNewOwners(JAXBElement<StringArray> value) {
        this.newOwners = value;
    }

    /**
     * Gets the value of the cid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getCid() {
        return cid;
    }

    /**
     * Sets the value of the cid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setCid(JAXBElement<BigInteger> value) {
        this.cid = value;
    }

}
