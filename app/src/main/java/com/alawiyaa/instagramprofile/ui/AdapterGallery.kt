package com.alawiyaa.instagramprofile.ui

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alawiyaa.instagramprofile.R
import com.alawiyaa.instagramprofile.data.remote.response.EdgesItem
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_image.view.*

class AdapterGallery(private val listGallery:ArrayList<EdgesItem>):RecyclerView.Adapter<AdapterGallery.MyGallery>() {

    private var onItemClickCallBack:GalleryListener? = null
    fun setOnItemClickCallback(onItemClickCallback:GalleryListener){
        this.onItemClickCallBack = onItemClickCallback
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyGallery {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_image,parent,false)
        return MyGallery(view)
    }

    override fun getItemCount(): Int {
        return listGallery.size
    }

    override fun onBindViewHolder(holder: MyGallery, position: Int) {
       val items = listGallery[position]
        val ctx = holder.itemView.context
        holder.bind(items)

        holder.itemView.setOnClickListener {
            onItemClickCallBack?.onItemClick(items)

        }
    }
    inner class MyGallery(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(gallery:EdgesItem){
            with(itemView){
                Glide.with(context).load(gallery.node?.displayUrl).apply(RequestOptions().override(100,100))
                    .into(imgGallery)
            }

        }

    }
    interface GalleryListener {
        fun onItemClick(gallery:EdgesItem)
    }

}