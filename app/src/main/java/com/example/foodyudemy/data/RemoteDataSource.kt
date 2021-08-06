package com.example.foodyudemy.data

import com.example.foodyudemy.data.network.FoodRecipeApi
import com.example.foodyudemy.models.FoodRecipe
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val foodRecipeApi: FoodRecipeApi
) {

    suspend fun getRecipes(queries: Map<String, String>): Response<FoodRecipe> {
        return foodRecipeApi.getRecipes(queries)
    }

    suspend fun searchRecipes(searchQueries:Map<String, String>): Response<FoodRecipe> {
        return foodRecipeApi.searchRecipes(searchQueries)
    }

}