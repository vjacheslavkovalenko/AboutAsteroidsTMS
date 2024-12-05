package by.vjacheslavkovalenko.aboutasteroidstms.utils

import java.time.LocalDate
import java.time.format.DateTimeFormatter

object DateUtils {

    // Функция для получения стартовой и конечной даты
    fun getStartAndEndDate(): Pair<String, String> {
        // Получаем сегодняшнюю дату
        val startDate = LocalDate.now()

        // Прибавляем 7 дней к сегодняшней дате для конечной даты
        val endDate = startDate.plusDays(7)

        // Форматируем даты в строку в формате "yyyy-MM-dd"
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        return Pair(startDate.format(formatter), endDate.format(formatter))
    }
}