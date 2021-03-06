import net.fabcelhaft.fabcelup.dsl.*

//globale Properties
properties{
    packaging="tar.gz"
}

backup{
    properties {
        id="mandant42"
        description="Beschreibung fürs Logging."
        packaging="tar.gz-encrypted" // alternativ zip, zip-encrypted, tar, tar-encrypted, tar.gz, folder
        encryptionKey="${secret("encryptionkey")}"
        dateFormat="yyyy-MM-DD"
    }

    input{
        filesystem("/mnt/datadir1") // Wird im Zielarchiv als fs_datadir1 abgelegt.
        filesystem("/mnt/datadir2")
        filesystem("/mnt/datadir3")
        mysql("mysqlHost", "mysqlUsername", "${secret("mysql.password")}", "databaseName")
        postgres("mysqlHost", "mysqlUsername", "${secret("postgres.password")}", "databaseName")
        webdav("http://webdav.url/dav.php", "user", "${secret("webdav.password")}") //Backup von allen Pfaden
        webdav("http://webdav.url/dav.php", "user", "${secret("webdav.password")}", "/path/to/backup")
    }
    output{ //exportiert mit "id_timestamp", wenn schon existiert "id_timestamp_counter"
        filesystem("/output/")
        onedrive("${secret("onedrive.authttoken")}", "/pfad/im/onedrive/")
        callbackUrl()
    }
}

//minimal
backup{
    properties{
        id="filebackup"
    }
    input{
        filesystem("/mnt/datadir1")
    }
    output{
        filesystem("/output/")
    }
}
