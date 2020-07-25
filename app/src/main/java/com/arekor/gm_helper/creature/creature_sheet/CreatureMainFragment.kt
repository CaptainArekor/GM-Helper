package com.arekor.gm_helper.creature.creature_sheet

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.arekor.gm_helper.R
import kotlinx.android.synthetic.main.fragment_creature_main.*
import kotlinx.android.synthetic.main.fragment_creature_main.view.*

class CreatureMainFragment : Fragment() {

    lateinit var creatureView : View
    private val REQUEST_CODE = 100

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creatureView = inflater.inflate(R.layout.fragment_creature_main, container, false)
        creatureView.creature_sheet_image.setOnClickListener {
            permissionCheck()
        }
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