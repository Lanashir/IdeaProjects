
package omentrylibrary.com.om;

import omentrylibrary.workflow.apm.fiom.dms.fairisaac.com.InvokeResponseParameters;

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
 *         &lt;element name="params" type="{http://com.fairisaac.dms.fiom.apm.workflow.omentrylibrary}InvokeResponseParameters"/>
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
@XmlRootElement(name = "invokePH3Response")
public class InvokePH3Response {

    @XmlElement(required = true, nillable = true)

    protected InvokeResponseParameters params;

    /**
     * Gets the value of the params property.
     * 
     * @return
     *     possible object is
     *     {@link InvokeResponseParameters }
     *     
     */
    public InvokeResponseParameters getParams() {
        return params;
    }

    /**
     * Sets the value of the params property.
     * 
     * @param value
     *     allowed object is
     *     {@link InvokeResponseParameters }
     *     
     */
    public void setParams(InvokeResponseParameters value) {
        this.params = value;
    }

}
