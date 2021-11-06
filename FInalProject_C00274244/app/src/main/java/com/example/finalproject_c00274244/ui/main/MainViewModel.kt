package com.example.finalproject_c00274244.ui.main

import androidx.lifecycle.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.finalproject_c00274244.Entry
import com.example.finalproject_c00274244.EntryRepository

class MainViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: EntryRepository = EntryRepository(application)
    private val allEntries : LiveData<List<Entry>>?
    private val searchResults: MutableLiveData<List<Entry>>
    init{
        allEntries = repository.allEntries
        searchResults = repository.searchResults
    }
    fun deleteEntry(name: String, game: String) {
        repository.deleteEntry(name, game)
    }
    fun insertEntry(entry: Entry) {
        repository.insertEntry(entry)
    }
    fun findEntry(game: String, name: String) {
        repository.findEntry(game, name)
    }
    fun getSearchResults(): MutableLiveData<List<Entry>> {
        return searchResults
    }
    fun getAllEntries(): LiveData<List<Entry>>? {
        return allEntries
    }
}
