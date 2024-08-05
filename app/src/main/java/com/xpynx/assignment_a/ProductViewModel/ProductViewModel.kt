package com.xpynx.assignment_a.ProductViewModel

import ApiClient
import com.xpynx.assignment_a.model.Product
import com.xpynx.assignment_a.model.ProductResponse
import com.xpynx.assignment_a.services.ProductService
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductViewModel : ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> get() = _products

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        loadProducts()
    }

    private fun loadProducts() {
        _isLoading.value = true
        val productService = ApiClient.retrofit.create(ProductService::class.java)
        val call = productService.getProducts()
        call.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
        _isLoading.value = false
                if (response.isSuccessful && response.body() != null) {
                    _products.value = response.body()!!.products
                } else {
                          _errorMessage.value = "Response error: ${response.code()}"
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                         _isLoading.value = false
                 _errorMessage.value = "Request failed: ${t.message}"
            }
        })
    }
}
