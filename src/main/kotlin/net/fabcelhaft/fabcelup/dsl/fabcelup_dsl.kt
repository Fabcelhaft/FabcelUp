package net.fabcelhaft.fabcelup.dsl

import net.fabcelhaft.fabcelup.input.FileSystemConfig
import net.fabcelhaft.fabcelup.input.WebDAVConfig
import net.fabcelhaft.fabcelup.model.FabcelUpConfig
import net.fabcelhaft.fabcelup.output.OneDriveOutputConfig
import net.fabcelhaft.fabcelup.output.UrlOutputConfig

@DslMarker
annotation class FabcelUpDsl

@FabcelUpDsl
class FabcelUpConfigBuilder {
    val config = FabcelUpConfig()

    fun in_filesystem(path: String){
        config.inputs.add(FileSystemConfig(path))
    }

    fun in_webdav(path: String, username: String, password: String){
        config.inputs.add(WebDAVConfig(path, username, password))
    }

    fun out_url(){
        config.outputs.add(UrlOutputConfig())
    }

    fun out_onedrive(token: String){
        config.outputs.add(OneDriveOutputConfig(token))
    }
}

object config {
    operator fun invoke(setup: FabcelUpConfigBuilder.() -> Unit): FabcelUpConfig{
        val builder = FabcelUpConfigBuilder()
        builder.setup()
        return builder.config
    }
}


fun main(){
    val secrets = mapOf(Pair("Kerstin", "Fabi"), Pair("Kikkirej", "geheimes Passwort"))
    val config = config {
        in_filesystem("/mnt/")
        in_webdav(".", "Kikkirej", "${secrets["Kikkirej"]}")
    }
    println(config)
}