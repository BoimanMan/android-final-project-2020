package com.example.finalproject_c00274244

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.internal.synchronized

@Database(entities = [(Entry::class)], version = 1)
abstract class EntryDatabase: RoomDatabase() {
    abstract fun entryDao(): EntryDao
    companion object{
        private var INSTANCE: EntryDatabase? = null
        internal fun getDatabase(context: Context): EntryDatabase?{
            if(INSTANCE == null){
                kotlin.synchronized(EntryDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            Room.databaseBuilder<EntryDatabase>(
                                context.applicationContext,
                                EntryDatabase::class.java,
                                "entry_database"
                            ).build()
                    }
                }
            }
            return INSTANCE
        }
    }
}