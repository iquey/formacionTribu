package jacg

import java.text.Normalizer

class Ejercicio2Jacg {

  def readFile2(path: String): Unit = {
    val cols = io.Source.fromResource(path).getLines().drop(1).map(_.split(" ")).toArray

    val tupleList = cols
      .flatMap(
        row => row.map(
          cell => {
            Normalizer.normalize(cell, Normalizer.Form.NFD)
              .replaceAll("[.!()',¿?/\"]", "")
              .toLowerCase
          })
      )
      .groupBy(w => {w})

    var finalList = scala.collection.mutable.Map[String,Int]()

    tupleList.foreach(
      x =>  finalList += { x._1  -> x._2.length})

    var listaTupla = tupleList.map(tupla => {
      (tupla._1,tupla._2.length)
    })

    println(tupleList)
    println(finalList)
    println(listaTupla)
    println(tupleList.size)

    println(finalList.size)

    println(listaTupla.size)
    println(finalList.maxBy(_._2))
    println(listaTupla.maxBy(_._2))
  }

}

object Cole extends App {

  val ejercios: Ejercicio2Jacg = new Ejercicio2Jacg()
  ejercios.readFile2("cancion.txt")

}
