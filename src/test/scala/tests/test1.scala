package tests

/**
  * Created by ptg-redmond on 11/3/2016.
  */

import com.holdenkarau.spark.testing.{RDDComparisons, SharedSparkContext}
import org.apache.spark.rdd.RDD
import org.scalatest.FunSuite
import wc.wordcounter

class test1  extends FunSuite with SharedSparkContext {

  test("RDD comparisions positive test"){
    val text ="Hello Spark " +      "Hello world"
    val inputRdd: RDD[String] = sc.parallelize(List(text))
    val expectedRdd: RDD[(String, Int)] = sc.parallelize(List(("Hello", 2), ("Spark", 1), ("world", 1)))
    val resRdd: RDD[(String, Int)] = wordcounter.count(inputRdd)
    assert(RDDComparisons.compare(resRdd, expectedRdd) isEmpty)

  }


  test("RDD comparisions negative test"){
    val text ="Hello Spark " +   "Hello world"
    val inputRdd: RDD[String] = sc.parallelize(List(text))
    val resRdd: RDD[(String, Int)] = wordcounter.count(inputRdd)

    val wrongRdd: RDD[(String,Int)] = sc.parallelize(List(("Hello",3),("Spark",1), ("world",1)))
    intercept[org.scalatest.exceptions.TestFailedException] {
    assert(RDDComparisons.compare(resRdd, wrongRdd) isEmpty)}

  }

}
