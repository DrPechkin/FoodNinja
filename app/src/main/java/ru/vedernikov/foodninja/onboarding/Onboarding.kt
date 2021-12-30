package ru.vedernikov.foodninja.onboarding

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.vedernikov.foodninja.R
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme
import ru.vedernikov.foodninja.ui.theme.getPrimaryTextColor

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
@Composable
fun OnboardScreenPreview() {
    FoodNinjaTheme {
        OnboardScreen(
            title = "Find your Comfort\nFood here",
            description = "Here You Can find a chef or dish for every\ntaste and color. Enjoy!"
        ) {

        }
    }
}

@Composable
fun OnboardScreen(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    onNextClick: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            modifier = Modifier
                .padding(top = 56.dp)
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.illustartion),
            contentDescription = null
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 40.dp),
                text = title,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                lineHeight = 29.sp
            )
            Text(
                modifier = Modifier.padding(top = 20.dp),
                text = description,
                textAlign = TextAlign.Center,
                lineHeight = 22.sp,
                textDecoration = TextDecoration.None,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.caption
            )

            TextButton(
                modifier = Modifier
                    .padding(bottom = 60.dp, top = 42.dp)
                    .background(
                        brush = Brush.horizontalGradient(
                            listOf(
                                Color(0xff53E88B),
                                Color(0xff15BE77)
                            )
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ),
                contentPadding = PaddingValues(vertical = 18.dp, horizontal = 60.dp),
                onClick = onNextClick
            ) {
                Text(
                    text = stringResource(id = R.string.btn_next),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = getPrimaryTextColor(),
                )
            }
        }
    }
}