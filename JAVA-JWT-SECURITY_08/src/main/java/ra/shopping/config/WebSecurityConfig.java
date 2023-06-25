package ra.shopping.config;

import org.springframework.security.config.BeanIds;
//import ra.shopping.security.jwt.JwtEntryPoint;
import ra.shopping.security.jwt.JwtTokenFilter;
import ra.shopping.security.userprinciple.CustomerUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CustomerUserDetailService customerUserDetailService;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customerUserDetailService) // cung cap customerServicer cho spring security
                .passwordEncoder(passwordEncoder()); // cung cap password cho encoder
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        // ma hoa mk luu trong CSDL
        return new BCryptPasswordEncoder();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors()// ngan chan request tu mot domain khac
                .and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/**").permitAll() // cho phep tat ca moi nguoi vao dia chi nay
                .anyRequest().authenticated();// tat ca cac request khac du can phai xac thuc moi duoc truy cap
        // them lop filter kiem tra JWT
        httpSecurity.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
