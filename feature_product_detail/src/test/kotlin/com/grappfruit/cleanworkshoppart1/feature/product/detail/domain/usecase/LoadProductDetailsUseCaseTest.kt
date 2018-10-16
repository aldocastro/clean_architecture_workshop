package com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.usecase

import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.repository.ProductRepository
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class LoadProductDetailsUseCaseTest {

    private val productRepository = mock<ProductRepository>()

    @Test
    fun `execute() should load product from repository`() {
        val product = Product(id = "some id", name = "some name")

        whenever(productRepository.loadProductDetails(any())).thenReturn(Single.just(product))

        LoadProductDetailsUseCase(productRepository)
            .execute(param = LoadProductDetailsUseCase.Params(productId = "unused"))
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue { it == product }
    }
}
