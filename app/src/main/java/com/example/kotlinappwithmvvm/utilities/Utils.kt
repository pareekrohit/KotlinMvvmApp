package com.example.kotlinappwithmvvm.utilities

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.kotlinappwithmvvm.data.network.Resource
import com.google.android.material.snackbar.Snackbar

enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}

fun Activity.handleApiError(
    failure: Resource.Failure,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetworkError -> /*requireView().snackbar(
            "Please check your internet connection",
            retry
        )*/Toast.makeText(this, "Please check your internet connection", Toast.LENGTH_SHORT).show()
        failure.errorCode == 401 -> {
            Toast.makeText(this, "${failure.errorCode}", Toast.LENGTH_SHORT).show()
        }

        else -> {
            val error = failure.errorBody?.string().toString()
            /*requireView().snackbar(error)*/
            Toast.makeText(this, "{$error}", Toast.LENGTH_SHORT).show()
        }
    }
}


fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}


fun View.enable(enabled: Boolean) {
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
}


fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}


/*fun Context.toast(message:String){
    Toast.makeText(this, message , Toast.LENGTH_LONG).show()
}*/
