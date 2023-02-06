package com.xekombik.shoppinglist.presentation


import androidx.lifecycle.ViewModel
// Wrong Realisation
import com.xekombik.shoppinglist.data.ShopListRepositoryImpl

import com.xekombik.shoppinglist.domain.DeleteShopItemUseCase
import com.xekombik.shoppinglist.domain.EditShopItemUseCase
import com.xekombik.shoppinglist.domain.GetShopListUseCase
import com.xekombik.shoppinglist.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()


    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editObject(newItem)
    }

}