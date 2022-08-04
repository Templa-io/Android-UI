package com.sefu.ecoui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sefu.ecoui.model.Category
import com.sefu.ecoui.model.Product
import com.sefu.ecoui.ui.theme.EcoUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EcoUITheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = colorResource(id = R.color.simplebackgroundcolor)
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.simplebackgroundcolor)),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
//        SearchBar()
//        Spacer(modifier = Modifier.height(24.dp))
//        Categories()
//        Spacer(modifier = Modifier.height(24.dp))
//        Content()
//        GridItems()
//        SignInScreen()
        TopContent()

    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(24.dp))
                .weight(1.0f)
                .fillMaxWidth()
                .height(40.dp)
                .background(color = Color.Gray.copy(alpha = 0.3f))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    Icons.Outlined.Search, contentDescription = "search button",
                    modifier = Modifier
                        .padding(start = 8.dp),
                    tint = Color.Black
                )


                TextField(
                    modifier = Modifier
                        .fillMaxSize(),
                    value = "",
                    onValueChange = {},
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Gray,
                        disabledTextColor = Color.Transparent,
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )


            }

        }
        Spacer(modifier = Modifier.width(4.dp))
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(48.dp)
                .background(color = Color.Green),

            ) {
            Icon(
                Icons.Outlined.ShoppingCart,
                modifier = Modifier.align(alignment = Alignment.Center),
                contentDescription = "shopping cart",
                tint = Color.White
            )

        }
    }
}

@Composable
fun Categories(modifier: Modifier = Modifier) {
    val listOfCategory = mutableListOf(
        Category(image = R.drawable.highheel, name = "Heels"),
        Category(image = R.drawable.dress, name = "Dress"),
        Category(image = R.drawable.headphones, "Headphones"),
        Category(image = R.drawable.fashion, "Fashion"),
        Category(image = R.drawable.salary, "Salary")
    )

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Categories",
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        LazyRow(content = {
            items(count = listOfCategory.size, itemContent = {
                CategoryItem(
                    imageValue = listOfCategory[it].image,
                    nameValue = listOfCategory[it].name
                )
            })

        })
    }
}

@Composable
fun CategoryItem(imageValue: Int, nameValue: String) {
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(16.dp)

    ) {
        Box(
            modifier = Modifier
                .clip(shape = CircleShape)
                .size(48.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = imageValue),
                contentDescription = "category image",
                modifier = Modifier
                    .size(28.dp)
                    .align(alignment = Alignment.Center)
            )

        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = nameValue,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun Content() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Best Selling",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )

        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent),
        ) {
            Text(
                text = "See All",

                )
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}

@Composable
fun GridItem(ImageValue: Int, NameValue: String, priceValue: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(id = ImageValue),
            contentDescription = "Smart Watch",
        )

        Text(text = NameValue, fontWeight = FontWeight.Bold, color = Color.Black)
        Text(text = NameValue, color = Color.Gray, fontSize = 12.sp)
        Text(
            text = priceValue,
            color = Color.Red,
            fontWeight = FontWeight.Bold
        )

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridItems() {
    val productList = mutableListOf(
        Product(image = R.drawable.smartwatch, name = "LeatherWatch", price = "$350"),
        Product(image = R.drawable.ladies, name = "Dress", price = "$200"),
        Product(image = R.drawable.shoes, name = "shoes", price = "$250"),
        Product(image = R.drawable.mens, name = "Shirts", price = "$150")
    )

    LazyVerticalGrid(
        cells = GridCells.Fixed(2), modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
    ) {
        items(productList.size) {
            GridItem(
                ImageValue = productList[it].image,
                NameValue = productList[it].name,
                priceValue = productList[it].price
            )
        }
    }
}

@Composable
fun SignInScreen() {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//
//    Scaffold(modifier = Modifier) {
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Top,
//            modifier = Modifier
//                .fillMaxSize()
//
//        ) {
//            Image(
//                painter = painterResource(id = R.drawable.signin),
//                contentDescription = "Login logo", modifier =Modifier.size(300.dp)
//            )
//            Text(
//                text = "Login",
//                fontWeight = FontWeight.Bold,
//                fontSize = 32.sp,
//                color = Color.Blue
//
//                )
//            Spacer(modifier = Modifier.height(8.dp))
//            Card(
//                elevation = 10.dp,
//                modifier = Modifier
//                    .padding(16.dp)
//                    .height(200.dp)
//
//            ) {
//                Column(
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxSize()
//
//                ) {
//                    OutlinedTextField(
//                        value = username,
//                        onValueChange = { username = it },
//                        singleLine = true,
//                        label = { Text(text = "username") })
//                    Spacer(modifier = Modifier.height(8.dp))
//                    OutlinedTextField(
//                        value = password,
//                        onValueChange = { password = it },
//                        label = { Text(text = "password") },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = KeyboardType.Password,
//                        )
//                    )
//                }
//
//            }
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(start = 30.dp, top = 20.dp),
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(text = "Remember me", fontSize = 20.sp)
//                Button(modifier=Modifier.width(150.dp),onClick = { },shape = RoundedCornerShape(topStart = (30.dp), bottomStart = (30.dp))) {
//                    Text(text = "LOGIN", textAlign = TextAlign.Center, fontSize = 20.sp)
//
//
//                }
//            }
//            Spacer(modifier = Modifier.height(16.dp))
//            Box(modifier = Modifier.fillMaxWidth()) {
//                Text(text = "Sign up",
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 32.sp,
//                    color = Color.Blue,
//                    modifier = Modifier.align(alignment = Alignment.Center)
//                )
//            }
//        }
//
//    }

}

@Composable
fun TopContent(modifier: Modifier=Modifier) {
   Column(modifier = modifier.fillMaxWidth()) {
       Row(
           modifier = Modifier
               .fillMaxWidth()
               .padding(20.dp), horizontalArrangement = Arrangement.SpaceBetween,
           verticalAlignment = Alignment.CenterVertically
       ) {
           Image(
               modifier = Modifier.size(32.dp),
               painter = painterResource(id = R.drawable.cloud),
               contentDescription = "cloud"
           )
           TextButton(onClick = { /*TODO*/ }) {
               Text(
                   text = "Skip",
                   color = Color.Black
               )

           }
       }
       Box(modifier = Modifier.fillMaxWidth()) {
           Image(
               modifier = Modifier
                   .align(alignment = Alignment.Center)
                   .size(200.dp),
               painter = painterResource(id = R.drawable.boy),
               contentDescription = ""
           )
       }
       Column(
           modifier = Modifier
               .fillMaxWidth()
               .padding(32.dp)
       ) {
           Text(text = "We will take\ncare", fontWeight = FontWeight.Bold, fontSize = 46.sp)
           Spacer(modifier = Modifier.height(8.dp))
           Text(text = "of tickets, transfers and a\ncool place to stay", fontSize = 20.sp)
       }
   }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.size(100.dp),
            painter = painterResource(id = R.drawable.png),
            contentDescription = "",
            colorFilter = ColorFilter.tint(color = Color.Black)
        )

        Box(
            modifier = Modifier
                .size(60.dp)
                .background(color = Color.White, shape = RoundedCornerShape(size = 16.dp))
        ) {

        }
    }
}

@Preview
@Composable
fun MainScreenPreview() {
    EcoUITheme {
        MainScreen()
    }
}

@Preview
@Composable
fun SearchBarPreview() {
    EcoUITheme {
        SearchBar()
    }
}

@Preview
@Composable
fun CategoriesPreview() {
    EcoUITheme {
        Categories()
    }
}


@Preview
@Composable
fun CategoryItemPreview() {
    EcoUITheme {
        CategoryItem(imageValue = R.drawable.highheel, nameValue = "")
    }
}

@Preview
@Composable
fun ContentPreview() {
    EcoUITheme {
        Content()
    }
}

@Preview
@Composable
fun GridItemPreview() {
    EcoUITheme {
        GridItem(ImageValue = R.drawable.mens, NameValue = "", priceValue = "")
    }
}

@Preview
@Composable
fun GridItemsPreview() {
    EcoUITheme {
        GridItems()
    }
}

@Preview
@Composable
fun SignInScreenPreview() {
    EcoUITheme {
        SignInScreen()
    }
}

@Preview
@Composable
fun TopContentPreview() {
    EcoUITheme {
        TopContent()
    }
}