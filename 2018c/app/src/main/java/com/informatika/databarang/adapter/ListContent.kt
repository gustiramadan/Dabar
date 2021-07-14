package com.informatika.databarang.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.informatika.databarang.R
import com.informatika.databarang.model.DataItem


class ListContent (val ldata:List<DataItem?>?, val context: Context):
    RecyclerView.Adapter<ListContent.ViewHolder>(){
    class ViewHolder(val view: View ) : RecyclerView.ViewHolder(view){
        val namaBarang = view.findViewById<TextView>(R.id.tv_nama_barang)
        val jmlBarang = view.findViewById<TextView>(R.id.tv_jumlah_barang)
        val editBarang = view.findViewById<TextView>(R.id.tv_edit)
        val deleteBarang = view.findViewById<TextView>(R.id.tv_delete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_barang, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ldata!!.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = ldata?.get(position)
        holder.namaBarang.text = model?.namaBarang
        holder.jmlBarang.text = model?.jumlahBarang
        holder.editBarang.setOnClickListener {
            val i = Intent(context, UpdateDataAktivity::class.java)
            i.putExtra("IDBARANG",model?.id)
            i.putExtra("NAMABARANG", model?.namaBarang)
            i.putExtra("JMLBARANG", model?.jumlahBarang)
            context.startActivities(i)


        }

    }
}
