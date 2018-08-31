package com.zy.mini_games.swipe

import com.zy.mini_games.utils.loge
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Zhaoyue on 2018/8/22 0022.
 */
object LogicHelper {
    fun randomMines(xlength:Int,ylength:Int,x:Int,y:Int,count:Int): ArrayList<Int> {
        var total = xlength*ylength-1
        if (count >= total || count <= 0){
            loge("invalid count")
            throw IllegalArgumentException("invalid count"+count)
        }

        val randoms = arrayListOf(getIndexByXY(xlength, ylength, x, y))

        while (randoms.size <= count + 1){
            val next = Random().nextInt(xlength * ylength)
            if (!randoms.contains(next)){
                randoms.add(next)
            }
        }
        return randoms
    }

    fun getIndexByXY(xlength:Int,ylength:Int,x:Int,y:Int):Int{
        return x + y * xlength;
    }

    fun getXYbyIndex(xlength:Int,ylength:Int,index:Int):IntArray{
        val x = index%ylength
        val y = index/ylength
        return intArrayOf(x,y)
    }
}