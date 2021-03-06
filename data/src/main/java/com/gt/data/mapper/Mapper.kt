package com.gt.data.mapper

interface Mapper<T, F> {
    fun fromDataToDomainType(from: F): T
    fun fromDomainToDataType(to: T): F
}