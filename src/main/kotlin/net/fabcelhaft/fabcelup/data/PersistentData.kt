package net.fabcelhaft.fabcelup.data

import net.fabcelhaft.fabcelup.model.Backup
import net.fabcelhaft.fabcelup.model.FabcelUpConfig

object PersistentData{
    val secrets: MutableMap<String, String> = mutableMapOf()
    val globalProperties: MutableMap<String, String> = mutableMapOf()
    val backups: MutableList<Backup> = mutableListOf()

    fun getFabcelUpConfig(): FabcelUpConfig {
        val fabcelUpConfig = FabcelUpConfig(backups.toList(), globalProperties.toMap())
        return fabcelUpConfig
    }
}