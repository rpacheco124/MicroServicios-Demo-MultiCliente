package pe.rpacheco.msPersonas.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.stereotype.Component;

import pe.rpacheco.msPersonas.multitentenantconfig.TenantContext;


@Component
@Order(1)
public class RequestFilterTenant implements Filter {

	private final static String TOKEN_TYPE = "Bearer ";
	private final static String TENANT_SCHEMA_ID_CLAIMS = "Tenant-Schema-Id";
	private final static String HEADER_AUTHORIZATION = "Authorization";

	@Autowired
	private JwtTokenStore tokenStore;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String authorization = req.getHeader(HEADER_AUTHORIZATION);
		if (authorization == null) {
			res.setStatus(400);
		}

		OAuth2Authentication auth = tokenStore.readAuthentication(authorization.replace(TOKEN_TYPE, ""));
		@SuppressWarnings("unchecked")
		Map<String, Object> details = (Map<String, Object>) auth.getDetails();

		if (!details.containsKey(TENANT_SCHEMA_ID_CLAIMS)) {
			res.setStatus(400);
		}

		TenantContext.setCurrentTenant(details.get(TENANT_SCHEMA_ID_CLAIMS).toString());

		chain.doFilter(request, response);
	}

}
