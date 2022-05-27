package com.example.android.roomwordssample.book

import android.app.Application
import com.example.android.roomwordssample.book.data.BookRepository
import com.example.android.roomwordssample.book.data.BookRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BookApplication :Application(){
    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy{ BookRoomDatabase.getDatabase(this, applicationScope)}
    val repository by lazy { BookRepository(database.bookDao()) }
}