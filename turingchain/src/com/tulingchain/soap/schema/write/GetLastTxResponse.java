
package com.tulingchain.soap.schema.write;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_last_txResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_last_txResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_last_txResult" type="{soap_rpc.models}LastTx" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_last_txResponse", namespace = "com.examples.rpc", propOrder = {
    "getLastTxResult"
})
public class GetLastTxResponse {

    @XmlElementRef(name = "get_last_txResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<LastTx> getLastTxResult;

    /**
     * Gets the value of the getLastTxResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link LastTx }{@code >}
     *     
     */
    public JAXBElement<LastTx> getGetLastTxResult() {
        return getLastTxResult;
    }

    /**
     * Sets the value of the getLastTxResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link LastTx }{@code >}
     *     
     */
    public void setGetLastTxResult(JAXBElement<LastTx> value) {
        this.getLastTxResult = value;
    }

}
