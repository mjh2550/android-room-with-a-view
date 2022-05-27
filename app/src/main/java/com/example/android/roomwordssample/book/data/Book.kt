package com.example.android.roomwordssample.book.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "book_table")
class Book(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id") val id : Int?,
    @ColumnInfo(name = "book_genre") val bookGenre : String,
    @ColumnInfo(name = "book_name") val bookName : String,
    @ColumnInfo(name = "book_author") val bookAuthor : String,
    @ColumnInfo(name = "reg_time") val regTime : String

) {
//    constructor(bookGenre : String,bookName : String, bookAuthor : String) : (0,bookGenre,bookName,bookAuthor)

}