package com.example.cweek04a

import MainScreen
import TodoList
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cweek04a.model.TodoItemFactory
import com.example.cweek04a.ui.theme.MyAppChaeMjTheme
import com.example.cweek04a.uicomponents.TodoItemInput
import com.example.cweek04a.uicomponents.TodoListTitle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge() 배터리 부분도 사용할거면 주석처리 빼기
        setContent {
            MyAppChaeMjTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(modifier = Modifier.padding(innerPadding)) // 틀에 우리 스크린 패딩 적용
                // -> 모르겠으면 그냥 innerPadding 주석 처리 하기
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun TodoListTotal(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize().padding(10.dp)
        ) {
        val todoList = TodoItemFactory.makeTodoList()
        TodoListTitle()
        Spacer(modifier = Modifier.height(10.dp))
        TodoList(todoList, modifier = Modifier.weight(1f), false) // List 자체를 State로 만들어야 함
        Spacer(modifier = Modifier.weight(1f))
        TodoItemInput(todoList)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppChaeMjTheme {
        Greeting("Android")
    }
}


@Preview
@Composable
private fun TodoListPreview() {
    TodoListTotal()
}