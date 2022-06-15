package com.example.android.roomwordssample.book.viewmodel

import androidx.lifecycle.*
import com.example.android.roomwordssample.book.data.Book
import com.example.android.roomwordssample.book.data.BookRepository
import kotlinx.coroutines.launch


class BookViewModel(private val repository: BookRepository) : ViewModel() {

    //FLOW -> LiveData
    val allBooks :LiveData<List<Book>> = repository.allBooks.asLiveData()

    fun insert(book: Book) = viewModelScope.launch {
        repository.insert(book)
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

}

class BookViewModelFactory(private val repository: BookRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(BookViewModel::class.java)){
            return BookViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}