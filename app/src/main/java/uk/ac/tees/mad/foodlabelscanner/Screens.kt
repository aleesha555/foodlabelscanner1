package uk.ac.tees.mad.foodlabelscanner

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
@Composable
fun SplashScreen(onFinished: () -> Unit) {
    LaunchedEffect(Unit) {
        delay(1500)
        onFinished()
    }
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Food Label Scanner", style = MaterialTheme.typography.headlineLarge)
    }
}

@Composable
fun ScanScreen(onLookup: (String) -> Unit, onHistory: () -> Unit) {
    var barcode by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Scan a product", style = MaterialTheme.typography.headlineMedium)
        OutlinedTextField(
            value = barcode,
            onValueChange = { barcode = it },
            label = { Text("Barcode") },
            singleLine = true
        )
        Button(onClick = { onLookup(barcode) }, enabled = barcode.length >= 8) {
            Text("Look up product")
        }
        TextButton(onClick = onHistory) { Text("View history") }
    }
}

@Composable
fun DetailScreen(barcode: String, onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("Product details", style = MaterialTheme.typography.headlineMedium)
        Text("Barcode: $barcode")
        Button(onClick = onBack) { Text("Back") }
    }
}

@Composable
fun HistoryScreen(onBack: () -> Unit) {
    Column(Modifier.fillMaxSize().padding(24.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
        Text("History", style = MaterialTheme.typography.headlineMedium)
        Text("Your scanned products will appear here.")
        Button(onClick = onBack) { Text("Back") }
    }
}