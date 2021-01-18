package net.fabcelhaft.fabcelup.model

import net.fabcelhaft.fabcelup.input.InputConfig
import net.fabcelhaft.fabcelup.output.OutputConfig

data class BackupInformation(val map: HashMap<String, String> = HashMap())

data class FabcelUpConfig(val inputs: MutableList<InputConfig> = mutableListOf(), val outputs: MutableList<OutputConfig> = mutableListOf())

