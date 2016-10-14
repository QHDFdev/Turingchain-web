
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for get_block_by_tx_idResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="get_block_by_tx_idResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="get_block_by_tx_idResult" type="{soap_rpc.models}BigBlock" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "get_block_by_tx_idResponse", namespace = "com.examples.rpc", propOrder = {
    "getBlockByTxIdResult"
})
public class GetBlockByTxIdResponse {

    @XmlElementRef(name = "get_block_by_tx_idResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<BigBlock> getBlockByTxIdResult;

    /**
     * Gets the value of the getBlockByTxIdResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link BigBlock }{@code >}
     *     
     */
    public JAXBElement<BigBlock> getGetBlockByTxIdResult() {
        return getBlockByTxIdResult;
    }

    /**
     * Sets the value of the getBlockByTxIdResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link BigBlock }{@code >}
     *     
     */
    public void setGetBlockByTxIdResult(JAXBElement<BigBlock> value) {
        this.getBlockByTxIdResult = value;
    }

}
