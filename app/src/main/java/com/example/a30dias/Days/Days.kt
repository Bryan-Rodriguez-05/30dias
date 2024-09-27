package com.example.a30dias.Days

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.a30dias.R

data class Days(
    @StringRes val tittle : Int,
    @StringRes val name: Int,
    @StringRes val content : Int,
    val number_day : Int ,
    @DrawableRes val pic : Int

)

val datList = listOf(
    Days(R.string.Day, R.string.day1subtitle, R.string.day1Content, 1,R.drawable.imagen1),
    Days(R.string.Day, R.string.day2subtitle, R.string.day2Content, 2, R.drawable.imagen2),
    Days(R.string.Day, R.string.day3subtitle, R.string.day3Content, 3, R.drawable.imagen3),
    Days(R.string.Day, R.string.day4subtitle, R.string.day4Content, 4, R.drawable.imagen4),
    Days(R.string.Day, R.string.day5subtitle, R.string.day5Content, 5, R.drawable.imagen5),
    Days(R.string.Day, R.string.day6subtitle, R.string.day6Content, 6, R.drawable.imagen6),
    Days(R.string.Day, R.string.day7subtitle, R.string.day7Content, 7, R.drawable.imagen7),
    Days(R.string.Day, R.string.day8subtitle, R.string.day8Content, 8, R.drawable.imagen8),
    Days(R.string.Day, R.string.day9subtitle, R.string.day9Content, 9, R.drawable.imagen9),
    Days(R.string.Day, R.string.day10subtitle, R.string.day10Content, 10, R.drawable.imagen10),
    Days(R.string.Day, R.string.day11subtitle, R.string.day11Content, 11, R.drawable.imagen11),
    Days(R.string.Day, R.string.day12subtitle, R.string.day12Content, 12, R.drawable.imagen12),
    Days(R.string.Day, R.string.day13subtitle, R.string.day13Content, 13, R.drawable.imagen13),
    Days(R.string.Day, R.string.day14subtitle, R.string.day14Content, 14, R.drawable.imagen14),
    Days(R.string.Day, R.string.day15subtitle, R.string.day15Content, 15, R.drawable.imagen15),
    Days(R.string.Day, R.string.day16subtitle, R.string.day16Content, 16, R.drawable.imagen16),
    Days(R.string.Day, R.string.day17subtitle, R.string.day17Content, 17, R.drawable.imagen17),
    Days(R.string.Day, R.string.day18subtitle, R.string.day18Content, 18, R.drawable.imagen18),
    Days(R.string.Day, R.string.day19subtitle, R.string.day19Content, 19, R.drawable.imagen19),
    Days(R.string.Day, R.string.day20subtitle, R.string.day20Content, 20, R.drawable.imagen20),
    Days(R.string.Day, R.string.day21subtitle, R.string.day21Content, 21, R.drawable.imagen21),
    Days(R.string.Day, R.string.day22subtitle, R.string.day22Content, 22, R.drawable.imagen22),
    Days(R.string.Day, R.string.day23subtitle, R.string.day23Content, 23, R.drawable.imagen23),
    Days(R.string.Day, R.string.day24subtitle, R.string.day24Content, 24, R.drawable.imagen24),
    Days(R.string.Day, R.string.day25subtitle, R.string.day25Content, 25, R.drawable.imagen25),
    Days(R.string.Day, R.string.day26subtitle, R.string.day26Content, 26, R.drawable.imagen26),
    Days(R.string.Day, R.string.day27subtitle, R.string.day27Content, 27, R.drawable.imagen27),
    )