package com.practice.carstore.core.presentation.component

import android.graphics.Typeface
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Hazrat Ummar Shaikh
 */

@Composable
fun FeatureCarsCard(
    modifier: Modifier = Modifier,
    image: Painter,
    text: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val path2 = Path().apply {
                moveTo(0f, height / 1.7f)
                lineTo(width / 6, height / 1.7f)
                lineTo(width / 5, height / 2.5f)
                lineTo(0f, height / 2.5f)
                close()
            }
            val path3 = Path().apply {
                moveTo(width / 3, 0f)
                lineTo(width / 5, height / 6)
                lineTo(width / 3, height / 6)
                close()
            }
            drawPath(
                path3,
                color = Color(0xff7B330A)
            )
            drawPath(
                path2,
                color = Color(0xff7B330A)
            )

        }
        Card(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.BottomEnd)
                .padding(start = 30.dp, top = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(20.dp)
        ) {
            Box (
                modifier = Modifier.fillMaxSize()
            ){
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = image,
                    contentDescription = "car image",
                    contentScale = ContentScale.Crop
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(start = 10.dp, bottom = 10.dp),
                    text = text,
                    color = Color.White
                )
            }
        }
        val typeface = Typeface.create(
            Typeface.DEFAULT_BOLD,
            Typeface.BOLD
        )
        val paint = Paint().asFrameworkPaint().apply {
            color = Color.White.toArgb()
            textSize = 50.sp.value
            this.typeface = typeface
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height
            val path = Path().apply {
                moveTo(0f, height / 3f)
                lineTo(0f, height / 1.7f)
                lineTo(width / 3, 0f)
                lineTo(width / 5, 0f)
                close()
            }
            drawPath(
                path = path,
                color = Color(0xffFF5C00)
            )
            rotate(degrees = -43f, pivot = Offset(250f, 20f)) {
                drawIntoCanvas {
                    it.nativeCanvas.drawText("Featured", 0f, 50f, paint)
                }
            }
        }
    }
}
