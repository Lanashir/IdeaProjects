package service.Utilities;

import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.PortInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agosipov on 09.12.2016.
 */
public class SoapNamespaceHandlerResolver implements HandlerResolver {
    @SuppressWarnings({ "rawtypes" })
    @Override
    public List<Handler> getHandlerChain(PortInfo portInfo) {
        List<Handler> handlerChain = new ArrayList<>();
        Handler handler = new SoapNamespaceHandler();
        String bindingID = portInfo.getBindingID();
        if (bindingID.equals("http://schemas.xmlsoap.org/wsdl/soap/http")) {
            handlerChain.add(handler);
        } else if (bindingID.equals("http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")) {
            handlerChain.add(handler);
        }
        return handlerChain;
    }
}
