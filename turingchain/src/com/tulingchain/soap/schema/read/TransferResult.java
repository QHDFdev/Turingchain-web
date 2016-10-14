
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransferResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransferResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="txs" type="{soap_rpc.models}TxPair" minOccurs="0"/>
 *         &lt;element name="new_key_pair" type="{soap_rpc.models}KeyPair" minOccurs="0"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransferResult", propOrder = {
    "txs",
    "newKeyPair",
    "message"
})
public class TransferResult {

    @XmlElementRef(name = "txs", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<TxPair> txs;
    @XmlElementRef(name = "new_key_pair", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<KeyPair> newKeyPair;
    @XmlElementRef(name = "message", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> message;

    /**
     * Gets the value of the txs property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TxPair }{@code >}
     *     
     */
    public JAXBElement<TxPair> getTxs() {
        return txs;
    }

    /**
     * Sets the value of the txs property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TxPair }{@code >}
     *     
     */
    public void setTxs(JAXBElement<TxPair> value) {
        this.txs = value;
    }

    /**
     * Gets the value of the newKeyPair property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link KeyPair }{@code >}
     *     
     */
    public JAXBElement<KeyPair> getNewKeyPair() {
        return newKeyPair;
    }

    /**
     * Sets the value of the newKeyPair property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link KeyPair }{@code >}
     *     
     */
    public void setNewKeyPair(JAXBElement<KeyPair> value) {
        this.newKeyPair = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessage(JAXBElement<String> value) {
        this.message = value;
    }

}
