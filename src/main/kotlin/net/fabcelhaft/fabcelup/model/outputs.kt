package net.fabcelhaft.fabcelup.model

abstract class Output

class FilesystemOutput(val path: String) : Output()

class OnedriveOutput(val token: String, val path: String) : Output()

class CallbackURLOutput : Output()
