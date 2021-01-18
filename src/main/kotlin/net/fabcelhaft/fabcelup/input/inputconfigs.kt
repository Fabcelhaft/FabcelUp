package net.fabcelhaft.fabcelup.input

import lombok.Data
import lombok.ToString

interface InputConfig {

}

@Data
class FileSystemConfig(val path: String): InputConfig

@Data
class WebDAVConfig(val path: String, val username: String,val password: String): InputConfig