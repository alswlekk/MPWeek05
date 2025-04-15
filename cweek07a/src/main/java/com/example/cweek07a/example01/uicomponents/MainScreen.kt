package com.example.cweek07a.example01.uicomponents

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cweek07a.example01.navGraph.NavGraph

@SuppressLint("RestrictedApi") // annotation 처리하면서 이거 추가됨
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

//    navController.addOnDestinationChangedListener { _,_,_ ->
//        // 여기에 에제 Navigation CurrentBackStack 해보기
//
//    }
    navController.addOnDestinationChangedListener { _, _, _ ->
        navController.currentBackStack.value.forEachIndexed { index, navBackStackEntry ->
            Log.d("BackStack", "$index ${navBackStackEntry.destination.route}")
        }
    }

    NavGraph(navController = navController)
}