
package com.tulingchain.soap.schema.write;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Vote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Vote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="node_pubkey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vote" type="{soap_rpc.models}VoteDetail" minOccurs="0"/>
 *         &lt;element name="signature" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Vote", propOrder = {
    "nodePubkey",
    "vote",
    "signature"
})
public class Vote {

    @XmlElementRef(name = "node_pubkey", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodePubkey;
    @XmlElementRef(name = "vote", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<VoteDetail> vote;
    @XmlElementRef(name = "signature", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signature;

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
     * Gets the value of the vote property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link VoteDetail }{@code >}
     *     
     */
    public JAXBElement<VoteDetail> getVote() {
        return vote;
    }

    /**
     * Sets the value of the vote property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link VoteDetail }{@code >}
     *     
     */
    public void setVote(JAXBElement<VoteDetail> value) {
        this.vote = value;
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

}
