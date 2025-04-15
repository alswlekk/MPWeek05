package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoSwitch(checked: Boolean, modifier: Modifier = Modifier, onCheckedChange: (Boolean) -> Unit) {
    Switch(
        checked = checked,
        onCheckedChange = { checked -> onCheckedChange(checked) },
    )
}

@Preview
@Composable
fun TodoSwitchPreview() {
    Column {
        TodoSwitch(true) {}
        TodoSwitch(false) {}
    }
}