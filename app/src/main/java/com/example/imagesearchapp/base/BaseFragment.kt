package com.example.imagesearchapp.base

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.imagesearchapp.application.ImageSearchApplication
import com.example.imagesearchapp.di.components.DaggerFragmentComponent
import com.example.imagesearchapp.di.components.FragmentComponent
import com.example.imagesearchapp.di.modules.FragmentModule
import com.example.imagesearchapp.utils.LoadingDialog
import com.example.imagesearchapp.utils.Toaster
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildFragmentComponent())
        super.onCreate(savedInstanceState)
        setupObservers()
        viewModel.onCreate()
    }

    private fun buildFragmentComponent() =
        DaggerFragmentComponent
            .builder()
            .applicationComponent((context?.applicationContext as ImageSearchApplication).applicationComponent)
            .fragmentModule(FragmentModule(this))
            .build()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(provideLayoutId(), container, false)

    protected open fun setupObservers() {
        viewModel.messageString.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })

        viewModel.messageStringId.observe(this, Observer {
            it.data?.run { showMessage(this) }
        })
        viewModel.showDialog.observe(this, Observer {
            if (it) {
                LoadingDialog.showDialog()
            } else {
                LoadingDialog.dismissDialog()
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView(view)
    }


    fun showMessage(message: String) = context?.let { Toaster.show(it, message) }

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    fun goBack() {
        if (activity is BaseActivity<*>) (activity as BaseActivity<*>).goBack()
    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(fragmentComponent: FragmentComponent)

    protected abstract fun setupView(view: View)

    open fun disableDoubleTap(v: View) {
        v.isEnabled = false
        Handler().postDelayed({ v.isEnabled = true }, 1000)
    }

    fun showKeyboard(view: View) {
        view.requestFocus()
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

}