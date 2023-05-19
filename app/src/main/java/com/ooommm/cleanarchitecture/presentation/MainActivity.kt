package com.ooommm.cleanarchitecture.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ooommm.cleanarchitecture.R

class MainActivity : AppCompatActivity() {


    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("AAA", "Activity  created")

        val dataTextView = findViewById<TextView>(R.id.data_text_view)
        val dataEditView = findViewById<EditText>(R.id.data_edit_text)
        val sendButton = findViewById<Button>(R.id.send_button)
        val receiveButton = findViewById<Button>(R.id.receive_button)

        vm = ViewModelProvider(this, MainViewModelFactory(this))[MainViewModel::class.java]

        vm.resultLiveData.observe(this, Observer {
            dataTextView.text = it
        })
        sendButton.setOnClickListener {
            val text = dataEditView.text.toString()
            vm.save(text)
        }
        receiveButton.setOnClickListener {
            vm.load()

        }
    }
}