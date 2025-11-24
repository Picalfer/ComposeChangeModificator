package com.sport.composechangemodificator

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Greeting() {
    var isOnboardingVisible by remember { mutableStateOf(false) }

    // Структура экрана с текстом и кнопкой
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue.copy(alpha = 0.2F))
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        // Текст и кнопка
        Text(
            text = "Hello man!",
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Button(
            onClick = { isOnboardingVisible = true },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(text = "Click me!")
        }
    }

    // Вывод onboarding при необходимости
    if (isOnboardingVisible) {
        Onboarding(
            onDismiss = { isOnboardingVisible = false }
        )
    }
}


@Composable
fun Onboarding(onDismiss: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.5F))
    ) {

        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue.copy(alpha = 0.2F))
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            // Текст и кнопка
            Text(
                text = "Hello man!",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .border(2.dp, Color.Red)
            )
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(bottom = 16.dp)
                    .alpha(0F)
            ) {
                Text(text = "Click me!")
            }
        }

        Column(
            modifier = Modifier
                .padding(16.dp)
                .background(Color.White)
                .align(Alignment.Center)
                .padding(16.dp)
        ) {
            // Совет
            Text(
                text = "Прочитайте совет!",
                style = MaterialTheme.typography.bodyLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            // Текст совета
            Text(
                text = "Здесь можно добавить ваш текст совета, описывающий элементы, которые вы хотите подсветить.",
                textAlign = TextAlign.Center
            )
            // Кнопка закрытия onboarding
            Button(onClick = onDismiss) {
                Text(text = "Закрыть")
            }
        }
    }
}


