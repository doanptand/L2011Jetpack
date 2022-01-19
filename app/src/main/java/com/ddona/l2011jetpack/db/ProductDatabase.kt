package com.ddona.l2011jetpack.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ddona.l2011jetpack.model.Product


@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class ProductDatabase : RoomDatabase() {
    abstract fun getProductDao(): ProductDao

    companion object {
        private var INSTANCE: ProductDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): ProductDatabase {
            if (INSTANCE == null) {
                INSTANCE =
                    Room.databaseBuilder(
                        ctx,
                        ProductDatabase::class.java,
                        "product.db"
                    ).addCallback(object: RoomDatabase.Callback(){
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                        }

                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                        }

                        override fun onDestructiveMigration(db: SupportSQLiteDatabase) {
                            super.onDestructiveMigration(db)
                        }
                    }).fallbackToDestructiveMigration().build()
            }
            return INSTANCE!!
        }
    }

}