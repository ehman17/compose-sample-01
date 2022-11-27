package com.example.compose_list_sample.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.compose_list_sample.R
import com.example.compose_list_sample.ui.components.CharCard
import com.example.compose_list_sample.viewModel.GenshinCharViewModel


@Composable
fun AllCharScreen(
    navController: NavController = rememberNavController(),
    charViewModel: GenshinCharViewModel) {

    // State
    val chars = charViewModel.charList.observeAsState()

    // API call
    LaunchedEffect(key1 = Unit) {
        charViewModel.getChars()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "Sample List",
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.primary
                    )
                }
            }
            val values = chars.value
            if (values != null) {
                items(values.size) { charV ->
                    CharCard(values[charV], charViewModel, navController)
                }
            }
        }
    }
}