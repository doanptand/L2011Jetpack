package com.ddona.l2011jetpack.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.ddona.l2011jetpack.network.PassengerClient
import com.ddona.l2011jetpack.network.PassengerDataSource

class PassengerViewModel : ViewModel() {

    private val passengerApi = PassengerClient.invoke()

    val passengers = Pager(PagingConfig(pageSize = 20)) {
        PassengerDataSource(passengerApi)
    }.flow.cachedIn(viewModelScope)

}