package project_group.lib

import android.content.Context
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.vendors.SQLiteDialect
import org.sqlite.JDBC
import java.sql.DriverManager

fun Context.initDatabase(): Database {
    val fileUrl = "${filesDir.absolutePath}/database.db"
    return Database.connect(
        "${JDBC.PREFIX}$fileUrl"
    )
}
