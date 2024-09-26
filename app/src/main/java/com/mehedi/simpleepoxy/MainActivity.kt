package com.mehedi.simpleepoxy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mehedi.simpleepoxy.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    
    private lateinit var binding: ActivityMainBinding
    
    private val shopEpoxyController = ShopEpoxyController(
        onProductClick = { product ->
            // Handle product click here
            Toast.makeText(this, "Clicked: ${product.name}", Toast.LENGTH_SHORT).show()
        })
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.epoxyRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        // Setup RecyclerView
        binding.epoxyRecyclerView.setController(shopEpoxyController)
        
        // Dummy Data
        val dummyShops = listOf(
            Shop(1, "Shop 1", "Best shop in town"),
            Shop(2, "Shop 2", "All you need in one place"),
            Shop(3, "Shop 3", "Exclusive items available"),
            Shop(4, "Shop 4", "Great deals on everything")
        )
        // Dummy data
        val banners = listOf(
            Banner(1, "https://via.placeholder.com/300.png"),
            Banner(2, "https://via.placeholder.com/300.png")
        )
        
        val categories = listOf(
            Category(1, "Electronics", "https://via.placeholder.com/80.png"),
            Category(2, "Clothes", "https://via.placeholder.com/80.png"),
            Category(3, "Clothes", "https://via.placeholder.com/80.png"),
            Category(4, "Clothes", "https://via.placeholder.com/80.png"),
            Category(5, "Clothes", "https://via.placeholder.com/80.png"),
            Category(6, "Clothes", "https://via.placeholder.com/80.png"),
            Category(7, "Clothes", "https://via.placeholder.com/80.png"),
        )
        
        val products = listOf(
            Product(1, "Phone", "$500", "https://via.placeholder.com/120.png"),
            Product(2, "Watch", "$150", "https://via.placeholder.com/120.png"),
            Product(2, "Watch", "$150", "https://via.placeholder.com/120.png"),
            Product(2, "Watch", "$150", "https://via.placeholder.com/120.png"),
            Product(2, "Watch", "$150", "https://via.placeholder.com/120.png"),
            Product(2, "Watch", "$150", "https://via.placeholder.com/120.png"),
        )

// Pass data to controller
        shopEpoxyController.banners = banners
        shopEpoxyController.categories = categories
        shopEpoxyController.products = products
        
        // Set shops to controller
        shopEpoxyController.shops = dummyShops
        shopEpoxyController.requestModelBuild()
    }
}
