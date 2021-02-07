package net.fabcelhaft.fabcelup.security

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke

@Configuration
@Profile("production", "prod")
class KotlinSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http {
            httpBasic {}
            authorizeRequests {
                authorize("/start/**", hasAuthority("ROLE_USER"))
                authorize("/download/**", hasAnyAuthority("ROLE_USER"))
                authorize("/**", denyAll)
            }
        }
    }
}
