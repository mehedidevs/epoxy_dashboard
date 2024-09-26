package com.mehedi.simpleepoxy


import com.airbnb.epoxy.CarouselModel_
import com.airbnb.epoxy.EpoxyController
import com.mehedi.simpleepoxy.sections.BannerEpoxyModel
import com.mehedi.simpleepoxy.sections.CategoryEpoxyModel
import com.mehedi.simpleepoxy.sections.ProductEpoxyModel
import com.mehedi.simpleepoxy.sections.SectionHeaderEpoxyModel
import com.mehedi.simpleepoxy.sections.ShopEpoxyModel

class ShopEpoxyController(
    private val onProductClick: (Product) -> Unit
) : EpoxyController() {
    
    var shops: List<Shop> = emptyList()
        set(value) {
            field = value
            requestModelBuild()
        }
    
    var banners: List<Banner> = emptyList()
    var categories: List<Category> = emptyList()
    var products: List<Product> = emptyList()
    
    override fun buildModels() {
        // Section Header for Banners
        SectionHeaderEpoxyModel(
            sectionHeader = SectionHeader(
                title = "Banners",
                showViewAll = false
            )
        ).id("banner_header").addTo(this)
        
        
        // Add categories (horizontal section)
        CarouselModel_()
            .id("banners")
            .models(banners.map { category ->
                BannerEpoxyModel(category).id(category.id)
            })
            .addTo(this)
        
        /*   // Add banners
           banners.forEach { banner ->
               BannerEpoxyModel(banner).id(banner.id).addTo(this)
           }*/
        
        // Section Header for shop
        SectionHeaderEpoxyModel(
            sectionHeader = SectionHeader(
                title = "Shops",
                showViewAll = false
            )
        ).id("Shops_header").addTo(this)
        shops.forEach { shop ->
            ShopEpoxyModel(shop).id(shop.id).addTo(this)
        }
        
        // Section Header for shop
        SectionHeaderEpoxyModel(
            sectionHeader = SectionHeader(
                title = "Categories",
                showViewAll = false
            )
        ).id("categories_header").addTo(this)
        // Add categories (horizontal section)
        CarouselModel_()
            .id("categories")
            .models(categories.map { category ->
                CategoryEpoxyModel(category).id(category.id)
            })
            .addTo(this)
        
        // Section Header for shop
        SectionHeaderEpoxyModel(
            sectionHeader = SectionHeader(
                title = "Featured",
                showViewAll = false
            )
        ).id("Featured_header").addTo(this)
        // Add products (horizontal section)
        CarouselModel_()
            .id("featured_products")
            .models(products.map { product ->
                ProductEpoxyModel(product, onProductClick).id(product.id)
            })
            .addTo(this)
        
        
    }
}
