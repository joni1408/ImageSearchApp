package com.example.imagesearchapp.ui.searchImage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.imagesearchapp.R
import com.example.imagesearchapp.models.Data
import kotlinx.android.synthetic.main.layout_search_image_details.view.*

class ImagesAdapter(var onImageSelected: (Data, Int) -> Unit) :
    RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_search_image_details,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(if (!image.is_album !!) ("https://i.imgur.com/".plus(image.id)).plus("s.jpg") else ("https://i.imgur.com/".plus(image.cover)).plus("s.jpg"))
                .fitCenter()
                .diskCacheStrategy(
                    DiskCacheStrategy.ALL)
                .error(R.drawable.ic_action_image)
                .placeholder(R.drawable.ic_action_image)
                .into(img_imageIcon );
            holder.itemView.setOnClickListener {
                onImageSelected(image, position)
            }

        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.link == newItem.link
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }


}