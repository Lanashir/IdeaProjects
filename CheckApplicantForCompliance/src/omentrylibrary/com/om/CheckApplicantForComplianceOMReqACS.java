
package omentrylibrary.com.om;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CheckApplicantForComplianceOMReqACS", targetNamespace = "http://omentrylibrary/com/om")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    omentrylibrary.com.om.ObjectFactory.class,
    omentrylibrary.workflow.apm.fiom.dms.fairisaac.com.ObjectFactory.class
})
public interface CheckApplicantForComplianceOMReqACS{


    /**
     * 
     * @param invokePH3Parameters
     */
    @WebMethod(operationName = "invokePH3Request", action = "http://omentrylibrary/com/om/CheckApplicantForComplianceOMReqACS/invokePH3Request")
    @Oneway
    void invokePH3Request(
            @WebParam(name = "invokePH3", targetNamespace = "http://omentrylibrary/com/om", partName = "invokePH3Parameters")
                    InvokePH3 invokePH3Parameters);

}
