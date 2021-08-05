package com.wyyu.multiktest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.wyyu.multiktest.cell_class.ActivityListClass
import com.wyyu.multiktest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initActivity()
    }

    private fun initActivity() {
        val clickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.click_normal -> {

                }
                R.id.click_cell_class -> {
                    ActivityListClass.open(this@MainActivity)
                }
                R.id.click_cell_integer -> {

                }
            }
        }
        binding?.clickNormal?.setOnClickListener(clickListener)
        binding?.clickCellClass?.setOnClickListener(clickListener)
        binding?.clickCellInteger?.setOnClickListener(clickListener)
    }
}