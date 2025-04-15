package com.example.cweek05a.model

import androidx.compose.runtime.mutableStateListOf
import com.example.cweek05a.R

object ImageListFactory {
    fun makeImageList() = mutableStateListOf(
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            likes = 50 // 50이 기본값
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.EMOJI,
            likes = 50,
            dislikes = 100
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.ICON,
            likes = 100
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            likes = 70
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.EMOJI,
            likes = 20,
            dislikes = 100
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.ICON,
            likes = 300
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img1),
            likes = 80
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img2),
            buttonType = ButtonType.EMOJI,
            likes = 20,
            dislikes = 700
        ),
        ImageData(
            image = ImageUri.ResImage(R.drawable.img3),
            buttonType = ButtonType.ICON,
            likes = 200
        ),
    )
}