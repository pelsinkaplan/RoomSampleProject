package com.pelsinkaplan.roomsampleproject

/**
 * Created by Pelşin KAPLAN on 15.06.2022.
 */
import androidx.room.*

@Dao
interface ProductDao {
    @Insert
    fun insertProduct(product: Product)

    @Query("SELECT * FROM product_table ORDER BY product_id DESC")
    fun getAllProduct(): List<Product>

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)

}