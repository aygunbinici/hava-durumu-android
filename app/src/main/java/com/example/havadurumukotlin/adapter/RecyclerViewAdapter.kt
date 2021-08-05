package com.example.havadurumukotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.havadurumukotlin.R
import com.example.havadurumukotlin.downloadFromUrl
import com.example.havadurumukotlin.model.DataResult
import com.example.havadurumukotlin.placeholderProgressBar
import kotlinx.android.synthetic.main.item_row.view.*

class RecyclerViewAdapter(val HavaList:ArrayList<DataResult>): RecyclerView.Adapter<RecyclerViewAdapter.HavaViewHolder>() {

     class HavaViewHolder(var view: View):RecyclerView.ViewHolder(view) {

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HavaViewHolder {
         val inflater= LayoutInflater.from(parent.context)
         val view = inflater.inflate(R.layout.item_row,parent,false)
         return HavaViewHolder(view)
     }

     override fun getItemCount(): Int {
         return HavaList.size
     }

     override fun onBindViewHolder(holder: HavaViewHolder, position: Int) {

         holder.view.day.text=HavaList[position].day
         holder.view.derece.text=HavaList[position].degree

         holder.view.foto.downloadFromUrl(HavaList[position].icon, placeholderProgressBar(holder.view.context))


     }

    fun updateCountyList(newCountryList:List<DataResult>){
        HavaList.clear()
        HavaList.addAll(newCountryList)
        notifyDataSetChanged() //adaptörü yenilemek için kullandığımız metod
    }


 }
