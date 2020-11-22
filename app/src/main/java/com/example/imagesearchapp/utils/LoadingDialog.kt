package com.example.imagesearchapp.utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.example.imagesearchapp.R

class LoadingDialog(context: Context) : Dialog(context),
    DialogInterface.OnShowListener {
    private var mActivity: Activity? = null
    private var SHOWS = 0
    private var ivLoader: ImageView? = null

    constructor(activity: Activity) : this(activity as Context) {
        mActivity = activity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
        tvStatus = findViewById(R.id.tvStatus)
        ivLoader = findViewById(R.id.iv_loader)
        //        Glide.with(getContext())
//                .asGif()
//                .load(R.drawable.ezgif_loader)
//                .into(ivLoader);
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        setOnShowListener(this)
    }

    override fun onShow(dialog: DialogInterface) {
        try {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        } catch (e: Exception) {
            Log.e(this.javaClass.name, e.message.toString())
        }
    }

    companion object {
        private var INSTANCE: LoadingDialog? = null
        private var isShowPending = false
        private var tvStatus: TextView? = null
        fun bindWith(activity: Activity) {
            if (INSTANCE == null) {
                INSTANCE = LoadingDialog(activity)
            } else {
                if (INSTANCE != null && (INSTANCE?.isShowing!!)) INSTANCE?.dismiss()
                INSTANCE = LoadingDialog(activity)
                if (isShowPending) {
                    isShowPending = false
                    showDialog()
                }
            }
        }

        fun unbind() {
            if (INSTANCE != null && (INSTANCE?.isShowing!!)) INSTANCE?.dismiss()
            INSTANCE = null
        }

        fun showDialog() {
            if (INSTANCE != null) {
                if (!INSTANCE?.isShowing!! && INSTANCE?.SHOWS!! < 1) INSTANCE?.show()
                INSTANCE!!.SHOWS++
            } else {
                isShowPending = true
            }
        }

        fun dismissDialog() {
            if (INSTANCE != null) {
                if ((INSTANCE?.isShowing!!) && INSTANCE?.SHOWS!! <= 1) INSTANCE?.dismiss()
                INSTANCE!!.SHOWS--
            }
        }
    }
}