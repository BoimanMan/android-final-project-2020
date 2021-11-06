package com.example.finalproject_c00274244
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
@Dao
interface EntryDao {
    @Insert
    fun insertEntry(entry: Entry)

    @Query("SELECT * FROM entries WHERE game = :game AND username = :username")
    fun findEntry(game: String, username: String): List<Entry>

    @Query("SELECT * FROM entries")
    fun getAllEntries(): LiveData<List<Entry>>

    @Query("DELETE FROM entries WHERE username = :user AND game = :game")
    fun deleteEntry(user: String, game: String)
}