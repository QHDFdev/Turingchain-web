
package com.tulingchain.soap.schema.write;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Who complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Who">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="original" type="{soap_rpc.models}WhoItem" minOccurs="0"/>
 *         &lt;element name="goto" type="{soap_rpc.models}WhoItem" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Who", propOrder = {
    "original",
    "_goto"
})
public class Who {

    @XmlElementRef(name = "original", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<WhoItem> original;
    @XmlElementRef(name = "goto", namespace = "soap_rpc.models", type = JAXBElement.class, required = false)
    protected JAXBElement<WhoItem> _goto;

    /**
     * Gets the value of the original property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WhoItem }{@code >}
     *     
     */
    public JAXBElement<WhoItem> getOriginal() {
        return original;
    }

    /**
     * Sets the value of the original property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WhoItem }{@code >}
     *     
     */
    public void setOriginal(JAXBElement<WhoItem> value) {
        this.original = value;
    }

    /**
     * Gets the value of the goto property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WhoItem }{@code >}
     *     
     */
    public JAXBElement<WhoItem> getGoto() {
        return _goto;
    }

    /**
     * Sets the value of the goto property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WhoItem }{@code >}
     *     
     */
    public void setGoto(JAXBElement<WhoItem> value) {
        this._goto = value;
    }

}
