
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.Item
import com.example.cweek04a.model.TodoItemFactory
import com.example.cweek04a.uicomponents.TodoItemInput
import com.example.cweek04a.uicomponents.TodoListSwitch
import com.example.cweek04a.uicomponents.TodoListTitle

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val todoList =
        remember { mutableStateListOf<Item>().apply { addAll(TodoItemFactory.makeTodoList()) } }
    var showIncompleteOnly by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Row {
            TodoListTitle()
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "202311381 채민지")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row {
            Spacer(modifier = Modifier.weight(1f))
            TodoListSwitch(
                showIncompleteOnly = showIncompleteOnly,
                onCheckedChange = { showIncompleteOnly = it }
            )
        }
        Box(
            modifier = Modifier.weight(1f) // 스크롤 가능한 영역
        ) {
            TodoList(
                todoList = todoList,
                modifier = Modifier.verticalScroll(rememberScrollState()),
                showIncompleteOnly = showIncompleteOnly
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        TodoItemInput(todoList = todoList)
    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}
