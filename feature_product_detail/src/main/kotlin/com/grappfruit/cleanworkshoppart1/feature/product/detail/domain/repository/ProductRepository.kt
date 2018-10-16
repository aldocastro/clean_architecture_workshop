package com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.repository

import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import io.reactivex.Single

interface ProductRepository {

    fun loadProductDetails(productId: String): Single<Product>
}
