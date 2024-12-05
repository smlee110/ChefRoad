package com.example.chefroad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.chefroad.feature.restaurant.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RestaurantInfoScreen(
                restaurantName = "맛있는 식당",
                phoneNumber = "02-1234-5678",
                address = "서울특별시 xx구 xx로 123",
                openingHours = "11:00 - 22:00",
                weeklyHours = listOf(
                    "11:00 - 22:00", // 월
                    "11:00 - 22:00", // 화
                    "11:00 - 22:00", // 수
                    "11:00 - 22:00", // 목
                    "11:00 - 22:00", // 금
                    "11:00 - 23:00", // 토
                    "11:00 - 23:00"  // 일
                ),
                menuItems = listOf(
                    MenuItem("김치찌개", 7000, null),
                    MenuItem("된장찌개", 8000, null),
                    MenuItem("삼겹살", 12000, null),
                    MenuItem("불고기", 15000, null),
                    MenuItem("비빔밥", 9000, null),
                    MenuItem("냉면", 10000, null),
                    MenuItem("칼국수", 8500, null),
                    MenuItem("떡볶이", 6000, null),
                    MenuItem("라면", 5000, null),
                    MenuItem("김밥", 4500, null)
                ),
                reviews = listOf(
                    Review("A", "맛있어요!", null),
                    Review("B", "서비스가 좋아요!", null),
                    Review("C", "분위기가 좋아요!", null)
                ),
                imageResId = null, // 기본 이미지를 사용
                allergyIcons = listOf(
                    R.drawable.placeholder,
                    R.drawable.placeholder,
                    R.drawable.placeholder
                ),
                waitTime = "20분"
            )
        }
    }
}
