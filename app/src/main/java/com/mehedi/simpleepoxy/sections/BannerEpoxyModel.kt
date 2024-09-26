package com.mehedi.simpleepoxy.sections

import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.mehedi.simpleepoxy.Banner
import com.mehedi.simpleepoxy.R

class BannerEpoxyModel(private val banner: Banner) : EpoxyModelWithHolder<BannerEpoxyModel.BannerViewHolder>() {
    
    override fun getDefaultLayout(): Int = R.layout.item_banner
    
    override fun createNewHolder(parent: ViewParent): BannerViewHolder = BannerViewHolder()
    
    override fun bind(holder: BannerViewHolder) {
        // Load image into ImageView using Glide or Picasso
         Glide.with(holder.bannerImageView.context).load(banner.imageUrl).into(holder.bannerImageView)
    }
    
    class BannerViewHolder : EpoxyHolder() {
        lateinit var bannerImageView: ImageView
        override fun bindView(itemView: View) {
            bannerImageView = itemView.findViewById(R.id.banner_image)
        }
    }
}
