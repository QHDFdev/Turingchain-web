
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transfer_transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transfer_transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tx_originator_public_key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tx_recipient_public_key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tx_originator_private_key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="who" type="{soap_rpc.models}Who" minOccurs="0"/>
 *         &lt;element name="where" type="{soap_rpc.models}Where" minOccurs="0"/>
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
@XmlType(name = "transfer_transaction", namespace = "com.examples.rpc", propOrder = {
    "txOriginatorPublicKey",
    "txRecipientPublicKey",
    "txOriginatorPrivateKey",
    "who",
    "where",
    "when",
    "thing"
})
public class TransferTransaction {

    @XmlElementRef(name = "tx_originator_public_key", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<String> txOriginatorPublicKey;
    @XmlElementRef(name = "tx_recipient_public_key", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<String> txRecipientPublicKey;
    @XmlElementRef(name = "tx_originator_private_key", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<String> txOriginatorPrivateKey;
    @XmlElementRef(name = "who", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<Who> who;
    @XmlElementRef(name = "where", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<Where> where;
    @XmlElementRef(name = "when", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<When> when;
    @XmlElementRef(name = "thing", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<Thing> thing;

    /**
     * Gets the value of the txOriginatorPublicKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTxOriginatorPublicKey() {
        return txOriginatorPublicKey;
    }

    /**
     * Sets the value of the txOriginatorPublicKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTxOriginatorPublicKey(JAXBElement<String> value) {
        this.txOriginatorPublicKey = value;
    }

    /**
     * Gets the value of the txRecipientPublicKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTxRecipientPublicKey() {
        return txRecipientPublicKey;
    }

    /**
     * Sets the value of the txRecipientPublicKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTxRecipientPublicKey(JAXBElement<String> value) {
        this.txRecipientPublicKey = value;
    }

    /**
     * Gets the value of the txOriginatorPrivateKey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTxOriginatorPrivateKey() {
        return txOriginatorPrivateKey;
    }

    /**
     * Sets the value of the txOriginatorPrivateKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTxOriginatorPrivateKey(JAXBElement<String> value) {
        this.txOriginatorPrivateKey = value;
    }

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
