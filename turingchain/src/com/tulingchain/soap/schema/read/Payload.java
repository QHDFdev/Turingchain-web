
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Payload complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Payload">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="who" type="{soap_rpc.models}Who" minOccurs="0"/>
 *         &lt;element name="where" type="{soap_rpc.models}Where" minOccurs="0"/>
 *         &lt;element name="previous_process_tx_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="when" type="{soap_rpc.models}When" minOccurs="0"/>
 *         &lt;element name="thing" type="{soap_rpc.models}Thing" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payload", propOrder = {
    "who",
    "where",
    "previousProcessTxId",
    "when",
    "thing"
})
public class Payload {

    @XmlElementRef(name = "who", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<Who> who;
    @XmlElementRef(name = "where", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<Where> where;
    @XmlElementRef(name = "previous_process_tx_id", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> previousProcessTxId;
    @XmlElementRef(name = "when", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<When> when;
    @XmlElementRef(name = "thing", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<Thing> thing;

    /**
     * Gets the value of the who property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Who }{@code >}
     *     
     */
    public JAXBElement<Who> getWho() {
        return who;
    }

    /**
     * Sets the value of the who property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Who }{@code >}
     *     
     */
    public void setWho(JAXBElement<Who> value) {
        this.who = value;
    }

    /**
     * Gets the value of the where property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Where }{@code >}
     *     
     */
    public JAXBElement<Where> getWhere() {
        return where;
    }

    /**
     * Sets the value of the where property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Where }{@code >}
     *     
     */
    public void setWhere(JAXBElement<Where> value) {
        this.where = value;
    }

    /**
     * Gets the value of the previousProcessTxId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreviousProcessTxId() {
        return previousProcessTxId;
    }

    /**
     * Sets the value of the previousProcessTxId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreviousProcessTxId(JAXBElement<String> value) {
        this.previousProcessTxId = value;
    }

    /**
     * Gets the value of the when property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link When }{@code >}
     *     
     */
    public JAXBElement<When> getWhen() {
        return when;
    }

    /**
     * Sets the value of the when property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link When }{@code >}
     *     
     */
    public void setWhen(JAXBElement<When> value) {
        this.when = value;
    }

    /**
     * Gets the value of the thing property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Thing }{@code >}
     *     
     */
    public JAXBElement<Thing> getThing() {
        return thing;
    }

    /**
     * Sets the value of the thing property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Thing }{@code >}
     *     
     */
    public void setThing(JAXBElement<Thing> value) {
        this.thing = value;
    }

}
