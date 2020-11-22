package com.example.imagesearchapp.network.eventHandler

import com.example.imagesearchapp.network.eventHandler.Event.Companion.TYPE_COMPLETION

class CompletionEvent : Event {
    override var requestCode: Int = 0

    constructor(requestCode: Int) {
        this.requestCode = requestCode
    }

    constructor()

    override val type: Int
        get() = TYPE_COMPLETION

    override fun <T> getResult(): T? {
        return null
    }

    override val pos: Int
        get() = 0

    override val commentPos: Int
        get() = 0

    override val isEdit: Boolean
        get() = false

}
