package filters;


import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class MutableServeletRequest extends HttpServletRequestWrapper {
    
	 // holds custom header and value mapping
    private final Map<String, String> customHeaders;
    private String contentType;
 
    public MutableServeletRequest(HttpServletRequest request){
        super(request);
        this.customHeaders = new HashMap<String, String>();
        System.out.println("MutableServeletRequest(). : Initialized!");
    }
    
    public void putHeader(String name, String value){
    	System.out.println("putHeader()."+name+" : " + value);
    	if("content-type".equalsIgnoreCase(name))contentType = value;
        this.customHeaders.put(name, value);
    }
    
    public String getContentType() {
		return contentType;
	}
 
    public String getHeader(String name) {
        // check the custom headers first
        String headerValue = customHeaders.get(name);
        
        if (headerValue != null){
        	System.out.println("getHeader().this "+name+" : " + headerValue);
            return headerValue;
        }
        // else return from into the original wrapped object
        System.out.println("getHeader().super "+name+" : " + headerValue);
        return ((HttpServletRequest) getRequest()).getHeader(name);
    }
 
    public Enumeration<String> getHeaderNames() {
        // create a set of the custom header names
        Set<String> set = new HashSet<String>(customHeaders.keySet());
        
        // now add the headers from the wrapped request object
        @SuppressWarnings("unchecked")
        Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
        while (e.hasMoreElements()) {
            // add the names of the request headers into the list
            String n = e.nextElement();
            System.out.println("getHeaderNames() In : " + n);
            set.add(n);
        }
 
        Enumeration<String> eFinal = Collections.enumeration(set);
        while (eFinal.hasMoreElements()) {
            // add the names of the request headers into the list
            String n = eFinal.nextElement();
            System.out.println("getHeaderNames() Out : " + n);
        }
        
        // create an enumeration from the set and return
        return eFinal;
    }

}
