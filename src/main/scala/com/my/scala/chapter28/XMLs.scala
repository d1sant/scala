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
  }
}
