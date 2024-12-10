package by.vjacheslavkovalenko.aboutasteroidstms.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {

    fun getStartAndEndDate(): Pair<String, String> {
        val startDate = LocalDate.now()

        val endDate = startDate.plusDays(4)

        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        return Pair(startDate.format(formatter), endDate.format(formatter))
    }
}