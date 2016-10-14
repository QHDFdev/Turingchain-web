
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transfer_transactionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transfer_transactionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="transfer_transactionResult" type="{soap_rpc.models}TransferResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transfer_transactionResponse", namespace = "com.examples.rpc", propOrder = {
    "transferTransactionResult"
})
public class TransferTransactionResponse {

    @XmlElementRef(name = "transfer_transactionResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<TransferResult> transferTransactionResult;

    /**
     * Gets the value of the transferTransactionResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TransferResult }{@code >}
     *     
     */
    public JAXBElement<TransferResult> getTransferTransactionResult() {
        return transferTransactionResult;
    }

    /**
     * Sets the value of the transferTransactionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TransferResult }{@code >}
     *     
     */
    public void setTransferTransactionResult(JAXBElement<TransferResult> value) {
        this.transferTransactionResult = value;
    }

}
