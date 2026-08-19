package com.example.chefproject

import android.os.Bundle
/** import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.chefproject.ui.theme.ChefProjectTheme
*/
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.tuempresa.conversormedidas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // View Binding nos da acceso directo a las vistas del XML
    private lateinit var binding: ActivityMainBinding

    // Contador para llevar la cuenta de cuántos ingredientes llevamos
    // (útil si después querés identificar cada campo por su índice)
    private var contadorIngredientes = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarBotonAgregarIngrediente()
    }

    /**
     * Configura el listener del botón que agrega nuevos
     * cuadros de texto de ingredientes al formulario.
     */
    private fun configurarBotonAgregarIngrediente() {
        binding.btnAgregarIngrediente.setOnClickListener {
            agregarCampoIngrediente()
        }
    }

    /**
     * Crea un nuevo EditText por código y lo agrega
     * dentro del contenedor de ingredientes (un LinearLayout).
     */
    private fun agregarCampoIngrediente() {
        contadorIngredientes++

        val nuevoEditText = EditText(this).apply {
            hint = "Ingrediente $contadorIngredientes"
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 16, 0, 0) // pequeño margen arriba para separarlos
            }
        }

        // contenedorIngredientes es el LinearLayout vertical
        // donde vamos apilando los EditText de ingredientes
        binding.contenedorIngredientes.addView(nuevoEditText)
    }

    /**
     * Ejemplo de cómo recolectar los datos del formulario
     * (lo vas a necesitar para hacer la conversión de medidas después).
     */
    private fun obtenerDatosFormulario(): Triple<String, String, List<String>> {
        val nombreReceta = binding.etNombreReceta.text.toString()
        val molde = binding.etMolde.text.toString()

        val ingredientes = mutableListOf<String>()
        for (i in 0 until binding.contenedorIngredientes.childCount) {
            val vista = binding.contenedorIngredientes.getChildAt(i)
            if (vista is EditText) {
                ingredientes.add(vista.text.toString())
            }
        }

        return Triple(nombreReceta, molde, ingredientes)
    }
}
