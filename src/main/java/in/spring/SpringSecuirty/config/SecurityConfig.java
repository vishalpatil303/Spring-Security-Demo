package in.spring.SpringSecuirty.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    private  CustomSuccessHandler customSuccessHandler;

    public SecurityConfig(CustomSuccessHandler customSuccessHandler) {
        this.customSuccessHandler = customSuccessHandler;
    }

    @Bean
    public SecurityFilterChain getSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {


        httpSecurity.csrf(csrf-> csrf.disable())
        .authorizeHttpRequests(request-> request.requestMatchers("/hello")
                                                                               .authenticated()
                                                                               .requestMatchers("/login","/error","/registerCustomer").permitAll() )
                    .formLogin(formLogin-> formLogin//.loginPage("/login")
                                                                          .successHandler(customSuccessHandler)
                                                                 //         .defaultSuccessUrl("/hello")
                            )
                    .httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }

//    @Bean
//    public UserDetailsService getUserDetails(){
//        UserDetails user = User.withUsername("vishal")
//                .password("{noop}1234").build();
//        return new InMemoryUserDetailsManager(user);
//    }

//    @Bean
//    public UserDetailsService getJdbcUserDetails(DataSource dataSource){
//        return new JdbcUserDetailsManager(dataSource);
//    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
