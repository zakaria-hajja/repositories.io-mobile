package com.zakaria.repositories.ui

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations

fun <T, R> LiveData<T>.switchMap(f: (T) -> LiveData<R>): LiveData<R> = Transformations.switchMap(this, f)
