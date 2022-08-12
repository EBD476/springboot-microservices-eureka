package com.rad.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
// @EnableWebSecurity
public class WebSecurityConfig {

    AuthenticationManager authenticationManager;
    
    // @Autowired 
    // private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        
        http.httpBasic().disable();
        return http.build();
    }

    // @Bean
    // public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        // authenticationManagerBuilder.userDetailsService(userDetailsService);
        // authenticationManager = authenticationManagerBuilder.build();

        // http
        //     // .csrf().disable().cors().disable()
        //     .csrf().disable()
        //     .authorizeRequests()
        //         .antMatchers("/login*", "/logout*", "/signin/**", "/signup/**", "/customLogin",
        //                 "/user/registration*", "/registrationConfirm*", "/expiredAccount*", "/registration*",
        //                 "/badUser*", "/user/resendRegistrationToken*" ,"/forgetPassword*", "/user/resetPassword*","/user/savePassword*","/updatePassword*",
        //                 "/user/changePassword*", "/emailError*", "/resources/**","/old/user/registration*","/successRegister*","/qrcode*","/user/enableNewLoc*").permitAll()
        //         .antMatchers("/invalidSession*").anonymous()
        //         .antMatchers("/user/updatePassword*").hasAuthority("CHANGE_PASSWORD_PRIVILEGE")
        //         .antMatchers("/api/v1/account/register", "/api/v1/account/auth").permitAll()
        //         .anyRequest().hasAuthority("READ_PRIVILEGE")

        //         .and()
        //         .formLogin()
        //             .loginPage("/login")
        //             // .defaultSuccessUrl("/homepage.html")
        //             // .failureUrl("/login?error=true")
        //             // .successHandler(myAuthenticationSuccessHandler)
        //             // .failureHandler(authenticationFailureHandler)
        //             // .authenticationDetailsSource(authenticationDetailsSource)
        //         .permitAll()
        //         .and()
        //         .httpBasic();




            // .authorizeHttpRequests()
            // .antMatchers("*").permitAll()
           
            // .anyRequest().authenticated()
            //  .and().formLogin().loginPage("/login");
            // .and()
            // .authenticationManager(authenticationManager)
            // .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    //     return http.build();
    // }

    // @Bean
    // public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    //     return authenticationConfiguration.getAuthenticationManager();
    // }
    
    // @Override
    // protected void configure(HttpSecurity http) throws Exception {

    //     //Cross origin resource sharing
    //     http.cors().and()
    //         .authorizeRequests()
    //         .antMatchers("/resources/**","/error" , "/service/**").permitAll()
    //         .anyRequest().fullyAuthenticated()
    //         .and()
    //         .logout().permitAll()
    //         .logoutRequestMatcher(new AntPathRequestMatcher("/service/logout","POST"))
    //         .and()
    //         .formLogin().loginPage("/service/login")
    //         .and()
    //         .httpBasic()
    //         .and()
    //         .csrf().disable();
    // }
}
