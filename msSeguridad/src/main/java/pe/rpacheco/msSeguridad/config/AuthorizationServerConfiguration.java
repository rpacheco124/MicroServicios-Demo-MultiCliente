package pe.rpacheco.msSeguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private JwtAccessTokenConverter accessTokenConverter;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private UserApprovalHandler userApprovalHandler;
	
	/*
	 * @Override public void configure(ClientDetailsServiceConfigurer configurer)
	 * throws Exception { configurer.jdbc(jdbcTemplate.getDataSource()); }
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory().withClient("rpacheco").secret(passwordEncoder.encode("rpacheco")).resourceIds("service")
				.authorizedGrantTypes("password").authorities("CLIENT").scopes("read");

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).accessTokenConverter(accessTokenConverter)
		.userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager).userDetailsService(userDetailsService);
	}

	@Override
	public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
		oauthServer.allowFormAuthenticationForClients().tokenKeyAccess("isAuthenticated()")
				.checkTokenAccess("isAuthenticated()");
	}

	/*
	 * @Bean public JwtAccessTokenConverter tokenConverter() {
	 * JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	 * converter.setSigningKey("1234567890"); return converter; }
	 * 
	 * @Bean public TokenStore tokenStore(JwtAccessTokenConverter tokenConverter) {
	 * return new JwtTokenStore(tokenConverter); }
	 * 
	 * @Bean DefaultTokenServices tokenServices(TokenStore tokenStore,
	 * JwtAccessTokenConverter tokenConverter) { DefaultTokenServices tokenServices
	 * = new DefaultTokenServices(); tokenServices.setTokenStore(tokenStore);
	 * tokenServices.setTokenEnhancer(tokenConverter); return tokenServices; }
	 * 
	 * @Bean public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore
	 * tokenStore, ClientDetailsService clientDetailsService) {
	 * TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
	 * handler.setTokenStore(tokenStore); handler.setRequestFactory(new
	 * DefaultOAuth2RequestFactory(clientDetailsService));
	 * handler.setClientDetailsService(clientDetailsService); return handler; }
	 * 
	 * @Bean public ApprovalStore approvalStore(TokenStore tokenStore) throws
	 * Exception { TokenApprovalStore store = new TokenApprovalStore();
	 * store.setTokenStore(tokenStore); return store; }
	 * 
	 * @Override public void configure(AuthorizationServerSecurityConfigurer
	 * security) throws Exception {
	 * security.allowFormAuthenticationForClients().tokenKeyAccess(
	 * "isAuthenticated()").checkTokenAccess("isAuthenticated()"); }
	 * 
	 * @Override public void configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) throws Exception { //endpoints.tokenServices(tokenServices);
	 * TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
	 * tokenEnhancerChain.setTokenEnhancers( Arrays.asList(tokenEnhancer(),
	 * tokenConverter()));
	 * 
	 * endpoints.tokenStore(tokenStore(tokenConverter()))
	 * .tokenEnhancer(tokenEnhancerChain)
	 * .authenticationManager(authenticationManager)
	 * .userDetailsService(userDetailsServiceImpl); }
	 * 
	 * @Bean public TokenEnhancer tokenEnhancer() { return new
	 * CustomTokenEnhancer(); }
	 * 
	 * @Override public void configure(ClientDetailsServiceConfigurer clients)
	 * throws Exception { clients.inMemory().withClient("rpacheco")
	 * .secret("{noop}rpacheco") .resourceIds("service")
	 * .authorizedGrantTypes("client_credentials") .authorities("CLIENT")
	 * .scopes("read");
	 * 
	 * }
	 */
}
