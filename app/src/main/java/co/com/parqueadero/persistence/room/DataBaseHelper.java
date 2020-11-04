package co.com.parqueadero.persistence.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.com.parqueadero.entities.Movimiento;
import co.com.parqueadero.entities.Tarifa;
import co.com.parqueadero.persistence.dao.MovimientoDAO;
import co.com.parqueadero.persistence.dao.TarifaDAO;

@Database(entities = {
        Tarifa.class,
        Movimiento.class}, version = DataBaseHelper.VERSION_BASE_DATOS, exportSchema = false)
public abstract class DataBaseHelper extends RoomDatabase {

    public static final int VERSION_BASE_DATOS = 2;
    public static final String NOMBRE_BASE_DATOS = "parqueadero";
    private static DataBaseHelper instace;

    public static DataBaseHelper getSimpleDB(Context context){
        if (instace == null){
            instace = Room.databaseBuilder(context, DataBaseHelper.class, NOMBRE_BASE_DATOS).build();
        }
        return instace;
    }

    public static DataBaseHelper getDBMainThread(Context context){
        if (instace == null) {
            instace = Room.databaseBuilder(context, DataBaseHelper.class, NOMBRE_BASE_DATOS).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instace;
    }

    public abstract TarifaDAO getTarifaDAO();

    public abstract MovimientoDAO getMovimientoDAO();
}
