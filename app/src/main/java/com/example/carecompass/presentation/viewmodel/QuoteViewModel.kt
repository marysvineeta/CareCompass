package com.example.carecompass.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carecompass.data.model.Quote
import com.example.carecompass.data.repository.QuoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuoteViewModel : ViewModel() {
    private val repository = QuoteRepository()

    private val _quote = MutableStateFlow<Quote?>(null)
    val quote: StateFlow<Quote?> = _quote

    fun fetchQuote() {
        viewModelScope.launch {
            try {
                val fetched = repository.getQuote()
                _quote.value = fetched
            } catch (e: Exception) {
                _quote.value = Quote("Failed to fetch quote", "Unknown")
            }
        }
    }
}
