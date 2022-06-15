package com.pelsinkaplan.roomsampleproject

/**
 * Created by Pelşin KAPLAN on 15.06.2022.
 */
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Product::class],
    version = 1
)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun getProductDao(): ProductDao

    companion object {
        private var instance: ProductDatabase? = null

        fun getProductDatabase(context: Context): ProductDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    ProductDatabase::class.java,
                    "product.db"
                ).allowMainThreadQueries().build()
            }
            return instance
        }
    }
}