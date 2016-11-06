package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class CharsetFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
    	
    	System.out.println("doFilter().encoding : " + encoding);
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }

        response.setContentType("text/xml; charset=utf-8");
        response.setCharacterEncoding("utf-8");
        
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
	    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	    
	    httpServletRequest.setAttribute("Content-Type", "text/xml; charset=utf-8");

//	    httpServletRequest.addHeader("Content-Type", "text/xml; charset=utf-8");
	    
	    httpServletResponse.addHeader("Content-Type", "text/xml; charset=utf-8");
	    httpServletResponse.addHeader("Content-Type2", "text/xml; charset=utf-8");
	    System.out.println("doFilter().encoding : Done,,,");
	    
        next.doFilter(request, response);
    }

    public void destroy() {
    }
}