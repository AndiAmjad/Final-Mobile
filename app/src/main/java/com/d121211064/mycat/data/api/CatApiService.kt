package com.d121211064.mycat.data.api

import com.d121211064.mycat.data.model.CatImage
import retrofit2.http.GET

interface CatApiService {
    @GET("v1/images/search")
    suspend fun getCatImages(): List<CatImage>
}
