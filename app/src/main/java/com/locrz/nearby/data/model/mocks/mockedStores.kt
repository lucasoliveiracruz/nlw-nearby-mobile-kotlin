package com.locrz.nearby.data.model.mocks

import com.locrz.nearby.data.model.Rule
import com.locrz.nearby.data.model.Store

val mockedStores = listOf(
    Store(
        id = "1",
        name = "Loja do Zé",
        description = "Test",
        longitude = 0.0,
        latitude = 0.0,
        categoryId = "2",
        coupons = 3,
//        couponRules = listOf(
//            Rule(id = "1", description = "Válido apenas para consumo no local", storeId = "1"),
//            Rule(id = "2", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "3", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "4", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "5", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "6", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "7", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "8", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "9", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "10", description = "Disponível até 31/12", storeId = "1"),
//            Rule(id = "11", description = "Válido apenas para consumo no local", storeId = "1"),
//            Rule(id = "12", description = "Válido apenas para consumo no local", storeId = "1"),
//            Rule(id = "13", description = "Válido apenas para consumo no local", storeId = "1"),
//            Rule(id = "14", description = "Válido apenas para consumo no local", storeId = "1"),
//            Rule(id = "15", description = "Válido apenas para consumo no local", storeId = "1"),
//            Rule(id = "16", description = "Válido apenas para consumo no local", storeId = "1"),
//        ),
        phone = "14995666533",
        fullAddress = "Rua dos testes, 44 - 1231",
        imageUrl = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    ),
    Store(
        id = "012576ea-4441-4b8a-89e5-d5f32104c7c4",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Sabor Grill",
        description = "Churrascaria com cortes nobres e buffet variado. Experiência completa para os amantes de carne.",
        coupons = 10,
//        couponRules = emptyList(),
        latitude = -23.55974230991911,
        longitude = -46.65814845249887,
        fullAddress = "Av. Paulista - Bela Vista",
        phone = "(11) 94567-1212",
        imageUrl = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    ),
    Store(
        id = "2bc11e34-5f30-4ba0-90fa-c1c98f649281",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Café Central",
        description = "Café aconchegante com opções de lanches e bebidas artesanais. Perfeito para uma pausa.",
        coupons = 10,
//        couponRules = emptyList(),
        latitude = -23.559457108504436,
        longitude = -46.66252581753144,
        fullAddress = "Alameda Jaú - Jardim Paulista",
        phone = "(12) 3456-7890",
        imageUrl = "https://images.unsplash.com/photo-1551218808-94e220e084d2?w=400&h=300"
    ),
    Store(
        id = "2bc11e34-5f30-4ba0-90fa-c1c98f649282",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e863",
        name = "Lanchonete do Zé",
        description = "Na compra de qualquer lanche, ganhe um café expresso",
        coupons = 10,
//        couponRules = emptyList(),
        latitude = -23.559457108504436,
        longitude = -46.66252581753144,
        fullAddress = "Alameda Jaú - Jardim Paulista",
        phone = "(12) 3456-7890",
        imageUrl = "https://images.unsplash.com/photo-1551218808-94e220e084d2?w=400&h=300"
    )
)