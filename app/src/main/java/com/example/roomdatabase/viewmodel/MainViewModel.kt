package com.example.roomdatabase.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdatabase.models.QuoteList
import com.example.roomdatabase.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val repository: QuoteRepository):ViewModel() {
    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getQuotes(1)
        }

    }
    val quotes:LiveData<QuoteList>
    get() = repository.quotes
}