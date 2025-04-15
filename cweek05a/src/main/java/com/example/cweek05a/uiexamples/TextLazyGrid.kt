package com.example.cweek05a.uiexamples

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun TextLazyGrid(dataList: MutableList<String>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        //columns = GridCells.Adaptive(minSize = 100.dp), 최소 size 100dp를 유지
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }){
            Text("Number")
        }
        items(dataList) { item ->
            TextCell(text = item, Modifier.background(Color.Green)) // 체크 박스 (과제 2 할 때 이용 해볼 것)
        }
    }
}


@Preview
@Composable
private fun TextLazyGridPreview() {
    val dataList = (1..30).map { it.toString() }.toMutableList()
    TextLazyGrid(dataList = dataList, modifier = Modifier.fillMaxSize())
}