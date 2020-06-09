/*
 *  ============================================================================
 *
 *  Copyright (C) 2006-2017 Talend Inc. - www.talend.com
 *
 *  This source code is available under agreement available at
 *  https://github.com/Talend/data-quality-ee/blob/master/LICENSE
 *
 *  You should have received a copy of the agreement
 *  along with this program; if not, write to Talend SA
 *  9 rue Pages 92150 Suresnes, France
 *
 *  ============================================================================
 */

package org.talend.dataquality.reconciliation.indexing

import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkContext
import org.apache.spark.sql.{SQLContext, SQLImplicits, SparkSession}
import org.scalatest.{BeforeAndAfterAll, Suite}

/**
  * Created by fji on 14/01/16.
  */

trait TestContext extends BeforeAndAfterAll {
  self: Suite =>
  @transient var spark: SparkSession = _
  @transient var sc: SparkContext = _

  private[indexing] object testImplicits extends SQLImplicits {
    protected override def _sqlContext: SQLContext = self.spark.sqlContext
  }

  val testDataPath = "../dataquality-reconciliation-indexing/src/test/resources/"

  Logger.getLogger("org.apache.spark").setLevel(Level.ERROR)
  Logger.getLogger("org.apache.hadoop").setLevel(Level.WARN)
  Logger.getLogger("org.elasticsearch.spark.sql").setLevel(Level.WARN)
  Logger.getLogger("com.sksamuel.elastic4s.http").setLevel(Level.WARN)

  override def beforeAll() {
    super.beforeAll()
    spark = SparkSession.builder
      .master("local[2]")
      .appName("IndexingTest")
      .config("spark.sql.shuffle.partitions", "4") // makes small tests much faster
//      .config("es.index.auto.create", "true")
//      .config("es.batch.size.entries", "5000")
//      .config("es.batch.size.bytes", "15M")
      //.config("spark.es.nodes", "62.210.103.100") // for remote ES
      .getOrCreate()
    //spark.conf.set("spark.sql.shuffle.partitions", 4)
    sc = spark.sparkContext
    sc.setCheckpointDir("../dataquality-reconciliation-spark2/src/test/cpDir/")
  }

  override def afterAll() {
    try {
      SparkSession.clearActiveSession()
      if (spark != null) {
        spark.stop()
      }
      spark = null

    } finally {
      super.afterAll()
    }
  }

}
