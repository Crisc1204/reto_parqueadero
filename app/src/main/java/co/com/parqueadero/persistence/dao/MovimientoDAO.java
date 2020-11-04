package co.com.parqueadero.persistence.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import co.com.parqueadero.entities.Movimiento;

@Dao
public interface MovimientoDAO {

    @Query("SELECT * FROM MOVIMIENTO Where placa=:placa AND finalizaMovimiento = 0")
    Movimiento findByPLaca(String placa);

    @Insert
    void insert(Movimiento movimiento);

    @Query("SELECT * FROM MOVIMIENTO Where idMovimiento=:idMovimiento")
    Movimiento  findById(int idMovimiento);

    @Query("UPDATE MOVIMIENTO SET fechaSalida=:fechaSalida, finalizaMovimiento = 1, totalPagado=:totalPagado WHERE idMovimiento=:idMovimiento")
    void updateSalida(String fechaSalida, double totalPagado, int idMovimiento);

    @Query("SELECT * FROM MOVIMIENTO WHERE finalizaMovimiento = 1 AND strftime(fechaEntrada) >= strftime(:inicio) AND strftime(fechaSalida) <= strftime(:Final)")
    List<Movimiento> getMovimientos(String inicio, String Final);
}
