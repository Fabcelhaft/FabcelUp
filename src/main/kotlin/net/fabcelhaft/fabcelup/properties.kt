package net.fabcelhaft.fabcelup

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "fabcelup")
class FabcelUpProperties(var configfile: String = "/conf/config.fabcelup.kts", )