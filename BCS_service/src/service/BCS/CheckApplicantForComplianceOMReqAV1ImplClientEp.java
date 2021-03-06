
package service.BCS;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CheckApplicantForComplianceOMReqAV1Impl_client_ep", targetNamespace = "http://omentrylibrary/com/om", wsdlLocation = "http://k6-usbs-f-app01.vtb24.ru:8001/soa-infra/services/om/CheckApplicantForComplianceOMReqAV1/CheckApplicantForComplianceOMReqAV1Impl_client_ep?wsdl")
public class CheckApplicantForComplianceOMReqAV1ImplClientEp
    extends Service
{

    private final static URL CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_WSDL_LOCATION;
    private final static WebServiceException CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_EXCEPTION;
    private final static QName CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_QNAME = new QName("http://omentrylibrary/com/om", "CheckApplicantForComplianceOMReqAV1Impl_client_ep");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://k6-usbs-f-app01.vtb24.ru:8001/soa-infra/services/om/CheckApplicantForComplianceOMReqAV1/CheckApplicantForComplianceOMReqAV1Impl_client_ep?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_WSDL_LOCATION = url;
        CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_EXCEPTION = e;
    }

    public CheckApplicantForComplianceOMReqAV1ImplClientEp() {
        super(__getWsdlLocation(), CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_QNAME);
    }

    public CheckApplicantForComplianceOMReqAV1ImplClientEp(WebServiceFeature... features) {
        super(__getWsdlLocation(), CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_QNAME, features);
    }

    public CheckApplicantForComplianceOMReqAV1ImplClientEp(URL wsdlLocation) {
        super(wsdlLocation, CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_QNAME);
    }

    public CheckApplicantForComplianceOMReqAV1ImplClientEp(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_QNAME, features);
    }

    public CheckApplicantForComplianceOMReqAV1ImplClientEp(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CheckApplicantForComplianceOMReqAV1ImplClientEp(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CheckApplicantForComplianceOMReqACS
     */
    @WebEndpoint(name = "CheckApplicantForComplianceOMReqACS_pt")
    public CheckApplicantForComplianceOMReqACS getCheckApplicantForComplianceOMReqACSPt() {
        return super.getPort(new QName("http://omentrylibrary/com/om", "CheckApplicantForComplianceOMReqACS_pt"), CheckApplicantForComplianceOMReqACS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CheckApplicantForComplianceOMReqACS
     */
    @WebEndpoint(name = "CheckApplicantForComplianceOMReqACS_pt")
    public CheckApplicantForComplianceOMReqACS getCheckApplicantForComplianceOMReqACSPt(WebServiceFeature... features) {
        return super.getPort(new QName("http://omentrylibrary/com/om", "CheckApplicantForComplianceOMReqACS_pt"), CheckApplicantForComplianceOMReqACS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_EXCEPTION!= null) {
            throw CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_EXCEPTION;
        }
        return CHECKAPPLICANTFORCOMPLIANCEOMREQAV1IMPLCLIENTEP_WSDL_LOCATION;
    }

}
