package com.websarva.wings.android.helloandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btClick = findViewById<Button>(R.id.btClick)
        val listener = HelloListener()
        btClick.setOnClickListener(listener)

        val btClear = findViewById<Button>(R.id.btClear)
        btClear.setOnClickListener(listener)

        val radioGroup = findViewById<RadioGroup>(R.id.radio_group)
        val radio = RadioListener()
        radioGroup.setOnCheckedChangeListener(radio)
    }

    var gender = ""

    private inner class RadioListener: RadioGroup.OnCheckedChangeListener{
        override fun onCheckedChanged(rg: RadioGroup, checkedRadioButtonId: Int) {
            val radioButton = findViewById<RadioButton>(checkedRadioButtonId)

            when(radioButton.text){
                "男" -> {
                    gender = "Mr."
                }
                "女" -> {
                    gender = "Ms."
                }
            }
        }

    }

    private inner class HelloListener: View.OnClickListener{
        override fun onClick(view: View) {
            val input = findViewById<EditText>(R.id.etName)
            val output = findViewById<TextView>(R.id.tvOutput)

            when(view.id){
                R.id.btClick -> {
                    val inputStr = input.text.toString()
                    when(inputStr) {
                        "" -> {
                            output.text = "お名前を入力してください！"
                        }
                        else -> {
                            output.text = "Welcome to " + gender + inputStr + "!!!"
                        }
                    }
                }

                R.id.btClear -> {
                    input.setText("")
                    output.text = ""
                }
            }
        }
    }
}
