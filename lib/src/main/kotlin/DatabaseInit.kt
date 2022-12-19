package lib.text

import android.content.Context
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.vendors.SQLiteDialect
import org.sqlite.SQLiteConfig
import org.sqlite.SQLiteOpenMode
import java.sql.DriverManager

fun Context.initDatabase(): Database {
    val config = SQLiteConfig().apply {
        enforceForeignKeys(true)
        setOpenMode(SQLiteOpenMode.FULLMUTEX)
    }
//    try {
//        DriverManager.registerDriver(SQLDroidDriver());
//    } catch (e: Exception) {
//        throw RuntimeException("Failed to register SQLDroidDriver");
//    }
    val jdbcUrl = "jdbc:${SQLiteDialect.dialectName}:/data/data/${packageName}/database.db";
    return Database.connect(
        getNewConnection = {
            DriverManager.getConnection(jdbcUrl, config.toProperties())
        }
    )
}
