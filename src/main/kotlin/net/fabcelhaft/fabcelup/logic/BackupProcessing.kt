package net.fabcelhaft.fabcelup.logic

import net.fabcelhaft.fabcelup.FabcelUpProperties
import net.fabcelhaft.fabcelup.FabcelUpPropertyKeys
import net.fabcelhaft.fabcelup.data.PersistentData
import net.fabcelhaft.fabcelup.model.Backup
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File

@Service
class BackupProcessing(@Autowired val properties: FabcelUpProperties){

    val log: Logger = LoggerFactory.getLogger(javaClass)

    var generalWorkingDir = File("work/")

    fun processBackups() {
        val generalWorkDir = createWorkDir()
        //checkConfiguration() TODO is everything basic needed
        progressBackups()
    }

    private fun createWorkDir() {
        generalWorkingDir = File(properties.workingdir)
        mkdirs(generalWorkingDir)
    }

    private fun progressBackups() {
        PersistentData.backups.stream().forEach(this::processBackups)
    }

    private fun processBackups(backup: Backup){
        val id = backup.properties[FabcelUpPropertyKeys.ID.key]
        val backupWorkingDir = File("${generalWorkingDir.absolutePath}${File.separator}$id")
        mkdirs(backupWorkingDir)
        val backUpRunner = BackupRunner(backup, properties, backupWorkingDir)
        backUpRunner.runBackup()
    }

    /**
     * Erstellt einen Ordner mit allen Zwischenebenen
     */
    private fun mkdirs(directory: File) {
        val mkdirsResult = directory.mkdirs()
        if (mkdirsResult) {
            log.info("Directory ${directory.absolutePath} created")
        } else {
            log.debug("Directory ${directory.absolutePath} already existed")
        }
    }
}
