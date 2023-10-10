package project_group.lib

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.update

class DataTable(
    private val database: Database
) : Table("data") {
    private val textColumn = text("text")

    init {
        transaction(database) {
            SchemaUtils.createMissingTablesAndColumns(this@DataTable)
        }
    }


    fun put(text: String) {
        transaction(database) {
            val updated = update {
                it[textColumn] = text
            }

            if (updated == 0) {
                insert {
                    it[textColumn] = text
                }
            }
        }
    }

    fun get(): String {
        return transaction(database) {
            selectAll().firstOrNull() ?.get(textColumn)
        } ?: ""
    }
}
