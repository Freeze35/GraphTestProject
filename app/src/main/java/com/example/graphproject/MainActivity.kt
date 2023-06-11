package com.example.graphproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    modifier = Modifier.height(200.dp),
                ) {
                    DoubleBar()
                }
            }
        }
    }
}

private val chartModifier = Modifier.height(300.dp)
val positiveColor: Color = Color(0xFF48FF85)
val positiveColor2: Color = Color(0xFF00FCD6)
val negativeColor: Color = Color(0xFFF5A6B5)
val negativeColor2: Color = Color(0xFFE40123)
val axisNumericalColor: Color = Color(0xFF48FF85)



@Preview
@Composable
fun DoubleBar(): Unit = VicoTheme {
        Chart(
            modifier = chartModifier,
            chart = columnChart(
                columns = listOf(
                    lineComponent(
                        thickness = 8.dp, //size bar
                        shape = RoundedCornerShape(4.dp), //round bar
                        dynamicShader = verticalGradient(arrayOf(negativeColor, negativeColor2)), // colors for bar
                    ),
                    lineComponent(
                        thickness = 8.dp, //size bar
                        shape = RoundedCornerShape(4.dp), //round bar
                        dynamicShader = verticalGradient(arrayOf(positiveColor, positiveColor2)), // colors for bar
                    ),
                ),
            ),
            endAxis = createVerticalAxis {
                maxLabelCount = 8 // number of indicators on the right or left
                label = textComponent(
                    color = axisNumericalColor,
                    textSize = 10.sp,
                    background = shapeComponent(
                        shape = CutCornerShape(
                            CornerSize(percent = 25),
                            CornerSize(percent = 50),
                            CornerSize(percent = 50),
                            CornerSize(percent = 25),
                        ),
                        color = colors.primary.copy(alpha = 0.1f),
                    ),
                    padding = dimensionsOf(end = 8.dp, start =4.dp),
                )
                axis = null
                tick = null
                guideline = LineComponent(
                    axisNumericalColor.copy(alpha = 0.1f).toArgb(), // color lines indicators
                    1.dp.value,
                )
            },
            bottomAxis = bottomAxis(
                label = textComponent(
                color = axisNumericalColor,)
            ),
            model = @Suppress("MagicNumber") (entryModelOf(entriesOf(3, 2, 2, 3, 1,3, 2, 2, 3, 1), entriesOf(1, 3, 1, 2, 3,1, 3, 1, 2, 3))),
            chartScrollSpec = rememberChartScrollSpec(isScrollEnabled = true),
            )

}