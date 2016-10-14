
package com.tulingchain.soap.schema.write;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BigBlock complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BigBlock">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="votes" type="{soap_rpc.models}VoteArray" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="block_number" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/>
 *         &lt;element name="block" type="{soap_rpc.models}Block" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BigBlock", propOrder = {
    "id",
    "votes",
    "signature",
    "blockNumber",
    "block"
})
public class BigBlock {

    @XmlElementRef(name = "id", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> id;
    @XmlElementRef(name = "votes", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<VoteArray> votes;
    @XmlElementRef(name = "signature", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signature;
    @XmlElementRef(name = "block_number", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<BigInteger> blockNumber;
    @XmlElementRef(name = "block", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<Block> block;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setId(JAXBElement<String> value) {
        this.id = value;
    }

    /**
     * Gets the value of the votes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VoteArray }{@code >}
     *     
     */
    public JAXBElement<VoteArray> getVotes() {
        return votes;
    }

    /**
     * Sets the value of the votes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VoteArray }{@code >}
     *     
     */
    public void setVotes(JAXBElement<VoteArray> value) {
        this.votes = value;
    }

    /**
     * Gets the value of the signature property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSignature() {
        return signature;
    }

    /**
     * Sets the value of the signature property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSignature(JAXBElement<String> value) {
        this.signature = value;
    }

    /**
     * Gets the value of the blockNumber property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public JAXBElement<BigInteger> getBlockNumber() {
        return blockNumber;
    }

    /**
     * Sets the value of the blockNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     *     
     */
    public void setBlockNumber(JAXBElement<BigInteger> value) {
        this.blockNumber = value;
    }

    /**
     * Gets the value of the block property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Block }{@code >}
     *     
     */
    public JAXBElement<Block> getBlock() {
        return block;
    }

    /**
     * Sets the value of the block property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Block }{@code >}
     *     
     */
    public void setBlock(JAXBElement<Block> value) {
        this.block = value;
    }

}
