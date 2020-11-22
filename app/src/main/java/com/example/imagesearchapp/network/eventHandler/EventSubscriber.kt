package com.example.imagesearchapp.network.eventHandler

interface EventSubscriber {
    fun onEvent(event: Event?)
}