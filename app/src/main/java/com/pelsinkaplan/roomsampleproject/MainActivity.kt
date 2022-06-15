package com.pelsinkaplan.roomsampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    private lateinit var productDatabase: ProductDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        productDatabase = ProductDatabase.getProductDatabase(this)!!

        val product1 = Product("Shoes", "$30")
        insertProduct(product1)
        val product2 = Product("T-shirt", "$20")
        insertProduct(product2)
        val product3 = Product("Hat", "$10")
        insertProduct(product3)
        Log.e("All Products", getAllProduct().toString())
        deleteProduct()
        Log.e("All Products After Delete", getAllProduct().toString())
        updateProduct()
        Log.e("All Products After Update", getAllProduct().toString())
    }

    private fun insertProduct(product: Product) {
        productDatabase.getProductDao().insertProduct(product)
    }

    private fun deleteProduct() {
        val product = getAllProduct()[0]
        productDatabase.getProductDao().deleteProduct(product)
    }

    private fun updateProduct() {
        val product = getAllProduct()[0]
        product.productPrice = "$60"
        productDatabase.getProductDao().updateProduct(product)
    }

    private fun getAllProduct(): List<Product> {
        return productDatabase.getProductDao().getAllProduct()
    }
}