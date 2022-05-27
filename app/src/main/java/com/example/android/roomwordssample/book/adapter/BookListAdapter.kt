package com.example.android.roomwordssample.book.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.book.data.Book

class BookListAdapter(private val context: Context, private val bookList : List<Book>) : RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    inner class ViewHolder( itemView :View): RecyclerView.ViewHolder(itemView) {

        private val bookId : TextView = itemView.findViewById(R.id.bookId)
        private val bookName : TextView = itemView.findViewById(R.id.bookName)
        private val bookGenre : TextView = itemView.findViewById(R.id.bookGenre)
        private val bookAuthor : TextView = itemView.findViewById(R.id.bookAuthor)

        fun bind(book: Book,context: Context){
            bookId.text = book.id.toString()
            bookName.text = book.bookName
            bookGenre.text = book.bookGenre
            bookAuthor.text = book.bookAuthor
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.book_items,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bookList[position], context)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}