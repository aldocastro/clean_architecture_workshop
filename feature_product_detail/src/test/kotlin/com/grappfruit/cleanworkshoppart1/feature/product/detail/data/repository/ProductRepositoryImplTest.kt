package com.grappfruit.cleanworkshoppart1.feature.product.detail.data.repository

import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import org.junit.Test

class ProductRepositoryImplTest {

    private val localSource = mock<ProductLocalSource>()

    @Test
    fun `loadProductDetails should load product for correct id`() {
        val product = Product(id = "some id", name = "some name")

        whenever(localSource.loadProductDetails("some id")).thenReturn(Single.just(product))

        ProductRepositoryImpl(localSource)
            .loadProductDetails(productId = "some id")
            .test()
            .assertNoErrors()
            .assertComplete()
            .assertValue { it == Product(id = "some id", name = "some name") }
    }
}
