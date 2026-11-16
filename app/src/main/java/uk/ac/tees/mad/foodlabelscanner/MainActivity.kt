package uk.ac.tees.mad.foodlabelscanner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import uk.ac.tees.mad.foodlabelscanner.ui.theme.FoodLabelScannerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FoodLabelScannerTheme {
                AppNavigation()

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScanScreenPreview() {
    FoodLabelScannerTheme {
        ScanScreen(onLookup = {}, onHistory = {})
    }
}