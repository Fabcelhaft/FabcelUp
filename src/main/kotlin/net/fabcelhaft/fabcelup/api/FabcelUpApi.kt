package net.fabcelhaft.fabcelup.api

import de.swirtz.ktsrunner.objectloader.KtsObjectLoader
import net.fabcelhaft.fabcelup.FabcelUpProperties
import net.fabcelhaft.fabcelup.data.PersistentData
import net.fabcelhaft.fabcelup.model.BackupInformation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.nio.file.Files
import java.nio.file.Paths

@RestController
class FabcelUpApi(
    @Autowired
    var config: FabcelUpProperties
) {

    @PostMapping("start")
    fun backupTrigger(@RequestBody information: BackupInformation) {
        try {
            PersistentData.secrets.putAll(information.secrets)
            val scriptPath = Paths.get(config.configfile)
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