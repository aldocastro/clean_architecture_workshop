package com.grappfruit.cleanworkshoppart1.feature.product.detail.local.mapper

import com.grappfruit.cleanworkshoppart1.common.mapper.Mapper
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.model.Product
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.model.RemoteProduct

class RemoteProductMapper : Mapper<RemoteProduct, Product> {

    override fun map(from: RemoteProduct): Product = with(from) {
        Product(id, name)
    }
}
