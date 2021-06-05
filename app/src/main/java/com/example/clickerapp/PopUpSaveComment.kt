package com.example.clickerapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment


class PopUpSaveComment : DialogFragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.activity_pop_up_save_comment, container, false)

        rootView.findViewById<Button>(R.id.btn_PopUpSaveRes).setOnClickListener {
            var enterText = rootView.findViewById<EditText>(R.id.ed_PopUpComment).text.toString()
            Toast.makeText(context, "$enterText", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return rootView
    }



}