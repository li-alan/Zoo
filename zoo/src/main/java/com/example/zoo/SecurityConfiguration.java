package com.example.zoo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

/**
 * This java file is a securit configuration that allows users of
 * two levels to use our zoo management system. The most basic user level
 * will be zookeepers who only have access to viewing their job assignments
 * and the various animals that are currently in the zoo. Managers will be 
 * able to Create, remove, update, delete both employees and animals.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    /**
     * Adding Roles:
     * In memory user store for multiple users: zookeeper and manager
     * Zookeepers will be granted the role of zookeeper while
     * managers will be granted the role of manager (admin)
     * @return new users created with the fields we have entered
     */
    @Bean
    public UserDetailsService userDetailsService() {
        //Creating the role of "ZOOKEEPER" (Basic user level access)
        UserDetails zookeeper = User
                .withUsername("zookeeper")
                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder()::encode)
                .password("zookeeper")
                .roles("ZOOKEEPER")
                .build();
        //Creating the role of "MANAGER" (will be used for Admin level access))
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

    /**
     * Configuring the api according to the roles we have created.
     * Managers will be able to acces any point in the api while
     * zookeepers will not be able to use access points with 
     * "manager" in its field
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(c->c.disable())
            .authorizeHttpRequests((auth) -> {
            //makes sure that user has to log in before accessing our zoo management system
            auth.antMatchers("/*").authenticated();
            //give basic level access to all users regardless of role
            auth.antMatchers("/api/animal", "/api/zookeeper", "/api/assignments").permitAll();
            //give manager level access points only to users who have the role "MANAGER"
            auth.antMatchers("/api/animal/manager/**",
             "/api/zookeeper/manager/**", "/api/assignments/manager/**" ).hasRole("MANAGER");
            
        })
        .httpBasic(withDefaults());        
        return http.build();
    }

}

