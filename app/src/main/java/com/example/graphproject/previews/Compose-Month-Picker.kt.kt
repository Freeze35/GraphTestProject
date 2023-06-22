package com.example.graphproject.previews

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.dt.composedatepicker.ComposeCalendar
import com.dt.composedatepicker.SelectDateListener

import java.util.Calendar
import java.util.Date
import java.util.Locale

@Preview
@Composable
fun ComposeDatePicker() {
    val calendar = Calendar.getInstance()
    calendar.set(Calendar.YEAR, 2010)
    calendar.set(Calendar.MONTH, 6)
    val calendarMax = Calendar.getInstance()
    calendarMax.set(Calendar.YEAR, 2032)
    calendarMax.set(Calendar.MONTH, 9)

    Box(
        modifier = Modifier
        .fillMaxSize()
        .background(color = Color.Gray), contentAlignment = Alignment.Center) {

        ComposeCalendar(minDate = calendar.time,
            maxDate = calendarMax.time,
            locale = Locale("en"),
            title = "Select Date",
            listener = object : SelectDateListener {
                override fun onDateSelected(date: Date) {
                    Log.i("DATE", date.toString())
                }

                override fun onCanceled() {
                }
            })
    }
}