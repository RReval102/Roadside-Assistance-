package com.roadside.assistant.feature.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roadside.assistant.data.model.Request

@Composable
fun RequestDetailScreen(id: String, onBack: () -> Unit, vm: RequestDetailViewModel = viewModel()) {
    var state by remember { mutableStateOf<Request?>(null) }

    LaunchedEffect(id) {
        state = vm.load(id)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Заявка #$id") },
                navigationIcon = {
                    TextButton(onClick = onBack) { Text("Назад") }
                }
            )
        }
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            when (val r = state) {
                null -> Text("Загрузка…")
                else -> {
                    Text("Категория: ${r.category}", style = MaterialTheme.typography.titleMedium)
                    Text("Описание: ${r.description}")
                    Text("Координаты: ${r.location.lat}, ${r.location.lon}")
                }
            }
        }
    }
}
