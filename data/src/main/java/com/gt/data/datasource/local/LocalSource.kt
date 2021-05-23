package com.gt.data.datasource.local

import android.content.Context
import com.gt.data.db.FunAppsDatabase
import javax.inject.Inject

abstract class LocalSource @Inject constructor() {
    @Inject
    lateinit var db: FunAppsDatabase
    @Inject
    lateinit var context: Context
}