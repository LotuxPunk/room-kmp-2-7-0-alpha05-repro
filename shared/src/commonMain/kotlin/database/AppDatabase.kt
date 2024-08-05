package database

import androidx.room.Database
import androidx.room.RoomDatabase
import database.dao.RecipeDao
import domain.Recipe

@Database(
    entities = [
        Recipe::class,
    ],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getRecipeDao(): RecipeDao
}
