package com.ivanj.agrofind

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ProductViewModel(application: Application) : AndroidViewModel(application) {
    private val productDao = FarmDatabase.getDatabase(application).productDao()

    val allProducts: LiveData<List<Product>> = productDao.getAllProducts()

    fun addProduct(product: Product) {
        viewModelScope.launch(Dispatchers.IO) {
            productDao.insertProduct(product)
        }
    }
}
