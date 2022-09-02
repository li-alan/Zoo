// package com.example.zoo;

// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// @EnableWebSecurity
// public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  

//     @Override
//     protected void configure(HttpSecurity http) throws Exception {
//         http
//                 .authorizeRequests()
//                 .anyRequest()
//                 .authenticated()
//                 .and()
//                 .httpBasic();

//         http.csrf().disable();
//     }
// }
package com.example.zoo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;
import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails zookeeper = User
                .withUsername("zookeeper")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("zookeeper")
                .roles("ZOOKEEPER")
                .build();
        UserDetails manager = User
                .withUsername("manager")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("manager")
                .roles("MANAGER")
                .build();
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(zookeeper);
        userDetailsManager.createUser(manager);
        return userDetailsManager;
    }


    
  

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(c->c.disable())
            .authorizeHttpRequests((auth) -> {
            auth.antMatchers("/*").authenticated();
            auth.antMatchers("/api/animal", "/api/zookeeper", "/api/assignments").permitAll();
           // auth.antMatchers("/zookeeper/*").hasAnyRole("ZOOKEEPER","MANAGER");
           // auth.antMatchers("/api/animal/manager/*").hasRole("MANAGER");
            auth.antMatchers("/api/animal/manager/**",
             "/api/zookeeper/manager/**", "/api/assignments/manager/**" ).hasRole("MANAGER");
            

        })
        .httpBasic(withDefaults());
            
        return http.build();
    }

}


