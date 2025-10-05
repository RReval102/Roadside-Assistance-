package com.roadside.assistant.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roadside.assistant.data.InMemoryRequestRepository
import com.roadside.assistant.data.RequestRepository
import com.roadside.assistant.data.model.Request
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class RequestListViewModel(
    private val repository: RequestRepository = InMemoryRequestRepository()
) : ViewModel() {
    val requests: StateFlow<List<Request>> = repository.observeRequests()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), emptyList())
}
