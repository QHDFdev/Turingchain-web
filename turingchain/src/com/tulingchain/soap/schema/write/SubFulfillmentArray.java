
package com.tulingchain.soap.schema.write;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SubFulfillmentArray complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SubFulfillmentArray">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SubFulfillment" type="{soap_rpc.models}SubFulfillment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SubFulfillmentArray", propOrder = {
    "subFulfillment"
})
public class SubFulfillmentArray {

    @XmlElement(name = "SubFulfillment", nillable = true)
    protected List<SubFulfillment> subFulfillment;

    /**
     * Gets the value of the subFulfillment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subFulfillment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubFulfillment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SubFulfillment }
     * 
     * 
     */
    public List<SubFulfillment> getSubFulfillment() {
        if (subFulfillment == null) {
            subFulfillment = new ArrayList<SubFulfillment>();
        }
        return this.subFulfillment;
    }

}
