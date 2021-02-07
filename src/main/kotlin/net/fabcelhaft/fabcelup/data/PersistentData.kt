package net.fabcelhaft.fabcelup.data

import de.swirtz.ktsrunner.objectloader.KtsObjectLoader
import net.fabcelhaft.fabcelup.FabcelUpProperties
import net.fabcelhaft.fabcelup.model.Backup
import net.fabcelhaft.fabcelup.model.BackupInformation
import net.fabcelhaft.fabcelup.model.FabcelUpConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.nio.file.Files
import java.nio.file.Paths



object PersistentData{

    val log: Logger = LoggerFactory.getLogger(javaClass)

    val secrets: MutableMap<String, String> = mutableMapOf()
    val globalProperties: MutableMap<String, String> = mutableMapOf()
    val backups: MutableList<Backup> = mutableListOf()

    fun getFabcelUpConfig(): FabcelUpConfig {
        val fabcelUpConfig = FabcelUpConfig(backups.toList(), globalProperties.toMap())
        return fabcelUpConfig
    }

    fun initPersistentDataForBackup(information: BackupInformation, properties: FabcelUpProperties){
        secrets.putAll(information.secrets)
        val scriptPath = Paths.get(properties.configfile)
        val scriptReader =  Files.newBufferedReader(scriptPath)
        KtsObjectLoader().load<Any>(scriptReader)
    }

    fun clearPersistentDataForBackup(){
        secrets.clear()
        globalProperties.clear()
        backups.clear()
    }
}

