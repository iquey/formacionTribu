package jacg

import scala.collection.mutable.ListBuffer

class Ejercicio1Jacg {
  def readFile(path: String): Unit ={
    var list = new ListBuffer[String]()
    val bufferedSource = io.Source.fromFile(path)
    for (line <- bufferedSource.getLines) {
      val cols = line.split(",").map(_.trim)
      if (cols(3).matches("[0-9]")){
        cols(3).toInt match {
          case 1 => list += "chico"
          case 2 => list += "mediano"
          case 3 => list += "grande"
          case 4 => list += "familiar"
          case _  =>
        }
      }
    }
    bufferedSource.close

    println(list)
  }


  def readFile2(path: String): Unit ={
    val cols = io.Source.fromResource(path).getLines().drop(1).map(_.split(",")).toArray
      var list = new ListBuffer[String]()
    val regex = "[1-4]"
    val lista = cols.filter(x => {(x(3).matches(regex))})

    lista.foreach(x =>{
      x(3).foreach(y => {
        //println(y)
        y.toString.toInt match {
          case 1 => list += "chico"
          case 2 => list += "mediano"
          case 3 => list += "grande"
          case 4 => list += "familiar"
          case _  => print(y)
        }
      })
    })

    val finalList = lista.map(
      x => { x(3).toInt match {
        case 1 => "chico"
        case 2 => "mediano"
        case 3 => "grande"
        case 4 => "familiar"
        case _  =>
      }}
    )
    finalList.foreach(println(_))
    println(list)

  }
}

object Ejercicio extends App {

  val ejercios: Ejercicio1Jacg = new Ejercicio1Jacg()
  //ejercios.readFile("C:\\Users\\w10\\Downloads\\RealEstate.csv")
  ejercios.readFile2("RealEstate.csv")

}