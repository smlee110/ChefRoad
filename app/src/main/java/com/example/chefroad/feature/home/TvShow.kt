package com.example.chefroad.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape

@Composable
fun TvShow(onShowClick: (String) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = { onShowClick("흑백요리사") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF90CAF9)
            )
        ) {
            Text(
                text = "흑백요리사",
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = { onShowClick("수요미식회") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFAB91)
            )
        ) {
            Text(
                text = "수요미식회",
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        Button(
            onClick = { onShowClick("줄서는 식당") },
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFA5D6A7)
            )
        ) {
            Text(
                text = "줄서는 식당",
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}
