
package com.tulingchain.soap.schema.write;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_txs_by_block_addrResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_txs_by_block_addrResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_txs_by_block_addrResult" type="{soap_rpc.models}TransactionArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_txs_by_block_addrResponse", namespace = "com.examples.rpc", propOrder = {
    "getTxsByBlockAddrResult"
})
public class GetTxsByBlockAddrResponse {

    @XmlElementRef(name = "get_txs_by_block_addrResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<TransactionArray> getTxsByBlockAddrResult;

    /**
     * Gets the value of the getTxsByBlockAddrResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}
     *     
     */
    public JAXBElement<TransactionArray> getGetTxsByBlockAddrResult() {
        return getTxsByBlockAddrResult;
    }

    /**
     * Sets the value of the getTxsByBlockAddrResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TransactionArray }{@code >}
     *     
     */
    public void setGetTxsByBlockAddrResult(JAXBElement<TransactionArray> value) {
        this.getTxsByBlockAddrResult = value;
    }

}
