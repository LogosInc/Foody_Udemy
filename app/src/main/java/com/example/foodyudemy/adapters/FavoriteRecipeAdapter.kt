package com.example.foodyudemy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.foodyudemy.data.database.entities.FavoritesEntity
import com.example.foodyudemy.databinding.FavoriteRecipeRowLayoutBinding
import com.example.foodyudemy.models.Result
import com.example.foodyudemy.util.RecipesDiffUtil

class FavoriteRecipeAdapter : RecyclerView.Adapter<FavoriteRecipeAdapter.MyViewHolder>(){

    private var favoriteRecipes = emptyList<FavoritesEntity>()

    class MyViewHolder(private val binding: FavoriteRecipeRowLayoutBinding):
            RecyclerView.ViewHolder(binding.root) {
                fun bind(favoritesEntity: FavoritesEntity) {
                    binding.favoritesEntity = favoritesEntity
                    binding.executePendingBindings()
                }

                companion object {
                    fun from(parent: ViewGroup): MyViewHolder {
                        val layoutInflater = LayoutInflater.from(parent.context)
                        val binding = FavoriteRecipeRowLayoutBinding.inflate(layoutInflater, parent, false)
                        return  MyViewHolder(binding)
                    }
                }

            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val selectedRecipe = favoriteRecipes[position]
        holder.bind(selectedRecipe)
    }

    override fun getItemCount(): Int {
        return favoriteRecipes.size
    }

    fun setData(newFavoriteRecipe: List<FavoritesEntity>) {
        val favoriteRecipesDiffUtil = RecipesDiffUtil(favoriteRecipes, newFavoriteRecipe)
        val diffUtilResult = DiffUtil.calculateDiff(favoriteRecipesDiffUtil)
        favoriteRecipes = newFavoriteRecipe
        diffUtilResult.dispatchUpdatesTo(this)
    }
}