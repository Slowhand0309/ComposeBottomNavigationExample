package com.example.bottomnavigationexample

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.bottomnavigationexample.ui.theme.ComposeBottomNavigationExampleTheme

enum class MainScreenTab(
    val icon: ImageVector,
    val label: String
) {
    Home(
        icon = Icons.Outlined.Home,
        label = "Home"
    ),
    List(
        icon = Icons.Outlined.List,
        label = "List"
    ),
    Settings(
        icon = Icons.Outlined.Info,
        label = "About"
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    var selectedItem by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            NavigationBar {
                MainScreenTab.values().forEachIndexed { index, item ->
                    NavigationBarItem(
                        icon = { Icon(item.icon, contentDescription = item.label) },
                        label = { Text(item.label) },
                        selected = selectedItem == index,
                        onClick = { selectedItem = index }
                    )
                }
            }
        }
    ) {
        Box(modifier = Modifier.padding(it))
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    ComposeBottomNavigationExampleTheme {
        MainScreen()
    }
}