package com.roadside.assistant.feature.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roadside.assistant.data.model.Request

@Composable
fun RequestListScreen(
    onOpen: (String) -> Unit,
    onCreate: () -> Unit,
    vm: RequestListViewModel = viewModel()
) {
    val state by vm.requests.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Roadside Assistance") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = onCreate) { Text("+") }
        }
    ) { padding ->
        if (state.isEmpty()) EmptyState(padding) else ListState(state, onOpen, padding)
    }
}

@Composable
private fun EmptyState(padding: PaddingValues) {
    Column(Modifier.fillMaxSize().padding(padding).padding(24.dp)) {
        Text("Нет активных заявок", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        Text("Создайте первую заявку с помощью кнопки +")
    }
}

@Composable
private fun ListState(itemsList: List<Request>, onOpen: (String) -> Unit, padding: PaddingValues) {
    LazyColumn(Modifier.fillMaxSize().padding(padding)) {
        items(itemsList, key = { it.id }) { item ->
            RequestRow(item, onOpen)
            Divider()
        }
    }
}

@Composable
private fun RequestRow(item: Request, onOpen: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onOpen(item.id) }
            .padding(16.dp)
    ) {
        Text(item.category.name, style = MaterialTheme.typography.titleMedium)
        Spacer(Modifier.height(4.dp))
        Text(item.description, style = MaterialTheme.typography.bodyMedium)
    }
}
