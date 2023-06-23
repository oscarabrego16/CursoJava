
package sv.edu.formas.S5Servicios.filtro;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "filtroCors", urlPatterns = {"/*"})
public class filtroCors implements Filter {
    
    
    public filtroCors() {
    }    
    

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse resp =(HttpServletResponse) response;
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.addHeader("Access-Control-Allow-Headers", "*");
        resp.addHeader("Access-Control-Allow-Methods", "*");
        chain.doFilter(request, response);
    }

    
}
