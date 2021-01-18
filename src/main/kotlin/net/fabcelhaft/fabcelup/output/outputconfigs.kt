package net.fabcelhaft.fabcelup.output

interface OutputConfig

class UrlOutputConfig: OutputConfig

class OneDriveOutputConfig(token: String): OutputConfig