package co.com.parqueadero.persistence.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.com.parqueadero.entities.Tarifa;

@Dao
public interface TarifaDAO {

    @Insert
    void insert(Tarifa tarifa);

    @Delete
    void delete(Tarifa tarifa);

    @Query("DELETE FROM tarifa WHERE idTarifa=:idTarifa")
    void deleteByIdTarifa(Integer idTarifa);

    @Query("SELECT * FROM tarifa")
    List<Tarifa> listar();

    @Query("SELECT * FROM tarifa WHERE idTarifa=:idTarifa")
    Tarifa findByTarifa(int idTarifa);
}
