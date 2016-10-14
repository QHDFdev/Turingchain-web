
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for trace_transactionsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="trace_transactionsResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="trace_transactionsResult" type="{com.examples.rpc}stringArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "trace_transactionsResponse", namespace = "com.examples.rpc", propOrder = {
    "traceTransactionsResult"
})
public class TraceTransactionsResponse {

    @XmlElementRef(name = "trace_transactionsResult", namespace = "com.examples.rpc", type = JAXBElement.class, required = false)
    protected JAXBElement<StringArray> traceTransactionsResult;

    /**
     * Gets the value of the traceTransactionsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public JAXBElement<StringArray> getTraceTransactionsResult() {
        return traceTransactionsResult;
    }

    /**
     * Sets the value of the traceTransactionsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link StringArray }{@code >}
     *     
     */
    public void setTraceTransactionsResult(JAXBElement<StringArray> value) {
        this.traceTransactionsResult = value;
    }

}
