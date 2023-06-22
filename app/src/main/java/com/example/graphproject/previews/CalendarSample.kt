package com.example.graphproject.previews

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxkeppeker.sheets.core.models.base.rememberSheetState
import com.maxkeppeler.sheets.calendar.CalendarDialog
import com.maxkeppeler.sheets.calendar.models.CalendarConfig
import com.maxkeppeler.sheets.calendar.models.CalendarSelection
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CalendarSample() {

        val calendarState = rememberSheetState() //maxkeppeker state value
        val selectedDates = remember { mutableStateOf<List<LocalDate>>(listOf()) }

        Log.d("date",selectedDates.value.size.toString())

        CalendarDialog(
            state = calendarState,
            config = CalendarConfig(
                monthSelection = true,
                yearSelection = true
            ),
            selection = CalendarSelection.Dates(onNegativeClick= { Log.d("onExtraButtonClick","onExtraButtonClick") }){
                    newDate ->
                selectedDates.value = newDate
                selectedDates.value.map { d->
                    Log.d("date",d.toString())
                }
                Log.d("selectedDates.value", selectedDates.value.size.toString())

                // current list sorted date reversed after sorting
                // date formatter
                val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                //sort
                val result = selectedDates.value.sortedByDescending {
                    LocalDate.parse(it.toString(), dateTimeFormatter)
                }.reversed()

                Log.d("resultresult", result.toString())
            }

        )

        Column(
            modifier = Modifier
                .fillMaxSize()
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            Button(onClick = { calendarState.show() }) {
                Text(text = "Date Picker")

            }


        }
}