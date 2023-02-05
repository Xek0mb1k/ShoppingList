package com.xekombik.shoppinglist.domain

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun editObject(shopItem: ShopItem){
        shopListRepository.editObject(shopItem)
    }
}