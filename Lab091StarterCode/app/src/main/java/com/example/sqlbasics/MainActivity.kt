package com.example.sqlbasics

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var dao: CaliforniaParkDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        dao = AppDatabase.getDatabase(applicationContext).californiaParkDao()

        findViewById<Button>(R.id.btnShowAll).setOnClickListener {
            showAllParks()
        }

        findViewById<Button>(R.id.btnTop5Visitors).setOnClickListener {
            loadTop5Visitors()
        }

        findViewById<Button>(R.id.btnCountDistinctCities).setOnClickListener {
            countCities()
        }

        findViewById<Button>(R.id.btnInsertPark).setOnClickListener {
            insertGoogleplex()
        }

        findViewById<Button>(R.id.btnDeletePark).setOnClickListener {
            deleteGoogleplex()
        }
    }

    private fun loadTop5Visitors() {
        lifecycleScope.launch {
            val result = dao.getTop5Visitors()
            tvResult.text = result.joinToString("\n") {
                "${it.name} - ${it.park_visitors}"
            }
        }
    }

    private fun countCities() {
        lifecycleScope.launch {
            val count = dao.countDistinctCities()
            tvResult.text = "Số thành phố khác nhau: $count"
        }
    }

    private fun insertGoogleplex() {
        lifecycleScope.launch {
            dao.insertPark(
                CaliforniaPark(
                    id = 0,
                    name = "Googleplex",
                    city = "Mountain View",
                    acres = 12,
                    visitors = null,
                    established = 0,
                    type = "office"
                )
            )
            tvResult.text = "Đã insert Googleplex"
        }
    }

    private fun deleteGoogleplex() {
        lifecycleScope.launch {
            dao.deleteByName("Googleplex")
            tvResult.text = "Đã xóa Googleplex"
        }
    }

    private fun showAllParks() {
        lifecycleScope.launch {
            val parks = dao.getAll()

            if (parks.isEmpty()) {
                tvResult.text = "Không có bản ghi nào"
                return@launch
            }

            tvResult.text = parks.joinToString("\n\n") { park ->
                """
            ID: ${park.id}
            Name: ${park.name}
            City: ${park.city}
            Area (acres): ${park.acres}
            Visitors: ${park.visitors}
            Established: ${park.established}
            Type: ${park.type}
            """.trimIndent()
            }
        }
    }
}
