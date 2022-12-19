package app.text

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import lib.text.DataTable
import lib.text.initDatabase

class TextActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_text)

        val database = initDatabase()
        val table = DataTable(database)

        val editText = findViewById<EditText>(R.id.textInput)

        editText.setText(table.get())

        editText.addTextChangedListener(
            object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                override fun afterTextChanged(s: Editable?) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    table.put(s ?.toString() ?: return)
                }
            }
        )
    }
}
