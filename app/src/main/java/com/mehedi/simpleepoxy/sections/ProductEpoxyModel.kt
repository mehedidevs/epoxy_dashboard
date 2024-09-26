package com.mehedi.simpleepoxy.sections

import android.view.View
import android.view.ViewParent
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.mehedi.simpleepoxy.Product
import com.mehedi.simpleepoxy.R
import com.mehedi.simpleepoxy.databinding.ItemProductBinding

class ProductEpoxyModel(
    private val product: Product,
    private val onClick: ((Product) -> Unit)
) : EpoxyModelWithHolder<ProductEpoxyModel.ProductViewHolder>() {
    
    override fun getDefaultLayout(): Int = R.layout.item_product
    
    override fun createNewHolder(parent: ViewParent): ProductViewHolder = ProductViewHolder()
    
    override fun bind(holder: ProductViewHolder) {
        // Load product image, name, and price
        holder.binding.apply {
            Glide.with(root.context).load(product.imageUrl)
                .into(productImage)
            productName.text = product.name
            productPrice.text = product.price
            root.setOnClickListener {
                onClick.invoke(product)
            }
        }
        
        
    }
    
    class ProductViewHolder : EpoxyHolder() {
        
        lateinit var binding: ItemProductBinding
        
        override fun bindView(itemView: View) {
            binding = ItemProductBinding.bind(itemView)
        }
    }
}
