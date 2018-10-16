package com.grappfruit.cleanworkshoppart1.feature.product.detail.local.mapper

import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.model.RemoteProduct
import io.kotlintest.matchers.shouldBe
import org.junit.Test

class RemoteProductMapperTest {

    @Test
    fun `map() should map remote to domain`() {
        val mapper = RemoteProductMapper()
        mapper.map(remoteProduct).shouldBe(domainProduct)
    }

    private companion object {
        val remoteProduct = RemoteProduct(id = "some id", name = "some name")

        val domainProduct = Product(id = "some id", name = "some name")
    }
}
