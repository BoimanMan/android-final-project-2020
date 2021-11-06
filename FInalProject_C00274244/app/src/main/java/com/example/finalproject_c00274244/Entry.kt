package com.example.finalproject_c00274244

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entries")
data class Entry(@PrimaryKey(autoGenerate=true) @NonNull @ColumnInfo(name = "id") var id: Int = 0,
                @ColumnInfo(name = "username") var username: String,
                @ColumnInfo(name = "game") val game: String,
                @ColumnInfo(name = "rating") var rating: Double = 0.0,
                @ColumnInfo(name = "pros") var pros: String,
                @ColumnInfo(name = "cons") var cons: String)