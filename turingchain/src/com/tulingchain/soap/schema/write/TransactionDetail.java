
package com.tulingchain.soap.schema.write;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TransactionDetail complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TransactionDetail">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="timestamp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fulfillments" type="{soap_rpc.models}FulfillmentArray" minOccurs="0"/>
 *         &lt;element name="operation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="data" type="{soap_rpc.models}Data" minOccurs="0"/>
 *         &lt;element name="conditions" type="{soap_rpc.models}ConditionArray" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TransactionDetail", propOrder = {
    "timestamp",
    "fulfillments",
    "operation",
    "data",
    "conditions"
})
public class TransactionDetail {

    @XmlElementRef(name = "timestamp", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> timestamp;
    @XmlElementRef(name = "fulfillments", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<FulfillmentArray> fulfillments;
    @XmlElementRef(name = "operation", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> operation;
    @XmlElementRef(name = "data", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<Data> data;
    @XmlElementRef(name = "conditions", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<ConditionArray> conditions;

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
     * Gets the value of the fulfillments property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link FulfillmentArray }{@code >}
     *     
     */
    public JAXBElement<FulfillmentArray> getFulfillments() {
        return fulfillments;
    }

    /**
     * Sets the value of the fulfillments property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link FulfillmentArray }{@code >}
     *     
     */
    public void setFulfillments(JAXBElement<FulfillmentArray> value) {
        this.fulfillments = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOperation() {
        return operation;
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOperation(JAXBElement<String> value) {
        this.operation = value;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Data }{@code >}
     *     
     */
    public JAXBElement<Data> getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Data }{@code >}
     *     
     */
    public void setData(JAXBElement<Data> value) {
        this.data = value;
    }

    /**
     * Gets the value of the conditions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ConditionArray }{@code >}
     *     
     */
    public JAXBElement<ConditionArray> getConditions() {
        return conditions;
    }

    /**
     * Sets the value of the conditions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ConditionArray }{@code >}
     *     
     */
    public void setConditions(JAXBElement<ConditionArray> value) {
        this.conditions = value;
    }

}
