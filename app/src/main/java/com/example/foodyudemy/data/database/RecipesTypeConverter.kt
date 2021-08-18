package com.example.foodyudemy.data.database

import androidx.room.TypeConverter
import com.example.foodyudemy.models.FoodRecipe
import com.example.foodyudemy.models.Result
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class RecipesTypeConverter {

    var gson = Gson()

    @TypeConverter
    fun foodRecipesToString(foodRecipe: FoodRecipe): String {
        return gson.toJson(foodRecipe)
    }

    @TypeConverter
    fun stringToFoodRecipe(data: String): FoodRecipe {
        val listTypes = object : TypeToken<FoodRecipe>() {}.type
        return gson.fromJson(data, listTypes)
    }

    @TypeConverter
    fun resultToString(result: Result): String {
        return gson.toJson(result)
    }

    @TypeConverter
    fun stringToResult(data: String): Result {
        val listTypes = object : TypeToken<Result>() {}.type
        return gson.fromJson(data, listTypes)
    }

}