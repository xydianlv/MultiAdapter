package com.wyyu.multiktest.normal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.wyyu.multiktest.databinding.ActivityListNormalBinding

/**
 * Created by wyyu on 2021/7/30.
 **/

class ActivityListNormal : AppCompatActivity() {

    companion object {
        fun open(context: Context) {
            context.startActivity(Intent(context, ActivityListNormal::class.java))
        }
    }

    private var binding: ActivityListNormalBinding =
        ActivityListNormalBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(binding.root)

        initActivity()
    }

    private fun initActivity() {

    }
}