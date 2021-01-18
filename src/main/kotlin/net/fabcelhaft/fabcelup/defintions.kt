package net.fabcelhaft.fabcelup

import net.fabcelhaft.fabcelup.input.InputConfig
import net.fabcelhaft.fabcelup.output.OutputConfig

interface Input{
    fun runWithConfig(config: InputConfig)
}

interface Output{
    fun runWithConfig(config: OutputConfig)
}