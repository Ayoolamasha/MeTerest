package com.ayoolamasha.meterest.utlis

import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun rawDateToString(rawData: String?): String {

    return try {
        val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss-h:mm")
        val output = SimpleDateFormat("dd/MM/yyyy")

        val d: Date? = input.parse(rawData)

        output.format(d)

    } catch (e: ParseException) {
        e.localizedMessage
    }


}

//internal fun notifyWithAction(
//    @StringRes message: Int,
//    @StringRes actionText: Int,
//    action: () -> Any
//) {
//    val snackBar = Snackbar.make(viewContainer, message, Snackbar.LENGTH_INDEFINITE)
//    snackBar.setAction(actionText) { _ -> action.invoke() }
//    snackBar.setActionTextColor(ContextCompat.getColor(appContext, color.colorTextPrimary))
//    snackBar.show()
//}

fun String.Companion.empty() = ""



