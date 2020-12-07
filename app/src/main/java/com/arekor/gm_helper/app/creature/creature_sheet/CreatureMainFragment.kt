package com.arekor.gm_helper.app.creature.creature_sheet

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
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_creature_main.*
import kotlinx.android.synthetic.main.fragment_creature_main.view.*
import com.arekor.gm_helper.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation


class CreatureMainFragment : Fragment() {

    private lateinit var creatureView: View
    private val REQUEST_CODE = 100
    private lateinit var model: CreatureSheetViewModel
    private var comment_state = View.GONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = ViewModelProviders.of(requireActivity()).get(CreatureSheetViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        creatureView = inflater.inflate(R.layout.fragment_creature_main, container, false)
        setActions()
        return creatureView
    }

    private fun setActions() {
        creatureView.creature_sheet_image.setOnClickListener {
            permissionCheck()
        }
        creatureView.creature_sheet_name_text.setOnFocusChangeListener { view: View, _: Boolean ->
            //model.currentCreature.name = (view as EditText).text.toString()
            val newName = (view as EditText).text.toString()
            model.setName(newName)
        }

        creatureView.creature_sheet_name_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                model.setName(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                model.setName(s.toString())
            }
        })

        creatureView.creature_sheet_comment_text.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                model.setComment(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                model.setComment(p0.toString())
            }

        })

        creatureView.creature_sheet_main_expand.setOnClickListener {
            when (comment_state) {
                View.GONE -> {
                    val newVisibility = View.VISIBLE
                    creatureView.creature_sheet_main_comment_fragment.visibility = newVisibility
                    comment_state = newVisibility
                    creatureView.creature_sheet_main_expand.setImageResource(R.drawable.ic_baseline_expand_more_24)
                }
                View.VISIBLE -> {
                    val newVisibility = View.GONE
                    creatureView.creature_sheet_main_comment_fragment.visibility = newVisibility
                    comment_state = newVisibility
                    creatureView.creature_sheet_main_expand.setImageResource(R.drawable.ic_baseline_expand_less_24)
                }
            }
        }
    }

    private fun permissionCheck() {
        //check runtime permission
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_DENIED
        ) {
            //permission denied
            val permissions = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
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

    private fun loadImage(image : String){
        Picasso.get()
            .load(image)
            .fit()
            .transform(RoundedCornersTransformation(45, 0))
            .into(creature_sheet_image)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            loadImage(data?.data.toString())
            //val image = ImageWorker.urlToBitMap(data?.data.toString())
            //creatureView.creature_sheet_image.setImageBitmap(image)
        }
    }
}