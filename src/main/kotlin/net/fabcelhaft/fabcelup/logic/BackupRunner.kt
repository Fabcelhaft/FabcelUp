package net.fabcelhaft.fabcelup.logic

import net.fabcelhaft.fabcelup.FabcelUpProperties
import net.fabcelhaft.fabcelup.data.PersistentData
import net.fabcelhaft.fabcelup.model.Backup
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File

@Service
class BackupRunner(@Autowired val properties: FabcelUpProperties){

    val log = LoggerFactory.getLogger(javaClass)

    fun runBackup() {
        createWorkDir()
        //checkConfiguration() TODO is everything basic needed
        progressBackups()
    }

    private fun createWorkDir() {
        val workingdirFile = File(properties.workingdir)
        val mkdirsResult = workingdirFile.mkdirs()
        if(mkdirsResult){
            log.info("Directory ${workingdirFile.absolutePath} created")
        }else{
            log.debug("Directory ${workingdirFile.absolutePath} already existed")
        }
    }

    private fun progressBackups() {
        PersistentData.backups.stream().forEach(this::runBackup)
    }

    private fun runBackup(backup: Backup){
        val id = backup.properties["id"]

    }
}