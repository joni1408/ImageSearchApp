package com.example.imagesearchapp.utils

import android.content.Context

object Toaster {
    fun show(context: Context, text: CharSequence) {
        val toast = android.widget.Toast.makeText(context, text, android.widget.Toast.LENGTH_SHORT)
//        toast.view.background.setColorFilter(
//            ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_IN
//        )
//        val textView = toast.view.findViewById(android.R.id.message) as TextView
//        textView.setTextColor(ContextCompat.getColor(context, R.color.black))
        toast.show()
    }
}