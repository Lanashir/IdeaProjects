package service.BCS;

import service.Utilities.SoapNamespaceHandlerResolver;
import service.fico.CheckApplicantForComplianceOMReqACSResponse;

import javax.annotation.Resource;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

/**
 * Created by agosipov on 09.12.2016.
 */
@WebService(endpointInterface = "service.BCS.CheckApplicantForComplianceOMReqACS")
@Addressing
public class CheckApplicantForComplianceOMReqACSImpl implements CheckApplicantForComplianceOMReqACS{

    @Resource
    WebServiceContext wContext;

    @Override
    @WebMethod (action = "http://omentrylibrary/com/om/CheckApplicantForComplianceOMReqACS/invokePH3Request")
    @Oneway
    public void checkApplicantForCompliance(@WebParam(name = "InvokePH3", targetNamespace = "http://omentrylibrary/com/om", partName = "om")InvokePH3 invokePH3Parameters) {
        String request = "";
        try{
            request = Files.lines(Paths.get("response.xml"))
                    .parallel()
                    .map(String::trim)
                    .filter(line -> line.length() > 2)
                    .collect(Collectors.joining());
        }catch(IOException e){
            e.printStackTrace();
        }
        request = request.replace("{APPID}", invokePH3Parameters.getParams().getCreditApplicationId());

        service.fico.InvokePH3Response response = new service.fico.InvokePH3Response();
        service.fico.InvokeRequestParameters params = new service.fico.InvokeRequestParameters();
        service.fico.AdditionalParameters parameters = new service.fico.AdditionalParameters();
        params.setAction(invokePH3Parameters.getParams().getAction());
        params.setCreditApplicationId(invokePH3Parameters.getParams().getCreditApplicationId());
        String UserXml = "<UserContext><userUUID>5D52AD779C33C55BE040AAAA18305895</userUUID><tenantID>FI_BASE_TENANT</tenantID></UserContext>";
        //params.setUserContextXml("<![CDATA[" + UserXml + "]]>");
        //params.setCreditApplicationXml("<![CDATA[" + request + "]]>");
        params.setUserContextXml(UserXml);
        params.setCreditApplicationXml(request);

        parameters.setValue(invokePH3Parameters.getParams().getAdditionalParams().getValue());
        parameters.setKey(invokePH3Parameters.getParams().getAdditionalParams().getKey());
        params.setAdditionalParams(parameters);
        response.setParams(params);

        //CheckApplicantForComplianceOMReqACS serv = new CheckApplicantForComplianceOMReqACS();

        /*CheckApplicantForComplianceOMReqACSResponseExportCheckApplicantForComplianceOMReqACSResponseHttpService service = new CheckApplicantForComplianceOMReqACSResponseExportCheckApplicantForComplianceOMReqACSResponseHttpService();
        CheckApplicantForComplianceOMReqACSResponse req = service.getCheckApplicantForComplianceOMReqACSResponseExportCheckApplicantForComplianceOMReqACSResponseHttpPort();
        service.setHandlerResolver(new SoapNamespaceHandlerResolver());
        req.checkApplicantForCompliance(response);*/
        /*try {
            JAXBContext jc = JAXBContext.newInstance(service.fico.InvokePH3Response.class);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(response, System.out);
        }catch(JAXBException e){
            e.printStackTrace();
        }*/

        try {
            URL url = new URL("http://localhost:1986/services/FICO?wsdl");
            QName qname = new QName("http://fico.service/", "CheckApplicantForComplianceOMReqACSResponseImplService");
            QName qname_port = new QName("http://fico.service/", "CheckApplicantForComplianceOMReqACSResponseImplPort");
            Service service = Service.create(url, qname);
            service.setHandlerResolver(new SoapNamespaceHandlerResolver());
            JAXBContext jc = JAXBContext.newInstance(service.fico.InvokePH3Response.class);
            //Dispatch<Object> disp = service.createDispatch(qname_port, jc, Service.Mode.PAYLOAD);
            //CheckApplicantForComplianceOMReqACSResponse conf = (CheckApplicantForComplianceOMReqACSResponse)disp.invoke(response);
            CheckApplicantForComplianceOMReqACSResponse req = service.getPort(CheckApplicantForComplianceOMReqACSResponse.class);
            req.checkApplicantForCompliance(response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
