package com.gt.funapps.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    abstract protected fun showLoader()
    abstract protected fun hideLoader()
}