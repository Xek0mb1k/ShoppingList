package com.xekombik.shoppinglist.data

import com.xekombik.shoppinglist.domain.ShopItem
import com.xekombik.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl: ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()

    private var autoImplementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID)
            shopItem.id = autoImplementId++

        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editObject(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        }?: throw java.lang.RuntimeException(
            "Element width id $shopItemId not found"
        )
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}