package com.example.adrcabcanprojectecampeones.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.adrcabcanprojectecampeones.models.Campeon;

import java.util.List;

@Dao
public interface CampeonDAO {

    @Query("select * from campeonentity")
    LiveData<List<CampeonEntity>> getCampeon();

    @Insert
    void addCampeon(CampeonEntity campeon);

    @Insert
    void addCampeones (List<CampeonEntity> campeones);

    @Delete
    void deleteCampeon(CampeonEntity campeon);

    @Query("delete from campeonentity")
    void deleteCampeones();
}
