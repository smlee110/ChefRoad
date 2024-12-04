package com.example.chefroad.feature.restaurant

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chefroad.R

@Composable
fun RestaurantInfoScreen(
    restaurantName: String,
    phoneNumber: String,
    address: String,
    openingHours: String,
    menuItems: List<MenuItem>, // 메뉴 데이터
    reviews: List<Review>, // 리뷰 데이터
    imageResId: Int?,
    allergyIcons: List<Int>, // 알레르기 아이콘 리스트
    waitTime: String // 예상 대기시간
) {
    // 현재 선택된 탭 상태 관리
    var selectedTab by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(56.dp)) // TopBar처럼 보이는 빈 공간

        // 식당 정보 카드
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), // 높이를 늘려 알레르기 아이콘과 대기시간 표시 공간 확보
            shape = RoundedCornerShape(8.dp),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 왼쪽: 이미지와 추가 정보
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 큰 이미지
                    Image(
                        painter = painterResource(id = imageResId ?: R.drawable.placeholder),
                        contentDescription = "Restaurant Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    // 알레르기 아이콘
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        allergyIcons.forEach { iconResId ->
                            Image(
                                painter = painterResource(id = iconResId),
                                contentDescription = "Allergy Icon",
                                modifier = Modifier
                                    .size(24.dp)
                                    .padding(4.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    // 예상 대기시간
                    Text(
                        text = "예상 대기시간: $waitTime",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = androidx.compose.ui.graphics.Color.Black
                    )
                }

                // 오른쪽: 텍스트 정보
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(2f)
                        .padding(8.dp),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = restaurantName,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = androidx.compose.ui.graphics.Color.Black
                    )
                    Text(
                        text = "전화번호: $phoneNumber",
                        fontSize = 14.sp,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                    Text(
                        text = "주소: $address",
                        fontSize = 14.sp,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                    Text(
                        text = "영업시간: $openingHours",
                        fontSize = 14.sp,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 탭 UI
        TabRow(
            selectedTabIndex = selectedTab,
            modifier = Modifier.fillMaxWidth()
        ) {
            Tab(
                selected = selectedTab == 0,
                onClick = { selectedTab = 0 },
                text = { Text("메뉴") }
            )
            Tab(
                selected = selectedTab == 1,
                onClick = { selectedTab = 1 },
                text = { Text("리뷰") }
            )
        }

        // 탭에 따른 콘텐츠 표시
        when (selectedTab) {
            0 -> MenuTabContent(menuItems = menuItems) // 메뉴 탭
            1 -> ReviewTabContent(reviews = reviews) // 리뷰 탭
        }
    }
}

@Composable
fun MenuTabContent(menuItems: List<MenuItem>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(menuItems) { menuItem ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // 메뉴 이미지
                Image(
                    painter = painterResource(id = menuItem.imageResId ?: R.drawable.placeholder),
                    contentDescription = "Menu Image",
                    modifier = Modifier
                        .size(64.dp)
                        .padding(end = 8.dp)
                )
                // 메뉴 이름과 가격
                Column {
                    Text(
                        text = menuItem.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "${menuItem.price}원", // 가격 표시
                        fontSize = 14.sp,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                }
            }
            Divider()
        }
    }
}

@Composable
fun ReviewTabContent(reviews: List<Review>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(reviews) { review ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // 리뷰 이미지
                Image(
                    painter = painterResource(id = review.userImageResId ?: R.drawable.placeholder),
                    contentDescription = "User Image",
                    modifier = Modifier
                        .size(48.dp)
                        .padding(end = 8.dp)
                )
                // 리뷰 내용
                Column {
                    Text(
                        text = review.userName,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = review.content,
                        fontSize = 14.sp,
                        color = androidx.compose.ui.graphics.Color.Gray
                    )
                }
            }
            Divider()
        }
    }
}

// 메뉴와 리뷰 데이터를 위한 데이터 클래스
data class MenuItem(val name: String, val price: Int, val imageResId: Int?)
data class Review(val userName: String, val content: String, val userImageResId: Int?)
