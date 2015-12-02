package com.my.scala.chapter28

object XMLs {

  def main(args: Array[String]) {

    println(
      <a>
        This is some XML.
        Here is a tag: <atag/>
      </a>
    )

    println(<a> {"Hello" + ", world"} </a>)
    val yearMade = 1955
    println(
      <a> { if (yearMade < 2000) <old>{yearMade}</old>
            else xml.NodeSeq.Empty }
      </a>
    )
    println(<a> {3 + 4} </a>)
    println(<a> {"</a>potential security hole<a>"}</a>)
    println("<a>" + "</a>potential security hole<a>" + "</a>")

    val therm = new CCTherm {
      override val description: String = "hot dog #5"
      override val yearMade: Int = 1952
      override val dateObtained: String = "March 14, 2006"
      override val bookPrice: Int = 2199
      override val purchasePrice: Int = 500
      override val condition: Int = 9
    }
    println(therm.toXML)
    println(<a> {{{{brace yourself!}}}} </a>)

    // Taking XML apart
    // text:
    println(<a>Sounds <tag> good</tag></a>.text)
    println(<a> input ---&gt; out </a>.text)
    // sub-elements:
    println(<a><b><c>hello</c></b></a> \ "b")
    println(<a><b><c>hello</c></b></a> \ "c")
    println(<a><b><c>hello</c></b></a> \\ "c")
    println(<a><b><c>hello</c></b></a> \ "a")
    println(<a><b><c>hello</c></b></a> \\ "a")
    // extracting attributes
    val joe = <employee name="Joe" rank="code monkey" serial="123" />
    println(joe \ "@name")
    println(joe \ "@serial")

    // Deserialization
    val node = therm.toXML
    println(node)
    println(therm.fromXML(node))

    // Loading and saving
    scala.xml.XML.save("therm1.xml", node)
    val loadNode = xml.XML.loadFile("therm1.xml")
    println(loadNode)
    println(therm.fromXML(loadNode))

    // Pattern matching
    def proc(node: scala.xml.Node): String =
      node match {
        case <a>{contents}</a> => "It's an a: " + contents
        case <b>{contents}</b> => "It's a b: " + contents
        case _ => "It's something else."
      }

    println(proc(<a>apple</a>))
    println(proc(<b>banana</b>))
    println(proc(<c>cherry</c>))

    println(proc(<a>a <em>red</em> apple</a>))
    println(proc(<a/>))

    def proc2(node: scala.xml.Node): String =
      node match {
        case <a>{contents @ _*}</a> => "It's an a: " + contents
        case <b>{contents @ _*}</b> => "It's a b: " + contents
        case _ => "It's something else."
      }

    println(proc2(<a>a <em>red</em> apple</a>))
    println(proc2(<a/>))

    val catalog =
      <catalog>
        <cctherm>
          <description>hot dog #5</description>
          <yearMade>1952</yearMade>
          <dateObtained>March 14, 2006</dateObtained>
          <bookPrice>2199</bookPrice>
          <purchasePrice>500</purchasePrice>
          <condition>9</condition>
        </cctherm>
        <cctherm>
          <description>Sprite Boy</description>
          <yearMade>1964</yearMade>
          <dateObtained>April 28, 2003</dateObtained>
          <bookPrice>1695</bookPrice>
          <purchasePrice>595</purchasePrice>
          <condition>5</condition>
        </cctherm>
      </catalog>

    catalog match {
      case <catalog>{therms @ _*}</catalog> =>
        for (therm <- therms)
          println("processing: " + (therm \ "description").text)
    }

    catalog match {
      case <catalog>{therms @ _*}</catalog> =>
        for (therm @ <cctherm>{_*}</cctherm> <- therms)
          println("processing: " + (therm \ "description").text)
    }
  }

  abstract class CCTherm {
    val description: String
    val yearMade: Int
    val dateObtained: String
    val bookPrice: Int       // in US cents
    val purchasePrice: Int   // in US cents
    val condition: Int       // 1 to 10
    override def toString = description

    def toXML =
     <cctherm>
       <description>{description}</description>
       <yearMade>{yearMade}</yearMade>
       <dateObtained>{dateObtained}</dateObtained>
       <bookPrice>{bookPrice}</bookPrice>
       <purchasePrice>{purchasePrice}</purchasePrice>
       <condition>{condition}</condition>
     </cctherm>

    def fromXML(node: scala.xml.Node): CCTherm =
      new CCTherm {
        val description: String = (node \ "description").text
        val yearMade: Int = (node \ "yearMade").text.toInt
        val dateObtained: String = (node \ "dateObtained").text
        val bookPrice: Int = (node \ "bookPrice").text.toInt
        val purchasePrice: Int = (node \ "purchasePrice").text.toInt
        val condition: Int = (node \ "condition").text.toInt
      }
  }
}
