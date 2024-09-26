package com.mehedi.simpleepoxy.sections


import android.view.View
import android.view.ViewParent
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mehedi.simpleepoxy.R
import com.mehedi.simpleepoxy.Shop

class ShopEpoxyModel(
    private val shop: Shop
) : EpoxyModelWithHolder<ShopEpoxyModel.ShopViewHolder>() {
    
    override fun getDefaultLayout(): Int {
        return R.layout.item_shop
    }
    
    override fun createNewHolder(parent: ViewParent): ShopViewHolder {
        return ShopViewHolder()
    }
    
    override fun bind(holder: ShopViewHolder) {
        holder.shopNameTextView.text = shop.name
        holder.shopDescriptionTextView.text = shop.description
    }
    
    class ShopViewHolder : EpoxyHolder() {
        lateinit var shopNameTextView: TextView
        lateinit var shopDescriptionTextView: TextView
        
        override fun bindView(itemView: View) {
            shopNameTextView = itemView.findViewById(R.id.shop_name)
            shopDescriptionTextView = itemView.findViewById(R.id.shop_description)
        }
    }
}
