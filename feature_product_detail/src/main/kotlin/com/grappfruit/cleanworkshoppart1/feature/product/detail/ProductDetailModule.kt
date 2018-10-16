package com.grappfruit.cleanworkshoppart1.feature.product.detail

import com.grappfruit.cleanworkshoppart1.feature.product.detail.data.repository.ProductLocalSource
import com.grappfruit.cleanworkshoppart1.feature.product.detail.data.repository.ProductRepositoryImpl
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.repository.ProductRepository
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.usecase.LoadProductDetailsUseCase
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.mapper.RemoteProductMapper
import com.grappfruit.cleanworkshoppart1.feature.product.detail.local.repository.ProductLocalSourceImpl
import com.grappfruit.cleanworkshoppart1.feature.product.detail.presentation.presenter.ProductDetailPresenter
import org.koin.dsl.module.module

val productDetailModule = module {
    single { RemoteProductMapper() }
    single<ProductLocalSource> { ProductLocalSourceImpl(get()) }
    single<ProductRepository> { ProductRepositoryImpl(get()) }
    single { LoadProductDetailsUseCase(get()) }
    factory { ProductDetailPresenter(get()) }
}
