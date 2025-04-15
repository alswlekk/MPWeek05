package com.example.cweek05a.uicomponents

import android.content.res.Configuration
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cweek05a.model.ButtonType
import com.example.cweek05a.uiexamples.ScrollToTopButton
import com.example.cweek05a.viewmodel.ImageViewModel
import kotlinx.coroutines.launch

@Composable
fun MainScreen(modifier: Modifier = Modifier,
               imageViewModel: ImageViewModel = viewModel()) {
    val imageList = imageViewModel.imageList
    val orientation = LocalConfiguration.current.orientation

    val state = rememberLazyListState()
    val scope = rememberCoroutineScope()

    val showButton by remember { // 상태가 바껴야함 (by remember 대신 = 쓰면 자꾸 recomposition 일어남)
        // mutableState로 하면 안바뀜
        derivedStateOf { // 상태 선언(firstVisibleItemIndex 값에 따라 상태 결정됨)
            state.firstVisibleItemIndex > 0
        }
    }

    if (orientation == Configuration.ORIENTATION_PORTRAIT) {
        Box(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                state = state, // 상태 변화에 따라 FAB 보이게 하기
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp), // 리스트 안의 항목들 사이의 간격 (Spacing) 을 설정
                contentPadding = PaddingValues(10.dp), // 전체 리스트 바깥쪽 여백 (Padding) 을 설정
            )
            {
//            ImageList(imageList = imageList)
                itemsIndexed(imageList) { index, items ->
                    when (items.buttonType) {
                        ButtonType.ICON -> {
                            ImageWithButton(image = items.image) {
                                ButtonWithIcon(likes = items.likes) {
                                    imageList[index] = items.copy(likes = items.likes + 1)
                                }
                            }
                        }

                        ButtonType.BADGE -> {
                            ImageWithButton(image = items.image) {
                                ButtonWithBadge(likes = items.likes) {
                                    imageList[index] = items.copy(likes = items.likes + 1)
                                }
                            }
                        }

                        ButtonType.EMOJI -> {
                            ImageWithButton(image = items.image) {
                                ButtonWithEmoji(
                                    likes = items.likes,
                                    dislikes = items.dislikes,
                                    onClickLikes = {
                                        imageList[index] = items.copy(likes = items.likes + 1)
                                    },
                                    onClickDisLikes = {
                                        imageList[index] = items.copy(dislikes = items.dislikes + 1)
                                    }
                                )
                            }
                        }
                    }
                }
            }
            AnimatedVisibility(visible = showButton) { // animation 적용
                ScrollToTopButton {
                    scope.launch {
                        state.scrollToItem(0) // top으로 이동해라(coroutineScope 내부에서만 사용 가능)
                    }
                }
            }
        }
    } else {
        LazyRow(
            modifier = Modifier.fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp), // 리스트 안의 항목들 사이의 간격 (Spacing) 을 설정
            contentPadding = PaddingValues(10.dp), // 전체 리스트 바깥쪽 여백 (Padding) 을 설정
        ) {
//            ImageList(imageList = imageList)
            itemsIndexed(imageList) {index, items ->
                when(items.buttonType) {
                    ButtonType.ICON -> {
                        ImageWithButton(image = items.image) {
                            ButtonWithIcon(likes = items.likes) {
                                imageList[index] = items.copy(likes = items.likes+1)
                            }
                        }
                    }
                    ButtonType.BADGE -> {
                        ImageWithButton(image = items.image) {
                            ButtonWithBadge(likes = items.likes) {
                                imageList[index] = items.copy(likes = items.likes+1)
                            }
                        }
                    }
                    ButtonType.EMOJI -> {
                        ImageWithButton(image = items.image) {
                            ButtonWithEmoji(
                                likes = items.likes,
                                dislikes = items.dislikes,
                                onClickLikes = {
                                    imageList[index] = items.copy(likes = items.likes+1)
                                },
                                onClickDisLikes = {
                                    imageList[index] = items.copy(dislikes = items.dislikes+1)
                                }
                            )
                        }
                    }
                }
            }
        }
    }

//    var img1State by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img1),
//                likes = 50 // 50이 기본값
//            )
//        )
//    }
//
//    var img2State by rememberSaveable(stateSaver = ImageData.imageSaver) {
//        mutableStateOf(
//            ImageData(
//                image = ImageUri.ResImage(R.drawable.img2),
//                buttonType = ButtonType.EMOJI,
//                likes = 50,
//                dislikes = 100
//            )
//        )
//    }
//
////    val img2State = rememberSaveable {
////        mutableStateOf(
////            ImageData( // 이모지 버튼 생성해오기
////                image = ImageUri.ResImage(R.drawable.img2),
////                buttonType = ButtonType.EMOJI,
////                likes = 100,
////                dislikes = 150
////            )
////        )
////    }
//
//    Column(
//        modifier = Modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//        ) {
////        AsyncImage(
////            model = image,
////            contentDescription = "이미지",
////            contentScale = ContentScale.Crop,
////            modifier = Modifier
////                .size(200.dp)
////                .clip(CircleShape)
////        )
//        ImageWithButton(image = img1State.image) {
//            ButtonWithBadge(likes = img1State.likes) {
//                img1State = img1State.copy(likes = img1State.likes+1)
//            }
//        }
//
//        ImageWithButton(image = img2State.image) {
//            ButtonWithEmoji(
//                likes = img2State.likes,
//                dislikes = img2State.dislikes,
//                onClickLikes = {
//                    img2State = img2State.copy(likes = img2State.likes+1)
//                },
//                onClickDisLikes = {
//                    img2State = img2State.copy(dislikes = img2State.dislikes+1)
//                }
//            )
//        }
//    }
}

@Preview
@Composable
private fun MainScreenPreview() {
    MainScreen()
}