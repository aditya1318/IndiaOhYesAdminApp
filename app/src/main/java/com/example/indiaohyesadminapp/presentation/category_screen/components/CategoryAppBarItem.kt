package com.example.indiaohyesadminapp.presentation.category_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.indiaohyesadminapp.domain.model.Category

@Composable
fun CategoryAppBarItem(
    category: Category,
    onItemClick: (Category) -> Unit

) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp), verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = category.title, textAlign = TextAlign.Center, fontSize = 16.sp)

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 10.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement =Arrangement.End
                ) {
                    UpdateButton()
                    Spacer(modifier = Modifier.width(4.dp))
                    DeleteIcon()
                }

            }
        }
    }
}

@Composable
fun UpdateButton() {
    Box(
        modifier = Modifier
            .width(100.dp)
            .fillMaxHeight(0.5f)
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Update", fontSize = 15.sp)
    }
}

@Composable
fun DeleteIcon() {
    Icon(
        imageVector = Icons.Outlined.Delete,
        contentDescription = "delete",
        modifier = Modifier.aspectRatio(0.5f, matchHeightConstraintsFirst = true)
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewAppBarItem() {
    CategoryAppBarItem(
        category = Category("23432", "sdfsdfsdf", "asdasd", "Aditya"),
        onItemClick = {})
}