package net.fabcelhaft.fabcelup.dsl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BackupBuilderTest{

    @Test
    fun test_empty() {
        val backup = backup {
            properties {
                id="test"
            }
            input {
            }
            output {  }
        }
        val (properties, inputs, outputs) = backup
        assertTrue(properties.isNotEmpty())
        assertEquals(0, inputs.size)
        assertEquals(0, outputs.size)
    }
}