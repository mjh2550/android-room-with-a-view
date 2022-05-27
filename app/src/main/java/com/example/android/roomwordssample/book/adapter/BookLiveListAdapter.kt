package com.example.android.roomwordssample.book.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.book.adapter.BookLiveListAdapter.BookViewHolder
import com.example.android.roomwordssample.book.data.Book

class BookLiveListAdapter : ListAdapter<Book, BookViewHolder>(WORDS_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookLiveListAdapter.BookViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BookLiveListAdapter.BookViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }
    companion object {
        private val WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bookId : TextView = itemView.findViewById(R.id.bookId)
        private val bookName : TextView = itemView.findViewById(R.id.bookName)
        private val bookGenre : TextView = itemView.findViewById(R.id.bookGenre)
        private val bookAuthor : TextView = itemView.findViewById(R.id.bookAuthor)

        fun bind(book: Book) {
            bookId.text = book.id.toString()
            bookName.text = book.bookName
            bookGenre.text = book.bookGenre
            bookAuthor.text = book.bookAuthor
        }

        companion object {
            fun create(parent: ViewGroup): BookViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.book_items, parent, false)
                return BookViewHolder(view)
            }
        }
    }
}