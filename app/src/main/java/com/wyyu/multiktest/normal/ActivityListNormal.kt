package com.wyyu.multiktest.normal

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wyyu.multiktest.app.Constants
import com.wyyu.multiktest.databinding.ActivityListNormalBinding
import com.wyyu.multiktest.normal.adapter.ListNormalAdapter
import com.wyyu.multiktest.normal.data.DataNormal

/**
 * Created by wyyu on 2021/7/30.
 **/

class ActivityListNormal : AppCompatActivity() {

    companion object {
        fun open(context: Context) {
            context.startActivity(Intent(context, ActivityListNormal::class.java))
        }
    }

    private var binding: ActivityListNormalBinding? = null

    private var adapter: ListNormalAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListNormalBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initActivity()
    }

    private fun initActivity() {
        initList()
        loadList()
    }

    private fun initList() {
        adapter = ListNormalAdapter()

        binding?.listNormalRecycler?.adapter = adapter
        binding?.listNormalRecycler?.layoutManager = LinearLayoutManager(this)
    }

    private fun loadList() {
        val list = ArrayList<DataNormal>()
        for (index in 0 until Constants.COUNT) {
            list.add(DataNormal(index))
        }
        adapter?.initList(list)
    }
}