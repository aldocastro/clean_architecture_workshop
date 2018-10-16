package com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.usecase

import com.grappfruit.cleanworkshoppart1.common.domain.UseCase
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.repository.ProductRepository
import io.reactivex.Single

class LoadProductDetailsUseCase(
    private val productRepository: ProductRepository
) : UseCase<LoadProductDetailsUseCase.Params, Single<Product>> {

    override fun execute(param: Params): Single<Product> =
        productRepository.loadProductDetails(param.productId)

    data class Params(val productId: String)
}
