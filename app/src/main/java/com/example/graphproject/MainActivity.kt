package com.example.graphproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.graphproject.ui.theme.GraphProjectTheme
import com.example.graphproject.ui.theme.previews.utils.VicoTheme
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.compose.chart.scroll.rememberChartScrollSpec
import com.patrykandpatrick.vico.compose.component.lineComponent
import com.patrykandpatrick.vico.compose.component.shape.shader.verticalGradient
import com.patrykandpatrick.vico.compose.component.shapeComponent
import com.patrykandpatrick.vico.compose.component.textComponent
import com.patrykandpatrick.vico.compose.dimensions.dimensionsOf
import com.patrykandpatrick.vico.core.axis.AxisPosition
import com.patrykandpatrick.vico.core.axis.formatter.AxisValueFormatter
import com.patrykandpatrick.vico.core.axis.vertical.createVerticalAxis
import com.patrykandpatrick.vico.core.component.shape.LineComponent
import com.patrykandpatrick.vico.core.entry.entriesOf
import com.patrykandpatrick.vico.core.entry.entryModelOf


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GraphProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                ) {
                    DoubleBar()
                }
            }
        }
    }
}


val positiveColor: Color = Color(0xFF48FF85)
val positiveColor2: Color = Color(0xFF00FCD6)
val negativeColor: Color = Color(0xFFF5A6B5)
val negativeColor2: Color = Color(0xFFE40123)
val axisNumericalColor: Color = Color(0xFF48FF85)

//Class for our text field
data class HeadData(
    var name: String,
    var value: String,
)

//Data for showing many text and set them numbers(or text)
private val textNameValue = mutableListOf(
    HeadData("За месяц", "24"),
    HeadData("По клиенту", "44"),
    HeadData("По точке", "34")
)

var EntryData = entryModelOf(
    entriesOf(3, 2, 2, 3, 1, 3, 2, 2, 3, 1),
    entriesOf(1, 3, 1, 2, 3, 1, 3, 1, 2, 3)
)

private val axisValueFormatter = AxisValueFormatter<AxisPosition.Horizontal.Bottom> { i, _ ->
    if ( i< 10) {
        "0${i+1}.02.2023"

    }
    else {
        "${i+1}.02.2023"
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun DoubleBar(): Unit = VicoTheme {

    Column(modifier = Modifier.fillMaxWidth()) {

        val pagerState = rememberPagerState()
        HorizontalPager(
            pageCount = 2,//set 2 pages chart and Table
            state = pagerState,
            key = { it },
            modifier = Modifier.fillMaxHeight(0.4f)
        ) {index ->
            // Our order chart
            if (index == 0){
                Chart(
                    modifier = Modifier
                        .fillMaxHeight(0.4f)
                        .zIndex(1f)
                    , // set height chart 40%
                    chart = columnChart(
                        columns = listOf(
                            lineComponent(
                                thickness = 8.dp, //size bar
                                shape = RoundedCornerShape(4.dp), //round bar
                                dynamicShader = verticalGradient(
                                    arrayOf(
                                        negativeColor,
                                        negativeColor2
                                    )
                                ), // colors for bar
                            ),
                            lineComponent(
                                thickness = 8.dp, //size bar
                                shape = RoundedCornerShape(4.dp), //round bar
                                dynamicShader = verticalGradient(
                                    arrayOf(
                                        positiveColor,
                                        positiveColor2
                                    )
                                ), // colors for bar
                            ),
                        ),
                    ),
                    endAxis = createVerticalAxis {
                        maxLabelCount = 8 // number of indicators on the right or left
                        label = textComponent(
                            color = axisNumericalColor,
                            textSize = 10.sp,
                            background = shapeComponent(
                                shape = CutCornerShape(  //change shaps one bar
                                    CornerSize(percent = 25),
                                    CornerSize(percent = 50),
                                    CornerSize(percent = 50),
                                    CornerSize(percent = 25),
                                ),
                                color = colors.primary.copy(alpha = 0.1f),
                            ),
                            padding = dimensionsOf(end = 8.dp, start = 4.dp),
                        )
                        axis = null
                        tick = null
                        guideline = LineComponent(
                            axisNumericalColor.copy(alpha = 0.1f).toArgb(), // color lines indicators
                            1.dp.value,
                        )
                    },
                    bottomAxis = bottomAxis(  // down numbers can change in date
                        label = textComponent(
                            color = axisNumericalColor,
                            textSize = 10.sp,
                        ),
                        valueFormatter = axisValueFormatter // See above for the description of the bottom axle
                    ),
                    model = @Suppress("MagicNumber") (EntryData), // our data from poutside for graph
                    chartScrollSpec = rememberChartScrollSpec(isScrollEnabled = true),
                )
            }
            else{
                Row(
                    modifier = Modifier.fillMaxHeight(0.4f).zIndex(1f)
                ) {
                    Text(
                        text = "TWEDSDSADd",
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        style = MaterialTheme.typography.bodySmall,
                        color = Color.Gray
                    )
                }
            }

        }

        //Text Data
        //Inside Rows (LazyRow( Column : 2Element))
        Row(modifier = Modifier
            .fillMaxWidth()

        )
        {
            LazyRow(
                modifier = Modifier.fillMaxWidth(0.5f),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                itemsIndexed(textNameValue) { _, text ->
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 2.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = text.name,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        Text(
                            text = text.value + " шт",
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }

                }
            }
            //Split Line
            Divider(
                color = Color.Black,
                modifier = Modifier //fill the max height
                    .width(1.dp)
                    .padding(top = 7.dp) //padding top
                    .height(26.dp) // height divider
            )

            //Right Side
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                itemsIndexed(textNameValue) { _, text ->
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 2.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = text.name,
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                        Text(
                            text = text.value + " шт",
                            textAlign = TextAlign.Center,
                            maxLines = 1,
                            style = MaterialTheme.typography.bodySmall,
                            color = Color.Gray
                        )
                    }

                }
            }
        }


    }
}