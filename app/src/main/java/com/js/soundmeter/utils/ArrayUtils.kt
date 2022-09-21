package com.js.soundmeter.utils

/**
 * 数组工具类
 *
 */
object ArrayUtils {

    /**
     * 求一个数组的总和
     */
    @JvmStatic
    fun sum(data: IntArray): Int {
        var sum = 0
        for (s in data) {
            sum += s
        }
        return sum
    }

    /**
     * 求一个数组的总和
     */
    @JvmStatic
    fun sum(data: List<Double>): Double {
        var sum = 0.0
        for (i in data.indices) {
            sum += data[i]
        }
        return sum
    }

    /**
     * 求一个数组的平均数
     */
    @JvmStatic
    fun avg(data: IntArray): Int {
        return if (data.isEmpty()) {
            0
        } else {
            sum(data) / data.size
        }
    }

    /**
     * 求一个数组的平均数
     */
    @JvmStatic
    fun avg(data: List<Double>): Double {
        return if (data.isEmpty()) {
            0.0
        } else {
            sum(data) / data.size
        }
    }

    /**
     * 截取数组
     */
    @JvmStatic
    fun sub(allVolume: List<Double>, num: Int): DoubleArray {
        val da = DoubleArray(num)
        if (allVolume.size < num) {// 长度不够
            for (i in allVolume.indices) {
                da[i] = allVolume[i]
            }
        } else {// 长度足够。选取后半部分
            val index = allVolume.size - num
            for (i in 0 until num) {
                da[i] = allVolume[index + i]
            }
        }
        return da
    }
}
