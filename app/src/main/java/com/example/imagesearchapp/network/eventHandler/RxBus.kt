package com.example.imagesearchapp.network.eventHandler

import android.util.Log
import io.reactivex.Observer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class RxBus : EventBus {
    private val subject: Subject<Event> =
        PublishSubject.create()
    private val disposable = CompositeDisposable()
    override fun subscribe(subscriber: EventSubscriber?) {
        subject.subscribe(object : Observer<Event?> {
            override fun onSubscribe(d: Disposable) {
                disposable.add(d)
            }

            override fun onNext(event: Event) {
                try {
                    subscriber?.onEvent(event)
                } catch (e: Exception) {
                    e.message?.let { Log.e(this.javaClass.name, it) }
                }
            }

            override fun onError(e: Throwable) {
                subscriber?.onEvent(ErrorEvent(e))
                e.message?.let { Log.e(this.javaClass.name, it) }
            }

            override fun onComplete() {
                subscriber?.onEvent(CompletionEvent())
            }
        })
    }

    override fun unsubscribe() {
        disposable.dispose()
    }

    override fun onNext(event: Event?) {
        try {
            event?.let { subject.onNext(it) }
        } catch (t: Throwable) {
            t.message?.let { Log.e(this.javaClass.name, it) }
        }
    }

    override fun onError(event: Event?) {
        event?.let { subject.onNext(it) }
    }

    override fun onCompletion(event: Event?) {
        event?.let { subject.onNext(it) }
    }
}
