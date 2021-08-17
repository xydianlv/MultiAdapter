package com.wyyu.multiktest.cell_class

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wyyu.multi.cell.ClassCellManager
import com.wyyu.multiktest.app.Constants
import com.wyyu.multiktest.cell_class.adapter.ListClassAdapter
import com.wyyu.multiktest.cell_class.data.DataClassA
import com.wyyu.multiktest.cell_class.data.DataClassB
import com.wyyu.multiktest.cell_class.holder.HolderClassA
import com.wyyu.multiktest.cell_class.holder.HolderClassB
import com.wyyu.multiktest.cell_class.holder.HolderClassJ
import com.wyyu.multiktest.databinding.ActivityListClassBinding

/**
 * Created by wyyu on 2021/7/30.
 **/

class ActivityListClass : AppCompatActivity() {

    companion object {

        fun open(context: Context) {
            context.startActivity(Intent(context, ActivityListClass::class.java))
        }
    }

    private var binding: ActivityListClassBinding? = null
    private var adapter: ListClassAdapter<Class<out Any>, Any>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListClassBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        initActivity()
    }

    private fun initActivity() {
        initView()
        loadList()
    }

    private fun initView() {
        if (binding == null) {
            return
        }
        adapter = ListClassAdapter(ClassCellManager(), binding!!.listClassRecycler)
        adapter!!.registerItem(DataClassA::class.java, HolderClassJ())
        adapter!!.registerItem(DataClassB::class.java, HolderClassJ())

        binding?.listClassRecycler?.layoutManager = LinearLayoutManager(this)
        binding?.listClassRecycler?.adapter = adapter
    }

    private fun loadList() {
        val list = ArrayList<Any>()
        for (index in 0 until Constants.COUNT) {
            if (index % 2 == 0) {
                list.add(DataClassA(index))
            } else {
                list.add(DataClassB(index))
            }
        }
        adapter?.initList(list)
    }
}