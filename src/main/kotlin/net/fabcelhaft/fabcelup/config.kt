package net.fabcelhaft.fabcelup

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "fabcelup")
class FabcelUpConfig(var configfile: String = "/conf/config.fabcelup.kts", )