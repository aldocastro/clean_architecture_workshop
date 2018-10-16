package com.grappfruit.cleanworkshoppart1.feature.product.detail.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.grappfruit.cleanworkshoppart1.feature.product.detail.R
import com.grappfruit.cleanworkshoppart1.feature.product.detail.presentation.presenter.ProductDetailPresenter
import com.grappfruit.cleanworkshoppart1.feature.product.detail.presentation.view.ProductDetailView
import kotlinx.android.synthetic.main.fragment_product_detail.*
import org.koin.android.ext.android.inject

class ProductDetailFragment : Fragment(), ProductDetailView {

    private val presenter: ProductDetailPresenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(R.layout.fragment_product_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.attachView(this)
        presenter.start()
    }

    override fun onDestroyView() {
        presenter.stop()
        super.onDestroyView()
    }

    override fun showProductName(name: String) {
        productTitleText.text = name
    }

    companion object {
        fun newInstance() =
            ProductDetailFragment()
    }
}
