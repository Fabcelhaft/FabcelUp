package net.fabcelhaft.fabcelup.model

data class BackupInformation(val map: HashMap<String, String> = HashMap())

data class FabcelUpConfig(val backups: List<Backup> = listOf(),
                          val globalProperties: Map<String, String> = mapOf())

data class Backup(val properties: Map<String, String> = mapOf(),
                  val inputs: List<Input> = listOf(),
                  val outputs: List<Output> = listOf())
