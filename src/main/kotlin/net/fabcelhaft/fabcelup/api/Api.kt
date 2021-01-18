package net.fabcelhaft.fabcelup.api

import net.fabcelhaft.fabcelup.model.BackupInformation
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Api {
    @PostMapping("start")
    fun backupTrigger(information: BackupInformation): Boolean {
        // TODO
        return false
    }

    fun getURL(): String {
        return "TODO"
    }
}