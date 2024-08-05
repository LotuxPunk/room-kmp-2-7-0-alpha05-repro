package database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import domain.Recipe
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert
    suspend fun insert(item: Recipe)

    @Transaction
    @Query("SELECT * FROM Recipe")
    fun getAllRecipes(): Flow<List<Recipe>>
}
