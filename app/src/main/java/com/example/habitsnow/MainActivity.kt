package com.example.habitsnow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background // Import for Modifier.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController // Import for NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//Holaaaaa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "calendario") {
        composable("calendario") { CalendarioScreen(navController) }
        composable("nuevo_habito") { NuevoHabitoScreen(navController) }
        composable("agregar_recordatorio") { RecordatorioScreen(navController) }
    }
}

@Composable
fun CalendarioScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text("Calendario", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(24.dp))

        // Calendario básico
        Column {
            // Días de la semana
            Row(Modifier.fillMaxWidth()) {
                listOf("S", "M", "T", "W", "T", "F", "S").forEach { dia ->
                    Text(
                        text = dia,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }

            // Filas del calendario
            listOf(
                listOf("1", "2", "3", "4", "5", "", ""),
                listOf("6", "7", "8", "9", "10", "11", "12"),
                listOf("13", "14", "15", "17", "18", "18", "19"),
                listOf("20", "21", "22", "23", "24", "25", "26"),
                listOf("27", "28", "29", "●", "", "", "")
            ).forEach { semana ->
                Row(Modifier.fillMaxWidth()) {
                    semana.forEach { dia ->
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                                .padding(4.dp)
                                .background( // Make sure you have the import for background
                                    if (dia == "●") Color.Blue.copy(alpha = 0.2f)
                                    else Color.Transparent,
                                    MaterialTheme.shapes.small
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            if (dia.isNotEmpty()) {
                                Text(text = dia)
                            }
                        }
                    }
                }
            }
        }

        Spacer(Modifier.weight(1f))

        // Botones
        Button(
            onClick = { navController.navigate("agregar_recordatorio") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Agregar Recordatorio")
        }

        Spacer(Modifier.height(8.dp))

        Button(
            onClick = { navController.navigate("nuevo_habito") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Nuevo Hábito")
        }
    }
}

@Composable
fun NuevoHabitoScreen(navController: NavHostController) { // Corrected parameter type
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Nuevo Hábito", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(32.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = "Cada semana",
            onValueChange = {},
            label = { Text("Frecuencia") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.weight(1f))

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar")
        }
    }
}

@Composable
fun RecordatorioScreen(navController: NavHostController) { // Corrected parameter type
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Agregar Recordatorio", style = MaterialTheme.typography.headlineMedium)

        Spacer(Modifier.height(32.dp))

        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = "Cada día",
            onValueChange = {},
            label = { Text("Repetir") },
            modifier = Modifier.fillMaxWidth())
    }
}