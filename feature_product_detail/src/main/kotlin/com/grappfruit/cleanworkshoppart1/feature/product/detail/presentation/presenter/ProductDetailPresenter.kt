package com.grappfruit.cleanworkshoppart1.feature.product.detail.presentation.presenter

import com.grappfruit.cleanworkshoppart1.common.ext.observeOnMain
import com.grappfruit.cleanworkshoppart1.common.ext.subscribeOnIo
import com.grappfruit.cleanworkshoppart1.common.presentation.BasePresenter
import com.grappfruit.cleanworkshoppart1.feature.product.detail.domain.usecase.LoadProductDetailsUseCase
import com.grappfruit.cleanworkshoppart1.feature.product.detail.presentation.view.ProductDetailView
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber

class ProductDetailPresenter(
    private val loadProductDetailsUseCase: LoadProductDetailsUseCase
) : BasePresenter() {

    private lateinit var view: ProductDetailView

    fun attachView(view: ProductDetailView) {
        this.view = view
    }

    override fun start() {
        disposables += loadProductDetailsUseCase.execute(LoadProductDetailsUseCase.Params(productId = "some id"))
            .subscribeOnIo()
            .observeOnMain()
            .subscribeBy(
                onSuccess = {
                    Timber.d("product loaded: $it")
                    view.showProductName(it.name)
                },
                onError = Timber::e
            )
    }
}
