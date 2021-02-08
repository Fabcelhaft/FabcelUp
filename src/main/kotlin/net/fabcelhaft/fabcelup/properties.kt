package net.fabcelhaft.fabcelup

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "fabcelup")
class FabcelUpProperties(var configfile: String = "conf/config.fabcelup.kts",
        var workingdir: String = "work/")

enum class FabcelUpPropertyKeys(val key: String){
        ID("id"),
        DESCRIPTION("description"),
        PACKAGING("packaging"),
        ENCRYPTION_KEY("encryptionKey"),
        DATE_FORMAT("dateFormat"),
}
