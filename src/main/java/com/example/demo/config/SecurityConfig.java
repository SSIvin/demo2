package com.example.demo.config;


import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//отменяет security из коробки и все зависит от нас, но чтобы не писать все с нуля
//можно использовать адаптеры и переопределить некоторые методы
@EnableWebSecurity
//что это файл конфигурации
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .headers().disable()
                .headers().cacheControl().disable()
                .and()
                .csrf().disable()
                .authorizeRequests() //мы хотим авторизовать запросы
                .anyRequest().authenticated() //все остальные будут требовать авторизации

                .and() //добавляем форму логина
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .permitAll() //форма регистрации разрешены для всех

                .and() //добавляем logout.  и говорим что он разрешен для всех
                .logout()//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                //.logoutSuccessUrl("/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and();
//                .sessionManagement();
//                .maximumSessions(1);
                //.maxSessionsPreventsLogin(true);
    }

    @Autowired
    private UserService userService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

//мы вклиниваемся в авторизацию спринга и даем ему userService.
    //userService делаем выборку пользователя иот куда нам надо

    @Autowired
    public void configGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder());
        //        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("password")
//                .roles("USER");
    }


}
