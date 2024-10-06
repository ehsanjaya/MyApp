package com.example.myapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp.ui.theme.MyAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            com.example.myapp.Preview()
        }
    }
}

@Composable

fun Profile(name: String, hobby: String, description: String) {
    val context = LocalContext.current

    Row(modifier = Modifier.fillMaxSize()) {
        Column {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .border(
                            3.dp,
                            MaterialTheme.colorScheme.secondary,
                            RoundedCornerShape(10.dp)
                        )
                )
                Column {
                    Text(
                        text = name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = hobby,
                        fontSize = 15.sp,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }

            Row {
                Surface(
                    shape = MaterialTheme.shapes.medium,
                    shadowElevation = 3.dp,
                    modifier = Modifier.padding(top = 10.dp)
                )
                {
                    Column(
                        modifier = Modifier
                            .size(150.dp, 170.dp)
                            .verticalScroll(rememberScrollState())
                    ) {
                        Text(
                            text = description,
                            fontSize = 11.sp,
                            lineHeight = 16.sp,
                            modifier = Modifier
                                .size(150.dp, 170.dp)
                                .padding(10.dp)
                        )
                    }
                }
                TextButton(
                    onClick = {},
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier
                        .padding(top = 10.dp)
                ) {
                    Text(text = "Edit Profile")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val configuration = LocalConfiguration.current

    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    LazyColumn (modifier = Modifier
        .verticalScroll(rememberScrollState())
        .size(width = screenWidth, height = screenHeight)) {
        item {

            Text(
                text = "Selamat Datang!",
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 10.dp)
            )

            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 40.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xF0F1F1F1))
                        .width(230.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mulai Membuat Jadwal!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Divider(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        thickness = 1.dp,
                        Color.DarkGray
                    )
                }
                Box(
                    modifier = Modifier
                        .background(Color(0xF0F1F1F1))
                        .width(230.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            shadowElevation = 3.dp,
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(
                                text = "Kalau anda lupa membawa buku atau menaruh buku yang berbeda, jangan khawatir! jadwal ini bisa membantumu untuk menemukannya. Enable notifications untuk memulai pengingat jadwal anda. Buatlah jadwal anda sekarang!",
                                fontSize = 17.sp,
                                lineHeight = 20.sp,
                                modifier = Modifier
                                    .width(190.dp)
                                    .padding(10.dp)
                            )
                        }

                        ElevatedButton(
                            onClick = {},
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text(
                                text = "Mulai!",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = 10.dp, top = 20.dp),
                horizontalAlignment = Alignment.End,
            ) {
                Box(
                    modifier = Modifier
                        .background(Color(0xF0F1F1F1))
                        .width(230.dp)
                        .height(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mulai Membuat AKS!",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 10.dp)
                    )

                    Divider(
                        modifier = Modifier
                            .align(Alignment.BottomCenter),
                        thickness = 1.dp,
                        Color.DarkGray
                    )
                }
                Box(
                    modifier = Modifier
                        .background(Color(0xF0F1F1F1))
                        .width(230.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Column {
                        Surface(
                            shape = MaterialTheme.shapes.medium,
                            shadowElevation = 3.dp,
                            modifier = Modifier.padding(top = 10.dp)
                        ) {
                            Text(
                                text = "Kalau anda ingin mencatat AKS anda atau ketinggalan mencatat AKS anda, jangan khawatir! AKS ini bisa membantumu untuk mencatatnya. AKS itu biasanya dipanggil Apps Kepribadian Siswa. Enable notifications untuk tidak ketinggalan mencatat AKS anda. Catalah AKS anda sekarang!",
                                fontSize = 17.sp,
                                lineHeight = 20.sp,
                                modifier = Modifier
                                    .width(190.dp)
                                    .padding(10.dp)
                            )
                        }

                        ElevatedButton(
                            onClick = {},
                            contentPadding = PaddingValues(5.dp),
                        ) {
                            Text(
                                text = "Mulai!",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Row(modifier = Modifier
                .background(color = Color(0xF0141414))
                .padding(3.dp),
                verticalAlignment = Alignment.CenterVertically) {

            }
        }
    }
}

@Composable
fun Menu(drawerState: DrawerState, scope: CoroutineScope) {
    Row(modifier = Modifier
        .background(color = Color(0xFF00903D))
        .padding(3.dp),
        verticalAlignment = Alignment.CenterVertically) {
        Button(
            onClick = {
                scope.launch {
                    drawerState.open()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF249E58)),
            modifier = Modifier.size(50.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape
            ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu Navigation Drawer",
                tint = Color(0XFF000000),
                        modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { /*TODO*/ }) {
            Image(
                painter = painterResource(id = R.drawable.mtsn1lumajang),
                contentDescription = "Quiz Profile",
                modifier = Modifier.size(70.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationDrawer() {
    val drawerItem = listOf(
        DrawerItems(Icons.Default.Home, 0,  false, "Home"),
        DrawerItems(Icons.Default.Face, 0,  false, "Profile"),
        DrawerItems(Icons.Default.DateRange, 0,  false, "Schedule"),
        DrawerItems(Icons.Default.Edit, 0,  false, "AKS"),
        DrawerItems(Icons.Default.Settings, 0,  false, "Settings")
    )
    var selectedItem by remember {
        mutableStateOf(drawerItem[0])
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerContent = {
        ModalDrawerSheet {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(17.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(Color(0xFF00903D)),
                    contentAlignment = Alignment.Center
                )
                {
                    Column(
                        modifier = Modifier.wrapContentSize(),
                        verticalArrangement = Arrangement.SpaceAround,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mtsn1lumajang),
                            contentDescription = "Profile",
                            modifier = Modifier.size(130.dp)
                        )
                        Text(
                            text = "Menu",
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 10.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                    }

                    Divider(
                        Modifier.align(Alignment.BottomCenter),
                        thickness = 1.dp,
                        Color.DarkGray
                    )
                }

                drawerItem.forEach {
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = it.text,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        modifier = Modifier.padding(horizontal = 17.dp),
                        selected = it == selectedItem,
                        onClick = {
                            selectedItem = it
                            scope.launch {
                                drawerState.close()
                            }
                        },
                        icon = {
                            Icon(imageVector = it.icon, contentDescription = it.text)
                        },
                        badge = {
                            if(it.hasBadge) {
                                BadgedBox(
                                    badge = {
                                        Badge {
                                            Text(
                                                text = it.badgeCount.toString(),
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,
                                                textAlign = TextAlign.Center
                                            )
                                        }
                                    }
                                ) {
                                    Icon(imageVector = Icons.Default.Info, contentDescription = "Information")
                                }
                            }
                        }
                    )
                }
            }

        }
    }, drawerState = drawerState) {
        Column {
            Menu(drawerState = drawerState, scope = scope)
            /*Profile(
                "Pramarta Ehsan Jaya",
                "Progammer",
                "Halo, perkenalkan nama saya Pramarta Ehsan Jaya atau dipanggil ehsan. Saya siswa kelas 7 dari Mts Negeri 1 Lumajang, Jawa Timur."
            )*/
        }
    }
}

data class DrawerItems(
    val icon : ImageVector,
    val badgeCount : Int,
    val hasBadge : Boolean,
    val text : String
)

@Preview(showBackground = true)
@Composable
fun Preview() {
    MyAppTheme {
        NavigationDrawer()
    }
}