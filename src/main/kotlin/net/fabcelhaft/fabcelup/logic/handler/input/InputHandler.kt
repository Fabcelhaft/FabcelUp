package net.fabcelhaft.fabcelup.logic.handler.input

abstract class InputHandler (val inputHandler: InputHandler, val properties: Map<String, String>) {
    abstract fun processInput()
}