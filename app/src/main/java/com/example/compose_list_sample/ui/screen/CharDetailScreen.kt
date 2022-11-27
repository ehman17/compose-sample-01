package com.example.compose_list_sample.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.compose_list_sample.R
import com.example.compose_list_sample.viewModel.GenshinCharViewModel


@Composable
fun CharDetailScreen(
    navController: NavController = rememberNavController(),
    charViewModel: GenshinCharViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(charViewModel.selectedChar.imgUrl),
                contentDescription = null,
                modifier = Modifier.size(400.dp)
                    .padding(10.dp),
                contentScale = ContentScale.Fit,
            )
            Text(
                text = charViewModel.selectedChar.name,
                style = MaterialTheme.typography.h4
            )
            Text(
                text = "Vision: " + charViewModel.selectedChar.vision,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Weapon type: " + charViewModel.selectedChar.weaponType,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Region: " + charViewModel.selectedChar.region,
                style = MaterialTheme.typography.body2
            )

            Button(
                onClick = {
                    navController.navigateUp()
                }
            ) {
                Text(text = "Back")
            }
        }
    }
}