package net.fabcelhaft.fabcelup.model

abstract class Input

class FilesystemInput(val path: String) : Input()

class WebDavInput(val url: String, val user: String, val password: String, val path: String) : Input()

abstract class DatabaseInput(val host: String, val username: String, val password: String, val databaseName: String) : Input()

class MySQLInput(host: String, username: String, password: String, databaseName: String)
    : DatabaseInput(host, username, password, databaseName)

class PostgresInput(host: String, username: String, password: String, databaseName: String, schema: String = "public")
    : DatabaseInput(host, username, password, databaseName)