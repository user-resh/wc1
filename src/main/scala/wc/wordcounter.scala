package wc

import org.apache.spark.rdd.RDD

object wordcounter {
  def count(lines: RDD[String]): RDD[(String, Int)] = {
    val wordsCount = lines.flatMap(l => l.split(" "))
      .map(word => (word, 1))
      .reduceByKey(_ + _)
    wordsCount
  }
}
