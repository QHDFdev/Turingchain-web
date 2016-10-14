
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VoteDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VoteDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="invalid_reason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="previous_block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="voting_for_block" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="is_block_valid" type="{com.examples.rpc}is_block_valid" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VoteDetail", propOrder = {
    "invalidReason",
    "timestamp",
    "previousBlock",
    "votingForBlock",
    "isBlockValid"
})
public class VoteDetail {

    @XmlElementRef(name = "invalid_reason", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> invalidReason;
    @XmlElementRef(name = "timestamp", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> timestamp;
    @XmlElementRef(name = "previous_block", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> previousBlock;
    @XmlElementRef(name = "voting_for_block", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> votingForBlock;
    @XmlElementRef(name = "is_block_valid", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<IsBlockValid> isBlockValid;

    /**
     * Gets the value of the invalidReason property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInvalidReason() {
        return invalidReason;
    }

    /**
     * Sets the value of the invalidReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInvalidReason(JAXBElement<String> value) {
        this.invalidReason = value;
    }

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
     * Gets the value of the previousBlock property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPreviousBlock() {
        return previousBlock;
    }

    /**
     * Sets the value of the previousBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPreviousBlock(JAXBElement<String> value) {
        this.previousBlock = value;
    }

    /**
     * Gets the value of the votingForBlock property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVotingForBlock() {
        return votingForBlock;
    }

    /**
     * Sets the value of the votingForBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVotingForBlock(JAXBElement<String> value) {
        this.votingForBlock = value;
    }

    /**
     * Gets the value of the isBlockValid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link IsBlockValid }{@code >}
     *     
     */
    public JAXBElement<IsBlockValid> getIsBlockValid() {
        return isBlockValid;
    }

    /**
     * Sets the value of the isBlockValid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link IsBlockValid }{@code >}
     *     
     */
    public void setIsBlockValid(JAXBElement<IsBlockValid> value) {
        this.isBlockValid = value;
    }

}
