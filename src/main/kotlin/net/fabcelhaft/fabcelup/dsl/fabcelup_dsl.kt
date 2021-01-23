package net.fabcelhaft.fabcelup.dsl

import net.fabcelhaft.fabcelup.model.*
import javax.security.auth.kerberos.EncryptionKey

open class GlobalPropertiesBuilder{
    var packaging: String = "tar.gz"
    var encryptionKey: String = "changeme"
    var dateFormat : String = ""

    open fun build(): Map<String, String>{
        return mapOf(
            Pair("packaging", packaging),
            Pair("encryptionKey", encryptionKey),
            Pair("dateFormat", dateFormat)
        )
    }
}

class PropertiesBuilder : GlobalPropertiesBuilder() {
    lateinit var id: String
    var description: String = ""
    // TODO schauen, wie man dafür sorgt die zu unsetten von oben...

    override fun build(): Map<String, String>{
        val map = mapOf(
            Pair("id", id),
            Pair("description", description),
        )

        val mapGlobal = super.build()
        return map + mapGlobal
    }
}

class BackupBuilder {
    fun build(): Backup {
        TODO()
    }

    fun properties(initalizer: PropertiesBuilder.() -> Unit): PropertiesBuilder{
        return PropertiesBuilder().apply(initalizer)
    }

    fun input(initalizer: InputBuilder.() -> Unit): InputBuilder{
        return InputBuilder().apply(initalizer)
    }
    fun output(initalizer: OutputBuilder.() -> Unit): OutputBuilder{
        return OutputBuilder().apply(initalizer)
    }
}


class InputBuilder {
    fun filesystem(path: String) : FilesystemInput {
       TODO()
    }
    fun webdav(url: String, user: String, password: String, path: String) : FilesystemInput {
        TODO()
    }

    fun mysql(host: String, username: String, password: String, database: String): MySQLInput{ //TODO optional scheme
        TODO()
    }

    fun postgres(host: String, username: String, password: String, database: String): PostgresInput{ //TODO optional scheme
        TODO()
    }

}

class OutputBuilder {
    fun filesystem(path: String) : FilesystemOutput {
        TODO()
    }
    fun onedrive(token: String, path: String) : OnedriveOutput{
        TODO()
    }
    fun callback_url() : CallbackURLOutput{
        TODO()
    }
}


fun properties(initalizer: GlobalPropertiesBuilder.() -> Unit): GlobalPropertiesBuilder{
    return GlobalPropertiesBuilder().apply(initalizer)
}

fun backup(initalizer: BackupBuilder.() -> Unit): BackupBuilder{
    return BackupBuilder().apply(initalizer)
}