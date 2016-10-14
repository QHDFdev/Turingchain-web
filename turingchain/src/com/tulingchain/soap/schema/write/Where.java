
package com.tulingchain.soap.schema.write;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Where complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Where">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="original" type="{soap_rpc.models}WhereItem" minOccurs="0"/>
 *         &lt;element name="goto" type="{soap_rpc.models}WhereItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Where", propOrder = {
    "original",
    "_goto"
})
public class Where {

    @XmlElementRef(name = "original", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<WhereItem> original;
    @XmlElementRef(name = "goto", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<WhereItem> _goto;

    /**
     * Gets the value of the original property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WhereItem }{@code >}
     *     
     */
    public JAXBElement<WhereItem> getOriginal() {
        return original;
    }

    /**
     * Sets the value of the original property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WhereItem }{@code >}
     *     
     */
    public void setOriginal(JAXBElement<WhereItem> value) {
        this.original = value;
    }

    /**
     * Gets the value of the goto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WhereItem }{@code >}
     *     
     */
    public JAXBElement<WhereItem> getGoto() {
        return _goto;
    }

    /**
     * Sets the value of the goto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WhereItem }{@code >}
     *     
     */
    public void setGoto(JAXBElement<WhereItem> value) {
        this._goto = value;
    }

}
