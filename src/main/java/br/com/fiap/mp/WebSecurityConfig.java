package br.com.fiap.mp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private DataSource dataSource;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                .and()
                    .logout()
                        .permitAll();
        http.csrf().disable();
        return http.build();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        //Para definir usuários no banco com criptografia
        /*UserDetails user = User.builder()
                .username("lerolero")
                .password(encoder.encode("12345"))
                .roles("ADM")
                .build(); */
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder);
                //.withUser(user); //para criar o usuário no banco
    }

    /*
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("lerolero")
                .password("12345")
                .roles("ADM")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
    */
}
