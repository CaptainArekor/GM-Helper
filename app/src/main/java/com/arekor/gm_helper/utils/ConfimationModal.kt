package com.arekor.gm_helper.utils

import android.app.AlertDialog
import android.content.Context

class ConfimationModal {
    companion object {
        fun showDialog(context: Context,title: String, message: String): Boolean {
            var returnResult = true
            val alertDialogBuilder = AlertDialog.Builder(context)
            alertDialogBuilder.setTitle(title)
            alertDialogBuilder.setMessage(message)
            alertDialogBuilder.setPositiveButton(android.R.string.yes) { dialog, which ->
                returnResult = true
            }
            alertDialogBuilder.setNegativeButton(android.R.string.no) { dialog, which ->
                returnResult = false
            }
            alertDialogBuilder.show()
            println(returnResult)
            return returnResult
        }
    }
}