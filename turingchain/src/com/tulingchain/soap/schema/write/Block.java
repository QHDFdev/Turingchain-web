
package com.tulingchain.soap.schema.write;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Block complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Block">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voters" type="{com.examples.rpc}stringArray" minOccurs="0"/>
 *         &lt;element name="node_pubkey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transactions" type="{soap_rpc.models}TransactionArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Block", propOrder = {
    "timestamp",
    "voters",
    "nodePubkey",
    "transactions"
})
public class Block {

    @XmlElementRef(name = "timestamp", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> timestamp;
    @XmlElementRef(name = "voters", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<StringArray> voters;
    @XmlElementRef(name = "node_pubkey", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodePubkey;
    @XmlElementRef(name = "transactions", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<TransactionArray> transactions;

    /**
     * Gets the value of the timestamp property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the value of the timestamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTimestamp(JAXBElement<String> value) {
        this.timestamp = value;
    }

    /**
     * Gets the value of the voters property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public JAXBElement<StringArray> getVoters() {
        return voters;
    }

    /**
     * Sets the value of the voters property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public void setVoters(JAXBElement<StringArray> value) {
        this.voters = value;
    }

    /**
     * Gets the value of the nodePubkey property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodePubkey() {
        return nodePubkey;
    }

    /**
     * Sets the value of the nodePubkey property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodePubkey(JAXBElement<String> value) {
        this.nodePubkey = value;
    }

    /**
     * Gets the value of the transactions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}
     *     
     */
    public JAXBElement<TransactionArray> getTransactions() {
        return transactions;
    }

    /**
     * Sets the value of the transactions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}
     *     
     */
    public void setTransactions(JAXBElement<TransactionArray> value) {
        this.transactions = value;
    }

}
