package co.com.parqueadero.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import co.com.parqueadero.R;
import co.com.parqueadero.utilities.ActionBarUtil;
import co.com.parqueadero.view.movimiento.MovimientoActivity;

public class MainActivity extends AppCompatActivity {

    private ActionBarUtil actionBarUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents() {
        actionBarUtil = new ActionBarUtil(this);
        actionBarUtil.setToolBar(getString(R.string.menu_principal));
    }

    public void goToTarifaActivity(View view) {
        Intent intent = new Intent(this, TarifaActivity.class);
        startActivity(intent);
    }

    public void gotToIngresoSalida(View view) {
        Intent intent = new Intent(this, MovimientoActivity.class);
        startActivity(intent);
    }

    public void goToReporte(View view){
        Intent intent = new Intent(this,ReporteActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}