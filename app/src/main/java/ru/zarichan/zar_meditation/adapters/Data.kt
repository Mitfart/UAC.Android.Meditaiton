package ru.zarichan.zar_meditation.adapters

import ru.zarichan.zar_meditation.R

data class Feel(val image: Int, val nameFeel: String)
class Feels {
    val list = arrayListOf(
        Feel(R.drawable.ic_frown, "Грустный"),
        Feel(R.drawable.ic_coffee, "Кофеёк"),
        Feel(R.drawable.ic_award, "Победитель"),
        Feel(R.drawable.ic_lightning, "Грозовое облако")
    )
}

data class Post(val title: String, val description: String, val image: Int)
class Posts {
    val list = arrayListOf(
        Post("Заголовок", "Краткое описание", R.drawable.post_img_1),
        Post("Заголовок", "Краткое описание", R.drawable.post_img_1),
        Post("Заголовок", "Краткое описание", R.drawable.post_img_1)
    )
}
