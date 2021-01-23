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
    var properties: Map<String, String> = mapOf()
    var inputs: List<Input> = listOf()
    var outputs: List<Output> = listOf()

    fun build(): Backup {
        val backup = Backup(properties, inputs, outputs)
        return backup
    }

    fun properties(initalizer: PropertiesBuilder.() -> Unit) {
        val propertiesBuilder = PropertiesBuilder().apply(initalizer)
        properties = propertiesBuilder.build()
    }

    fun input(initalizer: InputBuilder.() -> Unit) {
        val inputBuilder = InputBuilder().apply(initalizer)
        inputs = inputBuilder.getList()
    }

    fun output(initalizer: OutputBuilder.() -> Unit) {
        val outputBuilder = OutputBuilder().apply(initalizer)
        outputs = outputBuilder.getList()
    }
}


class InputBuilder {
    private val inputs : MutableList<Input> = mutableListOf();
    fun filesystem(path: String) {
        val filesystemInput = FilesystemInput(path)
        inputs.add(filesystemInput)
    }
    fun webdav(url: String, user: String, password: String, path: String) {
        val webDavInput = WebDavInput(url, user, password, path)
        inputs.add(webDavInput)
    }

    fun mysql(host: String, username: String, password: String, database: String) { //TODO optional scheme
        val mySQLInput = MySQLInput(host, username, password, database)
        inputs.add(mySQLInput)
    }

    fun postgres(host: String, username: String, password: String, database: String) { //TODO optional scheme
        val postgresInput = PostgresInput(host, username, password, database)
        inputs.add(postgresInput)
    }

    fun getList(): List<Input> {
        val list : List<Input> = inputs.toList()
        return list
    }
}

class OutputBuilder {
    private val outputs : MutableList<Output> = mutableListOf();

    fun filesystem(path: String) {
        val filesystemOutput = FilesystemOutput(path)
        outputs.add(filesystemOutput)
    }

    fun onedrive(token: String, path: String) {
        val onedriveOutput = OnedriveOutput(token, path)
        outputs.add(onedriveOutput)
    }

    fun callback_url() {
        val callbackURLOutput = CallbackURLOutput()
        outputs.add(callbackURLOutput)
    }

    fun getList(): List<Output> {
        val list : List<Output> = outputs.toList()
        return list
    }
}


fun properties(initalizer: GlobalPropertiesBuilder.() -> Unit): GlobalPropertiesBuilder{
    return GlobalPropertiesBuilder().apply(initalizer)
}

fun backup(initalizer: BackupBuilder.() -> Unit): BackupBuilder{
    return BackupBuilder().apply(initalizer)
}