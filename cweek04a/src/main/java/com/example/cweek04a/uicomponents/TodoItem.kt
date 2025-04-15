package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoStatus

@Composable
fun TodoItem(item: Item, modifier: Modifier = Modifier) {
        Column {
            Text(
                text = item.content, fontSize = 16.sp,
                style = if (item.status == TodoStatus.COMPLETED)
                    TextStyle(textDecoration = TextDecoration.LineThrough) // 완료 시 밑줄 긋기
                else TextStyle(textDecoration = TextDecoration.None)
            ) // 콘텐츠 출력
            Spacer(modifier = Modifier.height(4.dp)) // 4.dp 만큼 공백 만듦
            Text(text = item.time, fontSize = 10.sp) // 시간 출력
        }
}

@Preview
@Composable
private fun TodoItemPreview() {
    Column {
        TodoItem(Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED))
        Spacer(modifier = Modifier.height(4.dp))
        TodoItem(Item("오전 운동", "02-01 06:30"))
    }
}