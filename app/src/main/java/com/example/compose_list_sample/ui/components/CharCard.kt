package com.example.compose_list_sample.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.compose_list_sample.NavScreen
import com.example.compose_list_sample.data.GenshinChar
import com.example.compose_list_sample.viewModel.GenshinCharViewModel

@Composable
fun CharCard(charValue: GenshinChar, viewModel: GenshinCharViewModel, navController: NavController) {
    Card(
        modifier = Modifier.padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.selectable(true,
                onClick = {
                    viewModel.selectedChar = charValue
                    navController.navigate(NavScreen.CharDetails.route)
                }
            )
        ) {
            Image(
                painter = rememberImagePainter(charValue.imgUrl),
                contentDescription = null,
                modifier = Modifier.size(130.dp)
                    .padding(8.dp),
                contentScale = ContentScale.Fit,
            )
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = charValue.name,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.onSurface,
                )
                Text(
                    text = charValue.vision,
                    style = MaterialTheme.typography.body2,
                )
            }
        }
    }
}