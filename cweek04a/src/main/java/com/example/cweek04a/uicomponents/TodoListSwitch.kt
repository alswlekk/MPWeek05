package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TodoListSwitch(showIncompleteOnly: Boolean, modifier: Modifier = Modifier, onCheckedChange: (Boolean) -> Unit) {
    var checked by remember { mutableStateOf(showIncompleteOnly) }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "미완료 항목만 보기", modifier = modifier, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = modifier.width(10.dp))
        Switch(
            checked = checked,
            onCheckedChange = {
                checked = it
                onCheckedChange(checked)
            }
        )
    }
}

@Preview
@Composable
fun SwitchMinimalExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}