package com.xpynx.assignment_a.services

import com.xpynx.assignment_a.model.ProductResponse
import retrofit2.Call
        import retrofit2.http.GET

interface ProductService {
    @GET("products")
fun getProducts(): Call<ProductResponse>
        }
