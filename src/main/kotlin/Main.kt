fun main() {
 val timeAgo = agoToText(5589) //указываем количество часов
 println(timeAgo)
}
fun agoToText(seconds: Int): String { //функция возвращает строку времени и существительного по падежам
 val minutes = seconds/60 // расчет количество минут в зависимости от кол-ва секунд
 val hours = seconds/360 // расчет количество часов в зависимости от кол-ва секунд
 val mins=minCorrect(minutes)
 val hrs=hourCorrect(hours)

 val text=when (seconds) {
  in 0..60 -> "только что"
  in 61..360 -> "$minutes $mins назад"
  in 361..8640 -> "$hours $hrs назад"
  in 8641..17280 -> "вчера"
  in 17281..25920 -> "позавчера"
  else -> "давно"
 }
 return text
}

fun minCorrect(minutes:Int): String{ ////функция коррекции окончания слова минута
 val minEnding=when (minutes){
  1, 21, 31, 41, 51 -> "минуту"
  in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "минуты"
  else -> "минут"
 }
 return minEnding
}

fun hourCorrect(hours:Int): String{ //функция коррекции окончания слова час
 val hourEnding=when (hours){
  1,21 -> "час"
  2, 3, 4, 22, 23, 24 -> "часа"
  else -> "часов"
 }
 return hourEnding
}