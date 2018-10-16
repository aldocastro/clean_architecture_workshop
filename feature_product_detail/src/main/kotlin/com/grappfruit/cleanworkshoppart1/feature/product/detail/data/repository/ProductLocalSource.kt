package com.grappfruit.cleanworkshoppart1.feature.product.detail.data.repository

import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.model.RemoteProduct
import io.reactivex.Single

interface ProductLocalSource {

    fun loadProductDetails(productId: String): Single<Product>
}
