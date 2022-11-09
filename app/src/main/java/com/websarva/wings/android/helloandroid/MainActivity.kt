package com.websarva.wings.android.helloandroid


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btClick = findViewById<Button>(R.id.btClick)

        val listener = HelloListener()

        btClick.setOnClickListener(listener)

        val btClear = findViewById<Button>(R.id.btClear)

        btClear.setOnClickListener(listener)
    }

    private inner class HelloListener: View.OnClickListener{
        override fun onClick(view: View) {
            val input = findViewById<EditText>(R.id.etName)
            val raddioGroup = findViewById<RadioGroup>(R.id.)
            val output = findViewById<TextView>(R.id.tvOutput)

            when(view.id){
                R.id.btClick -> {
                    val inputStr = input.text.toString()
                    output.text = "Welcome to " + inputStr + " さん！"
                }

                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }
        }
    }
}
