package com.example.android.roomwordssample.book

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.book.adapter.BookLiveListAdapter
import com.example.android.roomwordssample.book.data.Book
import com.example.android.roomwordssample.book.data.BookRepository
import com.example.android.roomwordssample.book.data.DataModule
import com.example.android.roomwordssample.book.viewmodel.BookViewModel
import com.example.android.roomwordssample.book.viewmodel.BookViewModelFactory
import com.example.android.roomwordssample.util.BookParcelableClass
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainBookActivity : AppCompatActivity(),View.OnClickListener{

    companion object{
        const val BOOK_ADD_REQUEST_CODE = 1
    }

    private val bookViewModel : BookViewModel by viewModels {
        BookViewModelFactory((application as BookApplication).repository)
    }

    @Inject lateinit var test :String

    lateinit var recyclerView: RecyclerView
    lateinit var btn_delete : Button
    lateinit var btn_flaotingAction :FloatingActionButton
    lateinit var adapter: BookLiveListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_book)

        Log.d("testString : ", "$test")

        initBinding()
        initObserving()

    }

    private fun initBinding() {

        adapter = BookLiveListAdapter()
        recyclerView = findViewById(R.id.bookRecycleView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        btn_delete = findViewById(R.id.btn_delete)
        btn_delete.setOnClickListener (this)
        btn_flaotingAction = findViewById(R.id.btn_floatingAction)
        btn_flaotingAction.setOnClickListener(this)
    }

    private fun initObserving() {
        bookViewModel.allBooks.observe(this) { books ->
            books.let {
                adapter.submitList(books)
            }
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_floatingAction -> {
                val intent = Intent(this,BookAddActivity::class.java)
                startActivityForResult(intent, BOOK_ADD_REQUEST_CODE)
            }
            R.id.btn_delete ->  bookViewModel.deleteAll()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == BOOK_ADD_REQUEST_CODE && resultCode == RESULT_OK){
            val book = data?.getParcelableExtra<BookParcelableClass>(BookAddActivity.EXTRA_REPLY)
            val newData = Book(
                bookName = book?.bookName,
                bookAuthor = book?.bookAuthor,
                bookGenre = book?.bookGenre
                )
            bookViewModel.insert(newData)
        }else{
            Toast.makeText(
                applicationContext,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            )
        }
    }
}