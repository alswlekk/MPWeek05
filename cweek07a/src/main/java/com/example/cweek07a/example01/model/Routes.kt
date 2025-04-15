package com.example.cweek07a.example01.model

sealed class Routes(val route: String) {
    object Home : Routes(route = "Home")
    object ScreenA : Routes(route = "A")
    object ScreenB : Routes(route = "B")
    object ScreenC : Routes(route = "C")
    object ScreenD : Routes(route = "D")
} // 사용하는 경로 여기에 등록해 두면 됨