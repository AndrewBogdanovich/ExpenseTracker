package com.example.expensetracker.presentation.view.achivement

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.expensetracker.presentation.DevicesPreview
import com.example.expensetracker.presentation.model.Achievement

@Composable
fun AchievementListView(navController: NavController) {
    val items = ArrayList<Achievement>()
    items.add(
        Achievement(
            "Git",
            "git details",
            0.4f,
            "https://w7.pngwing.com/pngs/914/758/png-transparent-github-social-media-computer-icons-logo-android-github-logo-computer-wallpaper-banner-thumbnail.png"
        )
    )
    items.add(
        Achievement(
            "JetpackCompose",
            "jetpack compose details",
            0.2f,
            "https://3.bp.blogspot.com/-VVp3WvJvl84/X0Vu6EjYqDI/AAAAAAAAPjU/ZOMKiUlgfg8ok8DY8Hc-ocOvGdB0z86AgCLcBGAsYHQ/s1600/jetpack%2Bcompose%2Bicon_RGB.png"
        )
    )
    items.add(
        Achievement(
            "Room",
            "room details",
            0f,
            "https://cdn-icons-png.flaticon.com/512/603/603156.png"
        )
    )
    items.add(
        Achievement(
            "Retrofit",
            "retrofit details",
            1f,
            "https://img.stackshare.io/service/2856/retrofit-logo.png"
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(items) { item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 20.dp)
            ) {
                AsyncImage(
                    model = item.imageSource,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(80.dp)
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp, 0.dp, 0.dp, 0.dp),
                ) {
                    Text(text = item.name, fontSize = 20.sp)
                    Text(text = item.details)
                    LinearProgressIndicator(
                        progress = item.progress, modifier = Modifier
                            .fillMaxWidth()
                            .height(18.dp)
                            .padding(0.dp, 5.dp)
                    )
                }
            }
            Divider(color = Color.LightGray, thickness = 0.5.dp)
        }
    }
}

@DevicesPreview
@Composable
fun SignInPreview() {
    val navController = rememberNavController()
    AchievementListView(navController)
}