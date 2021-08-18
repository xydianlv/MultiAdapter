package com.wyyu.multiktest.cell_Integer

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.wyyu.multiktest.app.Constants
import com.wyyu.multiktest.cell_Integer.adapter.IntegerCellManager
import com.wyyu.multiktest.cell_Integer.adapter.ListIntegerAdapter
import com.wyyu.multiktest.cell_Integer.data.DataIntegerA
import com.wyyu.multiktest.cell_Integer.data.DataIntegerB
import com.wyyu.multiktest.cell_Integer.data.IDataInteger
import com.wyyu.multiktest.cell_Integer.holder.HolderIntegerA
import com.wyyu.multiktest.cell_Integer.holder.HolderIntegerB
import com.wyyu.multiktest.databinding.ActivityListIntegerBinding

class ActivityListInteger : AppCompatActivity() {

    companion object {

        fun open(context: Context) {
            context.startActivity(Intent(context, ActivityListInteger::class.java))
        }
    }

    private var binding: ActivityListIntegerBinding? = null
    private var adapter: ListIntegerAdapter<Int, IDataInteger>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListIntegerBinding.inflate(layoutInflater)
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
        adapter = ListIntegerAdapter(IntegerCellManager(), binding!!.listIntegerRecycler)
        adapter!!.registerItem(IDataInteger.DATA_A, HolderIntegerA())
        adapter!!.registerItem(IDataInteger.DATA_B, HolderIntegerB())

        binding?.listIntegerRecycler?.layoutManager = LinearLayoutManager(this)
        binding?.listIntegerRecycler?.adapter = adapter
    }

    private fun loadList() {
        val list = ArrayList<IDataInteger>()
        for (index in 0 until Constants.COUNT) {
            if (index % 2 == 0) {
                list.add(DataIntegerA(index))
            } else {
                list.add(DataIntegerB(index))
            }
        }
        adapter?.initList(list)
    }
}