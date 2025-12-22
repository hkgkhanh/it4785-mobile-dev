/*
 * Copyright (C) 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.sqlbasics

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

data class ParkVisitorResult(
    val name: String,
    val park_visitors: Int?
)

@Dao
interface CaliforniaParkDao {

    @Query("SELECT * FROM park")
    suspend fun getAll(): List<CaliforniaPark>

    // Bài 4: Top 5 park nhiều khách nhất
    @Query("""
        SELECT name, park_visitors 
        FROM park 
        ORDER BY park_visitors DESC 
        LIMIT 5
    """)
    suspend fun getTop5Visitors(): List<ParkVisitorResult>

    // Bài 5: Đếm số thành phố khác nhau
    @Query("SELECT COUNT(DISTINCT city) FROM park")
    suspend fun countDistinctCities(): Int

    // Bài 6: Insert
    @Insert
    suspend fun insertPark(park: CaliforniaPark)

    // Bài 7: Delete
    @Query("DELETE FROM park WHERE name = :name")
    suspend fun deleteByName(name: String)
}

