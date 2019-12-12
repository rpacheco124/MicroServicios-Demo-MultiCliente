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

		String tenantID = req.getHeader("Tenant-Schema-Id");
		if (tenantID == null) {
			res.setStatus(400);
		}
		
		TenantContext.setCurrentTenant(tenantID);

		chain.doFilter(request, response);
		
		TenantContext.clear();
	}
	
	

}
