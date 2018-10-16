package com.grappfruit.cleanworkshoppart1.feature.product.detail.local.repository

import com.grappfruit.cleanworkshoppart1.feature.product.detail.data.repository.ProductLocalSource
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.mapper.RemoteProductMapper
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.model.RemoteProduct
import io.reactivex.Single

class ProductLocalSourceImpl(
    private val productMapper: RemoteProductMapper
) : ProductLocalSource {

    override fun loadProductDetails(productId: String): Single<Product> =
        Single.just(RemoteProduct(id = productId, name = "My first Product"))
            .map(productMapper::map)
}
