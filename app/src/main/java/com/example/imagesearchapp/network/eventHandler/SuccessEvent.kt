package com.example.imagesearchapp.network.eventHandler

import com.example.imagesearchapp.network.eventHandler.Event.Companion.TYPE_SUCCESS

class SuccessEvent<T> : Event {
    override var isEdit = false
    private var result: T
    override var requestCode: Int
    override var pos: Int

    constructor(result: T, requestCode: Int, pos: Int) {
        this.result = result
        this.requestCode = requestCode
        this.pos = pos
    }

    constructor(
        result: T,
        requestCode: Int,
        pos: Int,
        isEdit: Boolean
    ) {
        this.result = result
        this.requestCode = requestCode
        this.pos = pos
        this.isEdit = isEdit
    }


    override val type: Int
        get() = TYPE_SUCCESS

    override fun <T> getResult(): T {
        return result as T
    }

    override val commentPos: Int
        get() = 0

}
