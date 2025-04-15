package com.example.cweek04a.model

import androidx.compose.runtime.mutableStateListOf

object TodoItemFactory {
    fun makeTodoList() = mutableStateListOf( // 리스트 자체가 state라 데이터 변경 및 삭제, 추가 시 재호출됨
        Item("아침 명상하기", "02-01 05:30", TodoStatus.COMPLETED),
        Item("오전 운동", "02-01 06:30", TodoStatus.PENDING),
        Item("책 읽기", "02-01 08:30", TodoStatus.PENDING),
        Item("점심 먹기", "02-01 12:30", TodoStatus.COMPLETED),
        Item("모프 공부하기", "02-01 17:30", TodoStatus.PENDING)
    )
}

