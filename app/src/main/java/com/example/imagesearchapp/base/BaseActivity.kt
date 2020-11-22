package com.example.imagesearchapp.base

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.imagesearchapp.application.ImageSearchApplication
import com.example.imagesearchapp.di.component.ActivityComponent
import com.example.imagesearchapp.di.component.DaggerActivityComponent
import com.example.imagesearchapp.di.modules.ActivityModule
import com.example.imagesearchapp.utils.LoadingDialog
import com.example.imagesearchapp.utils.Toaster
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {
    @Inject
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        injectDependencies(buildActivityComponent())
        super.onCreate(savedInstanceState)
        setContentView(provideLayoutId())
        setupObservers()
        setupView(savedInstanceState)
        viewModel.onCreate()
    }

    private fun buildActivityComponent() =
        DaggerActivityComponent
            .builder()
            .applicationComponent((application as ImageSearchApplication).applicationComponent)
            .activityModule(ActivityModule(this))
            .build()

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
        viewModel.logMessageString.observe(this, Observer {
            Log.d(this@BaseActivity.toString(), it.data)
        })

    }

    fun showMessage(message: String) = Toaster.show(applicationContext, message)

    fun showMessage(@StringRes resId: Int) = showMessage(getString(resId))

    open fun goBack() = onBackPressed()

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0)
            supportFragmentManager.popBackStackImmediate()
        else super.onBackPressed()
    }

    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }

    @LayoutRes
    protected abstract fun provideLayoutId(): Int

    protected abstract fun injectDependencies(activityComponent: ActivityComponent)

    protected abstract fun setupView(savedInstanceState: Bundle?)

    protected abstract fun setupView(view: View)
}