package ru.zarichan.zar_meditation.net

data class Login(
    val id: String,
    val email: String,
    val nickName: String,
    val avatar: String,
    val token: String
)


data class NetFeels(val success: Boolean, val data: ArrayList<DataFeel>)

data class DataFeel(val id: Int, val title: String, val image: String, val position: Int)


data class NetQuotes(val success: Boolean, val data: ArrayList<DataQuote>)

data class DataQuote(val id: Int, val title: String, val image: String, val description: String)