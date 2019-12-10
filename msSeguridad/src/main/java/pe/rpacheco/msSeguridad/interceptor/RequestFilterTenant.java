package pe.rpacheco.msSeguridad.interceptor;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import pe.rpacheco.msSeguridad.multitentenantconfig.TenantContext;

@Component
@Order(1)
public class RequestFilterTenant extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		System.out.println("In preHandle we are Intercepting the Request");
		System.out.println("____________________________________________");
		String requestURI = req.getRequestURI();
		String tenantID = req.getHeader("X-TenantID");
		System.out.println("RequestURI::" + requestURI + " || Search for X-TenantID  :: " + tenantID);
		if (tenantID == null) {
			res.getWriter().write("X-TenantID not present in the Request Header");
			res.setStatus(400);
		}
		TenantContext.setCurrentTenant(tenantID);
		System.out.println("____________________REGISTRADO CORRECTAMENTE!!!________________________");

		chain.doFilter(request, response);
	}

}
