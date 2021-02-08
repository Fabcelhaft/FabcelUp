package net.fabcelhaft.fabcelup.model

import net.fabcelhaft.fabcelup.logic.handler.input.InputHandler

abstract class Input {
    abstract fun getHandler(): InputHandler
}

class FilesystemInput(val path: String) : Input() {
    override fun getHandler(): InputHandler {
        TODO("Not yet implemented")
    }
}

class WebDavInput(val url: String, val user: String, val password: String, val path: String) : Input() {
    override fun getHandler(): InputHandler {
        TODO("Not yet implemented")
    }
}

abstract class DatabaseInput(val host: String, val username: String, val password: String, val databaseName: String) : Input()

class MySQLInput(host: String, username: String, password: String, databaseName: String)
    : DatabaseInput(host, username, password, databaseName) {
    override fun getHandler(): InputHandler {
        TODO("Not yet implemented")
    }
}

class PostgresInput(host: String, username: String, password: String, databaseName: String, schema: String = "public")
    : DatabaseInput(host, username, password, databaseName) {
    override fun getHandler(): InputHandler {
        TODO("Not yet implemented")
    }
}
