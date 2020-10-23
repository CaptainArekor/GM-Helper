package com.arekor.gm_helper.utils

import android.view.View

class UIHelper {
    companion object{
        fun setViewVisible(view: View, visible: Boolean){
            if(visible){
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        }
    }
}