package com.bestgoodmove.multlingual
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        button_chinese.setOnClickListener(View.OnClickListener {
            Helper.updateResources(this@MainActivity, "zh")

            recreate()
        })

        button_tamil.setOnClickListener(View.OnClickListener {
            Helper.updateResources(this@MainActivity, "ta")

            recreate()
        })

        button_first.setOnClickListener(View.OnClickListener {
            Helper.updateResources(this@MainActivity, "en")

            recreate()
        })

    }

}
