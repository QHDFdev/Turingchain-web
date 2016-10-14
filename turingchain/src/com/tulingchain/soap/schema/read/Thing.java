
package com.tulingchain.soap.schema.read;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Thing complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Thing">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thing_type_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thing_type_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thing_order_quantity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thing_order_batch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thing_id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="origin_place" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="thing_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Thing", propOrder = {
    "price",
    "thingTypeId",
    "thingTypeName",
    "thingOrderQuantity",
    "thingOrderBatch",
    "thingId",
    "originPlace",
    "thingName"
})
public class Thing {

    @XmlElementRef(name = "price", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> price;
    @XmlElementRef(name = "thing_type_id", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thingTypeId;
    @XmlElementRef(name = "thing_type_name", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thingTypeName;
    @XmlElementRef(name = "thing_order_quantity", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thingOrderQuantity;
    @XmlElementRef(name = "thing_order_batch", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thingOrderBatch;
    @XmlElementRef(name = "thing_id", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thingId;
    @XmlElementRef(name = "origin_place", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> originPlace;
    @XmlElementRef(name = "thing_name", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<String> thingName;

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrice(JAXBElement<String> value) {
        this.price = value;
    }

    /**
     * Gets the value of the thingTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThingTypeId() {
        return thingTypeId;
    }

    /**
     * Sets the value of the thingTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThingTypeId(JAXBElement<String> value) {
        this.thingTypeId = value;
    }

    /**
     * Gets the value of the thingTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThingTypeName() {
        return thingTypeName;
    }

    /**
     * Sets the value of the thingTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThingTypeName(JAXBElement<String> value) {
        this.thingTypeName = value;
    }

    /**
     * Gets the value of the thingOrderQuantity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThingOrderQuantity() {
        return thingOrderQuantity;
    }

    /**
     * Sets the value of the thingOrderQuantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThingOrderQuantity(JAXBElement<String> value) {
        this.thingOrderQuantity = value;
    }

    /**
     * Gets the value of the thingOrderBatch property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThingOrderBatch() {
        return thingOrderBatch;
    }

    /**
     * Sets the value of the thingOrderBatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThingOrderBatch(JAXBElement<String> value) {
        this.thingOrderBatch = value;
    }

    /**
     * Gets the value of the thingId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThingId() {
        return thingId;
    }

    /**
     * Sets the value of the thingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThingId(JAXBElement<String> value) {
        this.thingId = value;
    }

    /**
     * Gets the value of the originPlace property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOriginPlace() {
        return originPlace;
    }

    /**
     * Sets the value of the originPlace property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOriginPlace(JAXBElement<String> value) {
        this.originPlace = value;
    }

    /**
     * Gets the value of the thingName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getThingName() {
        return thingName;
    }

    /**
     * Sets the value of the thingName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setThingName(JAXBElement<String> value) {
        this.thingName = value;
    }

}
