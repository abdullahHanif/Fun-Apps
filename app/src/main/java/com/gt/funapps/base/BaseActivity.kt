package com.gt.funapps.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    abstract protected fun showLoader()
    abstract protected fun hideLoader()
}