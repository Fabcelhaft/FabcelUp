package net.fabcelhaft.fabcelup.logic

import net.fabcelhaft.fabcelup.FabcelUpProperties
import net.fabcelhaft.fabcelup.model.Backup
import net.fabcelhaft.fabcelup.model.Input
import java.io.File

class BackupRunner(val backup: Backup, val properties: FabcelUpProperties, val backupWorkingDir: File) {
    fun runBackup(){
        processInputs()
    }

    private fun processInputs() {
        backup.inputs.stream().forEach(this::processInput)
    }

    private fun processInput(input: Input) {
        val handler = input.getHandler()
    }
}
