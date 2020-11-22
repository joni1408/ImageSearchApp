package com.example.imagesearchapp.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagesearchapp.R
import com.example.imagesearchapp.callback.Resource
import com.example.imagesearchapp.rx.SchedulerProvider
import com.example.imagesearchapp.utils.NetworkHelper
import io.reactivex.disposables.CompositeDisposable
import java.net.HttpURLConnection
import javax.net.ssl.HttpsURLConnection

abstract class BaseViewModel(
    val schedulerProvider: SchedulerProvider,
    val compositeDisposable: CompositeDisposable,
    val networkHelper: NetworkHelper
) : ViewModel() {

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    val messageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    val messageString: MutableLiveData<Resource<String>> = MutableLiveData()
    val showDialog: MutableLiveData<Boolean> = MutableLiveData()
    val logMessageStringId: MutableLiveData<Resource<Int>> = MutableLiveData()
    val logMessageString: MutableLiveData<Resource<String>> = MutableLiveData()

    protected fun checkInternetConnectionWithMessage(): Boolean =
        if (networkHelper.isNetworkConnected()) {
            showDialog.postValue(true)
            true
        } else {
            messageStringId.postValue(Resource.error(R.string.network_connection_error))
            showDialog.postValue(false)
            false
        }

    protected fun checkInternetConnectionWithMessage(isDialogShow: Boolean): Boolean =
        if (networkHelper.isNetworkConnected()) {
            if (isDialogShow)
                showDialog.postValue(true)
            true
        } else {
            messageStringId.postValue(Resource.error(R.string.network_connection_error))
            if (isDialogShow)
                showDialog.postValue(false)
            false
        }

    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()

    protected fun handleNetworkError(err: Throwable?) =
        err?.let {
            networkHelper.castToNetworkError(it).run {
                when (status) {
                    -1 -> logMessageStringId.postValue(Resource.error(R.string.network_default_error))
                    0 -> logMessageStringId.postValue(Resource.error(R.string.server_connection_error))
                    HttpsURLConnection.HTTP_UNAUTHORIZED -> {
                        logMessageStringId.postValue(Resource.error(R.string.permission_denied))
                    }
                    HttpsURLConnection.HTTP_INTERNAL_ERROR ->
                        logMessageStringId.postValue(Resource.error(R.string.network_internal_error))
                    HttpURLConnection.HTTP_BAD_GATEWAY ->
                        logMessageStringId.postValue(Resource.error(R.string.network_internal_error))
                    HttpsURLConnection.HTTP_UNAVAILABLE ->
                        logMessageStringId.postValue(Resource.error(R.string.network_server_not_available))
                    HttpsURLConnection.HTTP_NO_CONTENT ->
                        logMessageStringId.postValue(Resource.error(R.string.no_content))

                }
            }
        }

    abstract fun onCreate()
}