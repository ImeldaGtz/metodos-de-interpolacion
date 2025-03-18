package com.example.lagnewexin;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.lagnewexin.databinding.ActivityNewtonCuadraticoBinding;

public class newtonCuadratico extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityNewtonCuadraticoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNewtonCuadraticoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_newton_cuadratico);
        // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        //    NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_newton_cuadratico);
        //    return NavigationUI.navigateUp(navController, appBarConfiguration)
        //            || super.onSupportNavigateUp();
        return true;
    }
    public void calculateNewCuad(View NC) {
        // Para mostrar
        TextView txvfx = (TextView) findViewById(R.id.txvResult);
        // A calular
        EditText edtx = (EditText) findViewById(R.id.edtX);
        // A comparar
        EditText edtFxReal = (EditText) findViewById(R.id.edtFX);
        // Independientes
        EditText edtx0 = (EditText) findViewById(R.id.edtX0);
        EditText edtx1 = (EditText) findViewById(R.id.edtX1);
        EditText edtx2 = (EditText) findViewById(R.id.edtX2);
        // Dependientes
        EditText edtfx0 = (EditText) findViewById(R.id.edtFX0);
        EditText edtfx1 = (EditText) findViewById(R.id.edtFX1);
        EditText edtfx2 = (EditText) findViewById(R.id.edtFX2);

        try {
            String xstr = edtx.getText().toString();
            String fxRealstr = edtFxReal.getText().toString();  // Opcional
            String x0str = edtx0.getText().toString();
            String x1str = edtx1.getText().toString();
            String x2str = edtx2.getText().toString();
            String fx0str = edtfx0.getText().toString();
            String fx1str = edtfx1.getText().toString();
            String fx2str = edtfx2.getText().toString();

            // Verificación de campos
            if(xstr.isEmpty() || x0str.isEmpty() || x1str.isEmpty() || x2str.isEmpty() || fx0str.isEmpty() || fx1str.isEmpty() || fx2str.isEmpty()) {
                txvfx.setText("Por favor llene todos los espacios");
                return;
            }

            // Asignación de valores a numeros
            double x = Double.parseDouble(xstr);
            double x0 = Double.parseDouble(x0str);
            double x1 = Double.parseDouble(x1str);
            double x2 = Double.parseDouble(x2str);
            double fx0 = Double.parseDouble(fx0str);
            double fx1 = Double.parseDouble(fx1str);
            double fx2 = Double.parseDouble(fx2str);

            // Fórmula en sí equis de
            double _b1 = (fx1 - fx0) / (x1 - x0);
            double _b2 = ( ((fx2 - fx0) / (x2 - x0)) - _b1) / (x2 - x1);

            double b0 = Double.parseDouble(String.format("%.6f", fx0));
            double b1 = Double.parseDouble(String.format("%.6f", _b1));
            double b2 = Double.parseDouble(String.format("%.6f", _b2));


            double resultado = b0 + ( b1 * (x - x0)) + (b2 * (x - x0) * (x - x1));
            txvfx.setText(String.format("El valor aproximado es: %.6f", resultado));

            double FxReal;
            if (!fxRealstr.isEmpty()) {
                FxReal = Double.parseDouble(fxRealstr);

                double errorV = FxReal - resultado;
                double errorP = errorV / FxReal *100;
                txvfx.setText(String.format("El valor aproximado es: %.6f \nEl error porcentual: %.6f %%", resultado, errorP));
            }
        } catch (NumberFormatException err) {
            txvfx.setText("Error: Ingresa números válidos en todos los campos.");
        } catch (Exception err) {
            txvfx.setText("Ocurrió un error inesperado :C");
        }

    }
}