
package service.fico;

import javax.xml.bind.annotation.*;


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
@XmlRootElement(name = "invokePH3Response", namespace = "http://omentrylibrary/com/om")
public class InvokePH3Response {

    @XmlElement(required = true, nillable = true)
    InvokeRequestParameters params;

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
