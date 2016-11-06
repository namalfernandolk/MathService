package intermediator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.axis2.AxisFault;
import org.apache.axis2.Constants;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.context.OperationContext;
import org.apache.axis2.engine.Handler;
import org.apache.axis2.engine.Handler.InvocationResponse;
import org.apache.axis2.handlers.AbstractHandler;
import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.axis2.wsdl.WSDLConstants;
import org.apache.commons.httpclient.Header;

public class MessageIntermediator extends AbstractHandler implements Handler {

	public InvocationResponse invoke(MessageContext msgContext) throws AxisFault {

		System.out.println("invoke(). : MessageIntermediator !!!");

		String 				invokeStr 					= null;
		String 				AxisService 				= null;
		String 				Action						= null;

		try{

			try {
				invokeStr = msgContext.getEnvelope().toString();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				invokeStr = "UnknownInvokeStr";
			}

			System.out.println("invoke().invokeStr : " + invokeStr);

			try {
				AxisService 				= msgContext.getAxisService().getName();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				AxisService = "UnknownAxisService";
			}
			System.out.println("invoke().AxisService : " + AxisService);

			try {
				Action						= msgContext.getAxisMessage().getAxisOperation().getInputAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				Action = "UnknownAction";
			}
			System.out.println("invoke().Action : " + Action);

			OperationContext operationContext = msgContext.getOperationContext();

			System.out.println("invoke().msgContext.getAxisMessage().getDirection() : " + msgContext.getAxisMessage().getDirection());

			System.out.println("invoke().operationContext.getProperties() : " + operationContext.getProperties());
			System.out.println("invoke().msgContext.getCurrentMessageContext().getProperties() : " + MessageContext.getCurrentMessageContext().getProperties());
			System.out.println("invoke().msgContext.getProperties() : " + msgContext.getProperties());
			msgContext.setProperty("Content-Type", "text/xml; charset=utf-8");
			System.out.println("invoke().msgContext.getProperties() : " + msgContext.getProperties());
			try
			{
				System.out.println("invoke(). : Setting MessageContext Value...");
				msgContext.setProperty(Constants.Configuration.CHARACTER_SET_ENCODING, "utf-8");
				
				System.out.println("invoke(). : Setting ContentType Value...");
				msgContext.setProperty(Constants.Configuration.CONTENT_TYPE, "text/xml; charset=utf-8");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}


		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return InvocationResponse.CONTINUE;        
	}

}
