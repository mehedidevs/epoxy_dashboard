package com.mehedi.simpleepoxy.sections

import android.view.View
import android.view.ViewParent
import android.widget.Button
import android.widget.TextView
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.mehedi.simpleepoxy.R
import com.mehedi.simpleepoxy.SectionHeader

class SectionHeaderEpoxyModel(
    private val sectionHeader: SectionHeader
) : EpoxyModelWithHolder<SectionHeaderEpoxyModel.SectionHeaderViewHolder>() {
    
    override fun getDefaultLayout(): Int = R.layout.item_section_header
    
    override fun createNewHolder(parent: ViewParent): SectionHeaderViewHolder = SectionHeaderViewHolder()
    
    override fun bind(holder: SectionHeaderViewHolder) {
        holder.sectionTitleTextView.text = sectionHeader.title
        if (sectionHeader.showViewAll) {
            holder.viewAllButton.visibility = View.VISIBLE
            holder.viewAllButton.setOnClickListener {
                sectionHeader.onViewAllClick?.invoke()
            }
        } else {
            holder.viewAllButton.visibility = View.GONE
        }
    }
    
    class SectionHeaderViewHolder : EpoxyHolder() {
        lateinit var sectionTitleTextView: TextView
        lateinit var viewAllButton: Button
        
        override fun bindView(itemView: View) {
            sectionTitleTextView = itemView.findViewById(R.id.section_title)
            viewAllButton = itemView.findViewById(R.id.view_all_button)
        }
    }
}
