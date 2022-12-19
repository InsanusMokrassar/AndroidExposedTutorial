package lib.text

import android.content.Context
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.vendors.SQLiteDialect

fun Context.initDatabase(): Database {
    return Database.connect(
        "jdbc:${SQLiteDialect.dialectName}:/data/data/${packageName}/database.db"
    )
}
