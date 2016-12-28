
package omentrylibrary.workflow.apm.fiom.dms.fairisaac.com;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InvokeResponseParameters complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InvokeResponseParameters">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creditApplicationId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="creditApplicationXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userContextXml" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="additionalParams" type="{http://com.fairisaac.dms.fiom.apm.workflow.omentrylibrary}AdditionalParameters" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="action" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="workflowName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InvokeResponseParameters", propOrder = {
    "creditApplicationId",
    "creditApplicationXml",
    "userContextXml",
    "additionalParams",
    "action",
    "workflowName"
})
public class InvokeResponseParameters {

    protected String creditApplicationId;
    protected String creditApplicationXml;
    protected String userContextXml;
    protected AdditionalParameters additionalParams;
    protected String action;
    protected String workflowName;

    /**
     * Gets the value of the creditApplicationId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditApplicationId() {
        return creditApplicationId;
    }

    /**
     * Sets the value of the creditApplicationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditApplicationId(String value) {
        this.creditApplicationId = value;
    }

    /**
     * Gets the value of the creditApplicationXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditApplicationXml() {
        return creditApplicationXml;
    }

    /**
     * Sets the value of the creditApplicationXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditApplicationXml(String value) {
        this.creditApplicationXml = value;
    }

    /**
     * Gets the value of the userContextXml property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserContextXml() {
        return userContextXml;
    }

    /**
     * Sets the value of the userContextXml property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserContextXml(String value) {
        this.userContextXml = value;
    }

    /**
     * Gets the value of the additionalParams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the additionalParams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAdditionalParams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AdditionalParameters }
     * 
     * 
     */
    public void setAdditionalParams(AdditionalParameters additionalParams) {
        this.additionalParams = additionalParams;
    }


    public AdditionalParameters getAdditionalParams() {
        return this.additionalParams;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the workflowName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowName() {
        return workflowName;
    }

    /**
     * Sets the value of the workflowName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowName(String value) {
        this.workflowName = value;
    }

}
