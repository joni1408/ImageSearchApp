package com.example.imagesearchapp.network.eventHandler

import com.example.imagesearchapp.network.eventHandler.Event.Companion.TYPE_ERROR

class ErrorEvent : Event {
    var result: Throwable
    override var requestCode = 0
    override var pos = 0
    override var commentPos = 0

    constructor(
        throwable: Throwable,
        requestCode: Int,
        pos: Int,
        commentPos: Int
    ) {
        result = throwable
        this.requestCode = requestCode
        this.pos = pos
        this.commentPos = commentPos
    }

    constructor(throwable: Throwable) {
        result = throwable
    }

    override val type: Int
        get() = TYPE_ERROR

    override fun <T> getResult(): T? {
        return null
    }

    override val isEdit: Boolean
        get() = false
}
