package com.example.projeto001.utils

import android.app.Activity
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

import com.example.projeto001.R
import com.example.projeto001.ui.MainActivity
import com.google.android.material.snackbar.Snackbar

fun Fragment.snackBar(view: View, @StringRes resId: Int) {
    setupSnackBar(view, resId, R.color.red).apply {
        this.show()
    }
}

private fun Fragment.setupSnackBar(
    v: View,
    @StringRes resId: Int,
    @ColorRes color: Int
): Snackbar {
    return Snackbar.make(v, resId, Snackbar.LENGTH_LONG).apply {
        view.setBackgroundColor(ContextCompat.getColor(context, color))
        view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).apply {
            gravity = Gravity.CENTER
            textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
    }
}

fun AppCompatActivity.snackBarAcivity(view: View, @StringRes resId: Int) {
    setupSnackBar(view, resId, R.color.red).apply {
        this.show()
    }
}
private fun AppCompatActivity.setupSnackBar(
    v: View,
    @StringRes resId: Int,
    @ColorRes color: Int
): Snackbar {
    return Snackbar.make(v, resId, Snackbar.LENGTH_LONG).apply {
        view.setBackgroundColor(getColor(color))
        view.findViewById<TextView>(com.google.android.material.R.id.snackbar_text).apply {
            gravity = Gravity.CENTER
            textAlignment = View.TEXT_ALIGNMENT_CENTER
        }
    }
}
