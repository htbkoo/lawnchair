package app.lawnchair.data

import androidx.room.*
import app.lawnchair.data.iconoverride.IconOverride
import app.lawnchair.data.iconoverride.IconOverrideDao
import com.android.launcher3.util.ComponentKey
import com.android.launcher3.util.MainThreadInitializedObject

@Database(entities = [IconOverride::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun iconOverrideDao(): IconOverrideDao

    companion object {
        val INSTANCE = MainThreadInitializedObject { context ->
            Room.databaseBuilder(
                context,
                AppDatabase::class.java, "preferences"
            ).build()
        }
    }
}
