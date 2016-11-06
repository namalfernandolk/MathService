package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class HeaderFilter implements Filter {

    private HashMap<String,String> rqCustomHeaders = new HashMap<String,String>();
    private HashMap<String,String> rsCustomHeaders = new HashMap<String,String>();

    public void init(FilterConfig config) throws ServletException {
    
        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
        	
			String initParameterName = initParameterNames.nextElement();
			
			if(initParameterName.startsWith("rq_"))
				rqCustomHeaders.put(initParameterName.replaceFirst("rq_", ""), config.getInitParameter(initParameterName));
			else
				rsCustomHeaders.put(initParameterName, config.getInitParameter(initParameterName));
			
		}
        
        System.out.println("init().rqCustomHeaders : " + rqCustomHeaders);
        System.out.println("init().rsCustomHeaders : " + rsCustomHeaders);
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
    	
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	    
		Enumeration<String> en = httpServletRequest.getHeaderNames();
		while (en.hasMoreElements()) {
			String n = en.nextElement();
			System.out.println("doFilter().Already set > "+n+" : "+httpServletRequest.getHeader(n));
		}

	    MutableServeletRequest mutableServeletRequest = new MutableServeletRequest((HttpServletRequest) request);
	    
	    for (Map.Entry<String, String> rqCustomHeaderEntry : rqCustomHeaders.entrySet()) {
	    	mutableServeletRequest.putHeader(rqCustomHeaderEntry.getKey(), rqCustomHeaderEntry.getValue());	
	    }

	    System.out.println("doFilter().Set Request Headers Done");
	    
	    for (Map.Entry<String, String> rsCustomHeaderEntry : rsCustomHeaders.entrySet()) {
	    	
	    	String key = rsCustomHeaderEntry.getKey();
	    	String value = rsCustomHeaderEntry.getValue();
	    	
	    	httpServletResponse.addHeader(key, value);
	    	
	    	if("content-type".equalsIgnoreCase(key))httpServletResponse.setContentType(value);
	    	
	    }
	    
	    System.out.println("doFilter()Set Response Headers Done");
	    
	    chain.doFilter(mutableServeletRequest, new HttpServletResponseWrapper(httpServletResponse) {
	        @Override
	        public void setContentType(final String type) {
	           System.out.println("setContentType().I will not set your content-type!");
	        }
	    });
	    System.out.println("doFilter().Servelet is invoked!");
	    
	    System.out.println("doFilter()MutableServeletRequest Done!!!");
	    
	    
    }

    public void destroy() {
    	
    	System.out.println("destroy(). : Destroy Called!");
    }
}