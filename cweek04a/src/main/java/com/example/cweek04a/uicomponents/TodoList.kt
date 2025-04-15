
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoItemFactory
import com.example.cweek04a.model.TodoStatus
import com.example.cweek04a.uicomponents.TodoCheckbox
import com.example.cweek04a.uicomponents.TodoItem

@Composable
fun TodoList(todoList: MutableList<Item>, modifier: Modifier = Modifier, showIncompleteOnly: Boolean) {

    // `derivedStateOf`를 사용하여 `todoList` 상태가 변경될 때마다 필터링된 리스트를 새로 계산하도록 수정
    val filteredList by remember(todoList, showIncompleteOnly) {
        derivedStateOf {
            if (showIncompleteOnly) {
                todoList.filter { it.status == TodoStatus.PENDING }
            } else {
                todoList
            }
        }
    }

    Column(modifier = modifier.fillMaxWidth()) {
        filteredList.forEach { item ->
            Card(modifier = Modifier.fillMaxWidth()) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TodoCheckbox(checked = item.status == TodoStatus.COMPLETED) { checked ->
                        val index = todoList.indexOf(item)
                        if (index != -1) {
                            todoList[index] = item.copy(
                                status = if (checked) TodoStatus.COMPLETED else TodoStatus.PENDING
                            )
                        }
                    }
                    TodoItem(item = item)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Preview
@Composable
private fun TodoListPreview() {
    val sampleList = remember { mutableStateListOf<Item>().apply { addAll(TodoItemFactory.makeTodoList()) } }
    TodoList(todoList = sampleList, showIncompleteOnly = false)
}
