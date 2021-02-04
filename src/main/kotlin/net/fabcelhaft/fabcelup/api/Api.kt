package net.fabcelhaft.fabcelup.api

import net.fabcelhaft.fabcelup.data.PersistentData
import net.fabcelhaft.fabcelup.model.BackupInformation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files
import java.nio.file.Paths

@RestController
class Api {
    @PostMapping("start")
    fun backupTrigger(@RequestBody information: BackupInformation) {
        try {
            PersistentData.secrets.putAll(information.secrets)
            val scriptPath = Paths.get("fabcelup_config.kts")
            val scriptReader =  Files.newBufferedReader(scriptPath)
            KtsObjectLoader().load<Any>(scriptReader)
        }finally {
            PersistentData.secrets.clear()
            PersistentData.globalProperties.clear()
            PersistentData.backups.clear()
        }
    }

    fun getURL(): String {
        return "TODO"
    }
}