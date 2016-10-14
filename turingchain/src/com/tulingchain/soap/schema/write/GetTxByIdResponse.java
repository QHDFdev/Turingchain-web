
package com.tulingchain.soap.schema.write;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_tx_by_idResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_tx_by_idResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_tx_by_idResult" type="{soap_rpc.models}Data" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_tx_by_idResponse", namespace = "com.examples.rpc", propOrder = {
    "getTxByIdResult"
})
public class GetTxByIdResponse {

    @XmlElementRef(name = "get_tx_by_idResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<Data> getTxByIdResult;

    /**
     * Gets the value of the getTxByIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Data }{@code >}
     *     
     */
    public JAXBElement<Data> getGetTxByIdResult() {
        return getTxByIdResult;
    }

    /**
     * Sets the value of the getTxByIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Data }{@code >}
     *     
     */
    public void setGetTxByIdResult(JAXBElement<Data> value) {
        this.getTxByIdResult = value;
    }

}
