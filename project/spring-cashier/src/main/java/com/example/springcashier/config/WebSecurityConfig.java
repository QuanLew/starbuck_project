package com.example.config;

import com.example.login.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
//
//    /*
//
//        Autoconfiguring Spring Security
//
//        REF:  Securing Spring | Spring in Action, Sixth Edition
//
//        What does this barebones security configuration do for you? Not much, actually.
//        The main thing it does is declare a PasswordEncoder bean, which we’ll use both
//        when creating new users and when authenticating users at login.
//
//        In this case, we’re using BCryptPasswordEncoder, one of a handful of password
//        encoders provided by Spring Security, including the following:
//
//            * BCryptPasswordEncoder—Applies bcrypt strong hashing encryption
//            * NoOpPasswordEncoder—Applies no encoding
//            * Pbkdf2PasswordEncoder—Applies PBKDF2 encryption
//            * SCryptPasswordEncoder—Applies Scrypt hashing encryption
//            * StandardPasswordEncoder—Applies SHA-256 hashing encryption
//
//
//    */
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    /*
//
//        * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/in-memory.html
//        * https://docs.spring.io/spring-boot/docs/current/reference/html/cli.html
//
//        Spring Security’s InMemoryUserDetailsManager implements UserDetailsService to provide
//        support for username/password based authentication that is stored in memory.
//        InMemoryUserDetailsManager provides management of UserDetails by implementing
//        the UserDetailsManager interface. UserDetails based authentication is used by
//        Spring Security when it is configured to accept a username/password for authentication.
//
//        In this sample we use Spring Boot CLI to encode the password of password and get the
//        encoded password of {bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW.
//
//        Spring Boot CLI:  spring encodepassword password
//        Alternatively:  https://bcrypt.online/
//
//     */
//    @Bean
//    public UserDetailsService users() {
//        UserDetails user = User.builder()
//                .username("user")
//                .password("$2y$10$HfdK56jb5Ut1fBpZq/lkFuPqiKdMOZBJ8H96.fx6dyYrEkI8dmPD6")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
//
//
//    /*
//        References:
//            * https://docs.spring.io/spring-security/reference/servlet/authentication/passwords/form.html
//            * https://stackoverflow.com/questions/41373588/spring-security-configuration-for-post-request
//            * https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
//     */
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        //http.csrf().ignoringAntMatchers("/h2-console/**");
//        http.headers().frameOptions().sameOrigin();
//        http.headers().defaultsDisabled() ; // do not use any default headers unless explicitly listed
//        http.headers().disable(); // disable headers security
//        SecurityFilterChain ret = http
//                .formLogin(
//                        form -> form
//                                .loginPage("/login")
//                                .permitAll()
//                )
//                .authorizeRequests()
//                .antMatchers("/").hasRole("USER")
//                .antMatchers("/h2-console/**").permitAll()
//                .antMatchers("/").permitAll()
//                .and()
//                .build();
//        return ret;
//    }


    @Autowired
    private CustomLoginSucessHandler sucessHandler;

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // URL matching for accessibility
                .antMatchers("/", "/about", "/auth/login.css", "/login", "/register", "/h2-console/**").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
                .antMatchers("/user/**").hasAnyAuthority("USER")
                .anyRequest().authenticated()
                .and()
                // form login
                .csrf().disable().formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .successHandler(sucessHandler)
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                // logout
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

        http.authenticationProvider(authenticationProvider());
        http.headers().frameOptions().sameOrigin();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
    }

}

