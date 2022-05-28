package com.example.android.roomwordssample.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.util.BookParcelableClass

class BookAddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_add)

        val edt_bookGenre = findViewById<EditText>(R.id.edt_bookGenre)
        val edt_bookName = findViewById<EditText>(R.id.edt_bookName)
        val edt_bookAuthor = findViewById<EditText>(R.id.edt_bookAuthor)
        val btn_save = findViewById<Button>(R.id.btn_save)
        btn_save.setOnClickListener {
            val result_intent = Intent()
            if(TextUtils.isEmpty(edt_bookName.text)) {
                setResult(RESULT_CANCELED, result_intent)
            } else {
                val bookData = BookParcelableClass().apply{
                    bookGenre = edt_bookGenre.text.toString()
                    bookName= edt_bookName.text.toString()
                    bookAuthor= edt_bookAuthor.text.toString()
                }
                result_intent.putExtra(EXTRA_REPLY,bookData)
                setResult(RESULT_OK, result_intent)
            }
            finish()
        }
    }
    companion object{
        const val EXTRA_REPLY = "com.example.android.bookList.REPLY"
    }
}