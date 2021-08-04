package com.example.foodyudemy.data.database

import androidx.room.TypeConverter
import com.example.foodyudemy.models.FoodRecipe
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

}