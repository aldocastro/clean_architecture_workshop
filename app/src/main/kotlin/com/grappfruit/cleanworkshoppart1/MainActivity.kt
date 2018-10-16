package com.grappfruit.cleanworkshoppart1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.grappfruit.cleanworkshoppart1.feature.product.detail.view.ProductDetailFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, ProductDetailFragment.newInstance())
            .commitAllowingStateLoss()
    }
}
