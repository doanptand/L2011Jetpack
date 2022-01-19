package com.ddona.l2011jetpack.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ddona.l2011jetpack.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(product: Product)

    @Update
    suspend fun updateProduct(product: Product)

    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("SELECT * FROM tb_product")
    suspend fun getAllProducts(): List<Product>

    @Query("SELECT * FROM tb_product")
    fun getAllProductsLiveData(): LiveData<List<Product>>
}