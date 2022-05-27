package com.example.android.roomwordssample.book

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.book.adapter.BookListAdapter
import com.example.android.roomwordssample.book.adapter.BookLiveListAdapter
import com.example.android.roomwordssample.book.viewmodel.BookViewModel
import com.example.android.roomwordssample.book.viewmodel.BookViewModelFactory

class MainBookActivity : AppCompatActivity() {

    companion object{
        const val BOOK_ADD_REQUEST_CODE = 1
    }

    private val bookViewModel : BookViewModel by viewModels {
        BookViewModelFactory((application as BookApplication).repository)
    }

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_book)

        /**
         *  CodeLab Creating Process
         * data class -> dao -> roomdb -> repository -> viewmodel
         * -> layout -> mainactivity ->application -> roomdbCallback
         */

//        initBinding()
        recyclerView = findViewById(R.id.bookRecycleView)
        val adapter = BookLiveListAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        bookViewModel.allBooks.observe(this){ books ->
            books.let {
                adapter.submitList(books)
            }
        }
    }
}