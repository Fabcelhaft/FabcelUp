package net.fabcelhaft.fabcelup.model

data class BackupInformation(val map: HashMap<String, String> = HashMap())

data class FabcelUpConfig(val backups: MutableList<Backup> = mutableListOf(),
                          val globalProperties: Map<String, String> = mutableMapOf())

data class Backup(val properties: Map<String, String> = mutableMapOf(),
                  val inputs: MutableList<Input> = mutableListOf(),
                  val outputs: MutableList<Output> = mutableListOf())
