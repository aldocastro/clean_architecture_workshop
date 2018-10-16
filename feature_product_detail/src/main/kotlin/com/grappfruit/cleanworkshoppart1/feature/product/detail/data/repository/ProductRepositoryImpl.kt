package com.grappfruit.cleanworkshoppart1.feature.product.detail.data.repository

import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImpl(
    private val localSource: ProductLocalSource
) : ProductRepository {

    override fun loadProductDetails(productId: String): Single<Product> =
        localSource.loadProductDetails(productId)
}
