package com.roadside.assistant.feature.create

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roadside.assistant.data.model.RequestCategory
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateRequestScreen(
    onDone: (String) -> Unit,
    vm: CreateRequestViewModel = viewModel()
) {
    var category by remember { mutableStateOf(RequestCategory.TIRE) }
    var description by remember { mutableStateOf("") }
    var lat by remember { mutableStateOf(55.751244) }
    var lon by remember { mutableStateOf(37.618423) }
    val scope = rememberCoroutineScope()

    Scaffold(topBar = { TopAppBar(title = { Text("Новая заявка") }) }) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                RequestCategory.values().forEach { c ->
                    FilterChip(selected = category == c, onClick = { category = c }, label = { Text(c.name) })
                }
            }
            OutlinedTextField(value = description, onValueChange = { description = it }, label = { Text("Описание") }, modifier = Modifier.fillMaxWidth())
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = lat.toString(), onValueChange = { lat = it.toDoubleOrNull() ?: lat }, label = { Text("Широта") }, modifier = Modifier.weight(1f))
                OutlinedTextField(value = lon.toString(), onValueChange = { lon = it.toDoubleOrNull() ?: lon }, label = { Text("Долгота") }, modifier = Modifier.weight(1f))
            }
            Button(onClick = {
                scope.launch {
                    val id = vm.create("demo-user", category, description.ifBlank { "Без описания" }, lat, lon)
                    onDone(id)
                }
            }, enabled = description.isNotBlank()) {
                Text("Создать заявку")
            }
        }
    }
}
