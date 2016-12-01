package tests

/**
  * Created by ptg-redmond on 11/30/2016.
  */

import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.apache.spark.rdd.RDD
import org.scalatest.FunSuite
import wc.wordcounter

class test2  extends FunSuite with SharedSparkContext {

  test("RDD comparisions positive test"){
    val text ="Hello Spark " +      "Hello world"
    val inputRdd: RDD[String] = sc.parallelize(List(text))
    val expectedRdd: RDD[(String, Int)] = sc.parallelize(List(("Hello", 2), ("Spark", 1), ("world", 1)))
    val resRdd: RDD[(String, Int)] = wordcounter.count(inputRdd)
    assert(RDDComparisons.compare(resRdd, expectedRdd) isEmpty)

  }

}
