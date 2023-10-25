package com.example.bai2_android_linearlayout

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bai2_android_linearlayout.databinding.MainActivityConstraintBinding
import com.example.bai2_android_linearlayout.databinding.MainActivityLinearBinding
import com.example.bai2_android_linearlayout.ui.theme.Bai2AndroidLinearLayoutTheme
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : MainActivityLinearBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityLinearBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectDate.setOnClickListener {
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, {
                view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                binding.birthday.setText(dat)
            },
                year, month, day)

            datePickerDialog.show()
        }

        binding.registerButton.setOnClickListener {
            var warning : String = "";

            if (binding.fname.text.isEmpty())
                warning += "First name is empty \n"

            if (binding.lname.text.isEmpty())
                warning += "Last name is empty \n"

            if (!binding.female.isChecked && !binding.male.isChecked)
                warning += "Gender is not checked \n"

            if (binding.birthday.text.isEmpty())
                warning += "Birthday is empty \n"

            if (binding.address.text.isEmpty())
                warning += "Address is empty \n"

            if (binding.mail.text.isEmpty())
                warning += "Email is empty \n"

            if (!binding.checkbox.isChecked)
                warning += "Please agree with the Term of Use"

            if (warning != "")
                Toast.makeText(this, warning, Toast.LENGTH_LONG).show()
        }
    }
}
