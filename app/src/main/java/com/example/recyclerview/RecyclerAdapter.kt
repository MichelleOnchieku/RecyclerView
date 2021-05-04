package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var title =arrayOf("Canada","Kenya","Jamaica","Bali","USA","UK","Tanzania","Zanzibar")

    private var details =arrayOf("NORTH AMERICA","AFRICA","NORTH AMERICA","ASIA","NORTH AMERICA",
    "EUROPE","AFRICA","AFRICA")

    private var images = intArrayOf(R.drawable.canada,R.drawable.kenya,R.drawable.jamaica,R.drawable.bali,
        R.drawable.us, R.drawable.uk,R.drawable.tanzania,R.drawable.zanzibar)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
       val v =LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return title.size

    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = title[position]
        holder.itemDetail.text= details[position]
        holder.itemImage.setImageResource(images[position])
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemTitle:TextView
        var itemDetail:TextView

        init {
            itemImage= itemView.findViewById(R.id.item_image)
            itemTitle=itemView.findViewById(R.id.item_title)
            itemDetail=itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(itemView.context,"You clicked on ${title[position]}", Toast.LENGTH_LONG).show()
            }
        }
    }
}