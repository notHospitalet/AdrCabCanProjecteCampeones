package com.example.adrcabcanprojectecampeones.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// con @database indica que representa una base de datos room
@Database(entities = {CampeonEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    // extiende de RoomDatabase y defina la base de datos

    private static AppDatabase INSTANCE;

    // metodo para obtener la instancia de la base de datos, si no existe la crea, sino solo la devuelve
    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            AppDatabase.class, "db").build();
        }
        return INSTANCE;
    }

    // metodo abstracto para acceder al DAO
    public abstract CampeonDAO getCampeonDao();
}
