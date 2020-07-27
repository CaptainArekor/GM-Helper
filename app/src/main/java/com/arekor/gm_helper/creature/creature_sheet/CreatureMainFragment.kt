package com.arekor.gm_helper.creature.creature_sheet

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_creature_main.*
import kotlinx.android.synthetic.main.fragment_creature_main.view.*
import com.arekor.gm_helper.R


class CreatureMainFragment : Fragment() {

    lateinit var creatureView : View
    private val REQUEST_CODE = 100
    lateinit var model : CreatureSheetViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(requireActivity()).get(CreatureSheetViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creatureView = inflater.inflate(R.layout.fragment_creature_main, container, false)
        creatureView.creature_sheet_image.setOnClickListener {
            permissionCheck()
        }
        creatureView.creature_sheet_name_text.setOnFocusChangeListener{ view: View, b: Boolean ->
            //model.currentCreature.name = (view as EditText).text.toString()
            val newName = (view as EditText).text.toString()
            model.setName( newName )
        }

        creatureView.creature_sheet_name_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                model.setName( s.toString() )
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setName( s.toString() )
            }
        })
        return creatureView
    }

    private fun permissionCheck(){
        //check runtime permission
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED
        ) {
            //permission denied
            val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE);
            //show popup to request runtime permission
            requestPermissions(permissions, REQUEST_CODE)
        } else {
            //permission already granted
            openGalleryForImage()
        }
    }

    private fun openGalleryForImage() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE){
            creature_sheet_image.setImageURI(data?.data) // handle chosen image
            creature_sheet_image.setPadding(0,0,0,0)
        }
    }
}