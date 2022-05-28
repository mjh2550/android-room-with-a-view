package com.example.android.roomwordssample.util

import android.os.Parcel
import android.os.Parcelable

class BookParcelableClass() : Parcelable {
    var bookId : Int = 0;
    var bookName : String? = "";
    var bookAuthor : String? = "";
    var bookGenre : String? = "";

    constructor(parcel: Parcel) : this() {
        bookId  =  parcel.readInt()
        bookName = parcel.readString().toString()
        bookAuthor = parcel.readString().toString()
        bookGenre = parcel.readString().toString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(bookId)
        parcel.writeString(bookName)
        parcel.writeString(bookAuthor)
        parcel.writeString(bookGenre)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BookParcelableClass> {
        override fun createFromParcel(parcel: Parcel): BookParcelableClass {
            return BookParcelableClass(parcel)
        }

        override fun newArray(size: Int): Array<BookParcelableClass?> {
            return arrayOfNulls(size)
        }
    }
}