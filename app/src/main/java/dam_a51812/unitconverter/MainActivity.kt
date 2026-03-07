package dam_a51812.unitconverter

import android.os.Bundle
import android.text.Editable
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.EditText
import android.text.TextWatcher

class MainActivity : AppCompatActivity() {

    private var isEditing = false

    private fun addWatcher(input: EditText, output: EditText, convert: (Double) -> Double) {
        input.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (isEditing) return
                isEditing = true
                val text = s.toString()
                if (text.isEmpty()) {
                    output.setText("")
                } else {
                    val value = text.toDoubleOrNull()
                    if (value != null) {
                        output.setText("%.2f".format(convert(value)))
                    }
                }
                isEditing = false
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ldSwitch = findViewById<Switch>(R.id.LDswitch)
        ldSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }

        val etCelsius = findViewById<EditText>(R.id.etCelsius)
        val etFahrenheit = findViewById<EditText>(R.id.etFahrenheit)
        val etKm = findViewById<EditText>(R.id.etKm)
        val etMiles = findViewById<EditText>(R.id.etMiles)
        val etKg = findViewById<EditText>(R.id.etKg)
        val etPounds = findViewById<EditText>(R.id.etPounds)

        addWatcher(etCelsius, etFahrenheit) { it * 9/5 + 32 }
        addWatcher(etFahrenheit, etCelsius) { (it - 32) * 5/9 }

        addWatcher(etKm, etMiles) { it * 0.621371 }
        addWatcher(etMiles, etKm) { it * 1.60934 }

        addWatcher(etKg, etPounds) { it * 2.20462 }
        addWatcher(etPounds, etKg) { it * 0.453592 }
    }
}