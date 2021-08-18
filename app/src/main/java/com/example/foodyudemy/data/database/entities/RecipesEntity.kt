package com.example.foodyudemy.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.foodyudemy.util.Constants.Companion.RECIPES_TABLE
import com.example.foodyudemy.models.FoodRecipe

@Entity(tableName = RECIPES_TABLE)
class RecipesEntity(
    var foodRecipe: FoodRecipe
) {

    @PrimaryKey(autoGenerate = false)
    var id: Int = 0
}