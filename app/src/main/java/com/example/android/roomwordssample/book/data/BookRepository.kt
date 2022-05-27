package com.example.android.roomwordssample.book.data

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BookRepository(private val bookDao: BookDao) {

    val allBooks : Flow<List<Book>> = bookDao.getSelectBookLists()

    @WorkerThread
    suspend fun insert(book:Book){
        bookDao.insert(book)
    }

}