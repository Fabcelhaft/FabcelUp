package net.fabcelhaft.fabcelup.api

import net.fabcelhaft.fabcelup.FabcelUpProperties
import net.fabcelhaft.fabcelup.data.PersistentData
import net.fabcelhaft.fabcelup.logic.BackupProcessing
import net.fabcelhaft.fabcelup.model.BackupInformation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class FabcelUpApi(
    @Autowired var properties: FabcelUpProperties,
    @Autowired var backupProcessing: BackupProcessing
) {

    val log: Logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("start")
    fun backupTrigger(@RequestBody information: BackupInformation) {
        try {
            log.info("Starting Backup")
            log.debug("Backupinformation: $information")
            PersistentData.initPersistentDataForBackup(information, properties)
            backupProcessing.runBackup()
            log.info("Finished Backup")
        }catch (exception: Exception){
            log.error("Error while processing Backup", exception)
        }finally {
            PersistentData.clearPersistentDataForBackup()
        }
    }
}