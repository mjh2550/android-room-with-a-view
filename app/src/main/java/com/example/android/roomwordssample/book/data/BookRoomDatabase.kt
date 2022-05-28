package com.example.android.roomwordssample.book.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Book::class], version = 2)
abstract class BookRoomDatabase : RoomDatabase(){

    abstract fun bookDao() : BookDao

    companion object {

        @Volatile
        private var INSTANCE: BookRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): BookRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookRoomDatabase::class.java,
                    "book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(BookRoomDatabaseCallBack(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }


        private class BookRoomDatabaseCallBack(private val scope: CoroutineScope) :
            RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.bookDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(bookDao: BookDao){

            bookDao.deleteAll()

            var book = Book(0,"History","SeJong King","unknown","")
            bookDao.insert(book)

        }
    }
}
