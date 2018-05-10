package com.sf.operation.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter{

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManagerBean;
	@Bean
	TokenStore tokenStore(){
		return new InMemoryTokenStore();
	}
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
		.tokenStore(tokenStore())
		.authenticationManager(authenticationManagerBean);
	}
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
				clients.inMemory()
				.withClient("SbfAPIAdmin")
				.secret("3dcc1b09-8477-4d3c-b3af-3b00d7be2aa6")
				.scopes("app", "register", "accountinfo", "repayment", "read", "write")
				.authorities("ROLE_TRUSTED_CLIENT")
				.authorizedGrantTypes("password", "refresh_token")
				.accessTokenValiditySeconds(120)
				.refreshTokenValiditySeconds(15*60)
			.and()
				.withClient("client-a")
				.secret("secret")
				.scopes("read")
				.authorities("ROLE_CLIENT_A")
				.authorizedGrantTypes("authorization_code", "client_credentials", "password", "refresh_token")
				.redirectUris("http://localhost:8282/client")
				.accessTokenValiditySeconds(120)
				.refreshTokenValiditySeconds(15*60)
			;
				
	}
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security
			//.checkTokenAccess("permitAll()");
			.checkTokenAccess("isAuthenticated()");
		//security.tokenKeyAccess("")
	}
}
