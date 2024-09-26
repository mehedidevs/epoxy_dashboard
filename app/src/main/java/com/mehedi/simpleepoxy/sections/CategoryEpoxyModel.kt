package com.mehedi.simpleepoxy.sections

import android.view.View
import android.view.ViewParent
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.mehedi.simpleepoxy.Category
import com.mehedi.simpleepoxy.R

class CategoryEpoxyModel(private val category: Category) : EpoxyModelWithHolder<CategoryEpoxyModel.CategoryViewHolder>() {
    
    override fun getDefaultLayout(): Int = R.layout.item_category
    
    override fun createNewHolder(parent: ViewParent): CategoryViewHolder = CategoryViewHolder()
    
    override fun bind(holder: CategoryViewHolder) {
        // Load category image and set name
         Glide.with(holder.categoryImageView.context).load(category.imageUrl).into(holder.categoryImageView)
        holder.categoryNameTextView.text = category.name
    }
    
    class CategoryViewHolder : EpoxyHolder() {
        lateinit var categoryImageView: ImageView
        lateinit var categoryNameTextView: TextView
        override fun bindView(itemView: View) {
            categoryImageView = itemView.findViewById(R.id.category_image)
            categoryNameTextView = itemView.findViewById(R.id.category_name)
        }
    }
}
