package wc

/**
  * Created by ptg-redmond on 11/2/2016.
  */
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object main {

  val sparkConf = new SparkConf()
    .setMaster("local[*]")
    .setAppName("spark-testing-example")
  val sc = new SparkContext(sparkConf)

  def main(args: Array[String]) {
    val input = sc.parallelize(Seq("this is first line", "this is second line", "this is third line"))
    val countByWordRdd: RDD[(String, Int)] = wordcounter.count(input)
    countByWordRdd.foreach(println)
    change1.a
  }
}
