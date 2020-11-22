package com.example.imagesearchapp.network.eventHandler

interface Event {
    val type: Int

    fun <T> getResult(): T?
    val requestCode: Int
    val pos: Int
    val commentPos: Int
    val isEdit: Boolean

    companion object {
        const val TYPE_SUCCESS = 1
        const val TYPE_ERROR = 2
        const val TYPE_COMPLETION = 3
    }
}
