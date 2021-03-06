
package service.fico;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="params" type="{http://com.fairisaac.dms.fiom.apm.workflow.omentrylibrary}InvokeRequestParameters"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "params"
})
@XmlRootElement(name = "invokePH3", namespace = "http://omentrylibrary/com/om")
public class InvokePH3 {

    @XmlElement(required = true, nillable = true)
    protected InvokeRequestParameters params;

    /**
     * Gets the value of the params property.
     * 
     * @return
     *     possible object is
     *     {@link InvokeRequestParameters }
     *     
     */
    public InvokeRequestParameters getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvokeRequestParameters }
     *     
     */
    public void setParams(InvokeRequestParameters value) {
        this.params = value;
    }

}
