package com.example.android.roomwordssample.book.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id") var id: Int?,
    @ColumnInfo(name = "book_genre") var bookGenre: String?,
    @ColumnInfo(name = "book_name") var bookName: String?,
    @ColumnInfo(name = "book_author") var bookAuthor: String?,
    @ColumnInfo(name = "reg_time") var regTime: String?

) {
    constructor(bookName: String?, bookAuthor: String?, bookGenre: String?)
            :this(null, bookGenre, bookName, bookAuthor,"") {

    }
}