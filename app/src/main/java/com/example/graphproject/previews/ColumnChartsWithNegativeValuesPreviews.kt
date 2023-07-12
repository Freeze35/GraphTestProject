/*
 * Copyright 2023 by Patryk Goworowski and Patrick Michalik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.graphproject.previews

import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.showcase.rememberMarker
import com.patrykandpatrick.vico.compose.axis.horizontal.bottomAxis
import com.patrykandpatrick.vico.compose.axis.vertical.endAxis
import com.patrykandpatrick.vico.compose.axis.vertical.startAxis
import com.patrykandpatrick.vico.compose.chart.Chart
import com.patrykandpatrick.vico.compose.chart.column.columnChart
import com.patrykandpatrick.vico.core.chart.values.AxisValuesOverrider
import com.patrykandpatrick.vico.core.component.text.textComponent
import com.patrykandpatrick.vico.core.entry.entryModelOf

private val model = entryModelOf(2f, -1f, 4f, -2f, 1f, 5f, -3f)

@Preview
@Composable
fun SingleColumnChartWithNegativeValues() {
    val marker = rememberMarker()
    Surface {
        Chart(
            modifier = Modifier.height(250.dp),
            chart = columnChart(
                persistentMarkers = mapOf(
                    2f to marker,
                    3f to marker,
                    4f to marker,
                ),
            ),
            model = model,
            endAxis = endAxis(maxLabelCount = 6),
            startAxis = startAxis(maxLabelCount = 6),
            bottomAxis = bottomAxis(),
        )
    }
}

@Preview
@Composable
fun SingleColumnChartWithNegativeValuesAndDataLabels() {
    Surface {
        Chart(
            chart = columnChart(
                dataLabel = textComponent(),
            ),
            model = model,
            startAxis = startAxis(),
            bottomAxis = bottomAxis(),
        )
    }
}

@Preview
@Composable
fun SingleColumnChartWithNegativeValuesAndAxisValuesOverridden() {
    Surface {
        Chart(
            chart = columnChart(
                axisValuesOverrider = AxisValuesOverrider.fixed(
                    minY = 1f,
                    maxY = 4f,
                ),
            ),
            model = model,
            startAxis = startAxis(maxLabelCount = 1),
            bottomAxis = bottomAxis(),
        )
    }
}

@Preview
@Composable
fun SingleColumnChartWithNegativeValuesAndAxisValuesOverridden2() {
    Surface {
        Chart(
            chart = columnChart(
                axisValuesOverrider = AxisValuesOverrider.fixed(
                    minY = -2f,
                    maxY = 0f,
                ),
            ),
            model = model,
            startAxis = startAxis(maxLabelCount = 3),
            bottomAxis = bottomAxis(),
        )
    }
}
