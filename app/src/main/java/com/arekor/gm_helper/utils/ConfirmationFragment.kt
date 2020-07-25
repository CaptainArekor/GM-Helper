package com.arekor.gm_helper.utils

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_confirmation.view.*

class ConfirmationFragment : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)
        view.confirmation_modal_confirm_button.setOnClickListener{
            dismiss()
        }
        view.confirmation_modal_cancel_button.setOnClickListener{
            dismiss()
        }
        return view
    }
}