package in.spring.SpringSecuirty.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class CustomSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    private Logger  logger = LoggerFactory.getLogger(CustomSuccessHandler.class);



    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
            System.out.println(authentication.getDetails());
            System.out.println(authentication.getPrincipal());
            System.out.println(authentication.getName());
            logger.info(authentication.getDetails()+"");
            logger.info(authentication.getPrincipal()+"");
            logger.info(authentication.getName()+"");
           redirectStrategy.sendRedirect(request,response,"/hello");
        }
    }

