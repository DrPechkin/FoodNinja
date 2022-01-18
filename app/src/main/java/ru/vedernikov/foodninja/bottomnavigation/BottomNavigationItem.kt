package ru.vedernikov.foodninja.bottomnavigation

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.vedernikov.foodninja.R
import ru.vedernikov.foodninja.ui.theme.FoodNinjaTheme
import ru.vedernikov.foodninja.ui.theme.PrimaryColorGradient
import ru.vedernikov.foodninja.ui.theme.getPrimaryTextColor

@ExperimentalAnimationApi
@Preview
@Composable
fun BottomNavigationItemPreview() {
    FoodNinjaTheme {
        BottomNavigationItemButton(
            title = stringResource(id = R.string.label_bottom_bar_home),
            iconId = R.drawable.ic_bottom_home_active,
            selected = true,
            onClick = {}
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun BottomNavigationItemButton(
    modifier: Modifier = Modifier,
    selected: Boolean,
    title: String,
    @DrawableRes iconId: Int,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                brush = PrimaryColorGradient,
                shape = RoundedCornerShape(16.dp),
                alpha = if (selected) 0.1f else 0f
            )
            .selectable(
                selected = selected,
                interactionSource = remember { MutableInteractionSource() },
                onClick = onClick,
                indication = null
            )
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Image(
                painter = painterResource(id = iconId),
                modifier = Modifier.alpha(if (selected) 1f else 0.4f),
                contentDescription = null
            )

            AnimatedVisibility(visible = selected) {
                Text(
                    text = title,
                    color = getPrimaryTextColor()
                )
            }
        }
    }
}