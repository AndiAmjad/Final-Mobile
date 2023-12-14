package com.d121211064.mycat.data.repository

import com.d121211064.mycat.data.api.CatApiService
import com.d121211064.mycat.data.model.CatImage

class CatRepository(private val catApiService: CatApiService) {
    suspend fun getCatImages(): List<CatImage> {
        return catApiService.getCatImages()
    }
}
