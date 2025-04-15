package com.example.cweek04a.uicomponents

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoCheckbox(
    checked: Boolean, modifier: Modifier = Modifier,
    onCheckedChange: (Boolean) -> Unit
) {
    Checkbox(
        checked = checked,
        onCheckedChange = { checked -> onCheckedChange(checked) })

}

@Preview
@Composable
private fun TodoCheckboxPreview() {
    Column {
        TodoCheckbox(true) { }
        TodoCheckbox(false) { }
    }
}