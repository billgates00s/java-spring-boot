package com.tma.bookmanagement.configs;

import com.tma.bookmanagement.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    //user inmemory
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        try{
//            auth.inMemoryAuthentication()
//                    .withUser("nhannguyen").password("{bcrypt}$2a$10$.Rx4Us0kwSuGa2nHmSTlqOTtzvswdjRLoJ1iU0xXJLOJ.jCs2KyLC").roles("USER")
//                    .and()
//                    .withUser("admin").password("{noop}password").roles("USER", "ADMIN");
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                    .antMatchers("/users").hasRole("USER")
//                    .antMatchers("/admins").hasRole("ADMIN")
//                    .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                    .loginProcessingUrl("/authenticateTheUser")
//                    .loginPage("/showLoginPage")
//
//                    .permitAll()
//                .and()
//                    .logout().permitAll()
//                .and()
//                    .exceptionHandling().accessDeniedPage("/access_denied");
//    }

    @Autowired
    private DataSource dataSource;
    private final UserDetailsServiceImpl userDetailsService;


    public WebSecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public static BCryptPasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();

        // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
        // Nếu chưa login, nó sẽ redirect tới trang /login.
        http.authorizeRequests().antMatchers("/userInfo","/book/book_list","/category/category_list").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        // Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/adminInfo","/admin/user_list","/role/list_role","/userRole/list_user_role").access("hasRole('ROLE_ADMIN')");

        http.authorizeRequests().antMatchers("/employee/employee_list").access("hasAnyRole('ROLE_ADMIN','ROLE_EMPLOYEE')");
        http.authorizeRequests().antMatchers("/student/student_list").access("hasAnyRole('ROLE_ADMIN','ROLE_STUDENT')");
        // Khi người dùng đã login, với vai trò XX.
        // Nhưng truy cập vào trang yêu cầu vai trò YY,
        // Ngoại lệ AccessDeniedException sẽ ném ra.
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/access_denied");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")// login
                .defaultSuccessUrl("/")//
                .failureUrl("/login?error=true")//
                .usernameParameter("username")//
                .passwordParameter("password")
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout");

        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(24 * 60 * 60); // 24h

    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
        db.setDataSource(dataSource);
        return db;
    }
}
