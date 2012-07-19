package parsecweb

import java.io._
import scala.tools.nsc
import scala.tools.nsc.reporters.ConsoleReporter
import scala.tools.nsc.io.{PlainDirectory, Directory, PlainFile}
//import unfiltered.request._
//import unfiltered.response._

  /*
class FileApp extends unfiltered.filter.Plan {
  
  def intent = {
    case Path(Seg(Nil))                 => uploadView
    case Path(Seg("compile" :: Nil))    => val e = compile; compileView(e)
    //case Params(params)                 => handleUpload(params)
  }

  def uploadView = {
    Html(
      <html>
        <head>
          <title>Upload files</title>
          <link rel="stylesheet" type="text/css" href="/assets/css/app.css"/>
          <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js" type="text/javascript"></script>
          <script src="/assets/js/jquery.html5_upload.js" type="text/javascript"></script>
          <script src="/assets/js/script.js" type="text/javascript"></script>
        </head>
        <body>
          <form method="POST">
            <input type="file" multiple="multiple" name="upload" id="upload_field" />
          </form>
          <div id="progress_report">
            <div id="progress_report_name"></div>
            <div id="progress_report_status" style="font-style: italic;"></div>
            <div id="progress_report_bar_container" style="width: 90%; height: 5px;">
              <div id="progress_report_bar" style="background-color: blue; width: 0; height: 100%;"></div>
            </div>
          </div>
        </body></html>)
  }

  def compile : Option[String] = {

    def createCompiler(out: String): (nsc.Global, nsc.Settings) = {
      val settings = new nsc.Settings()
      settings.classpath.value = System.getProperty("java.class.path")
      val jFile = new java.io.File(out)
      val directory = new Directory(jFile)
      val compDirectory = new PlainDirectory(directory)
      settings.outputDirs.setSingleOutput(compDirectory)
      
      val global = new nsc.Global(settings, new ConsoleReporter(settings))
      (global, settings)
    }
   
    def doCompile(filesToCompile : List[String], dest : String) {
      println("WILL COMPILE: " + filesToCompile.mkString(", "))
      val (comp, settings) = createCompiler(dest)
      val command = new nsc.CompilerCommand(filesToCompile, settings)
      val run = new comp.Run
      run compile command.files
    }

    // Get file handle of original file or directory
    val dir = "/scala/"
    val build = "/build/"
    val orig = new File(dir)
    var error : Option[String] = None

    // Check that directory or file exists
    if (!orig.exists) error = Some(error.getOrElse("") + "Location " + dir + " doesn't exist")
    if (!orig.isDirectory) error = Some(error.getOrElse("") + "<br/>Directory " + dir + " isn't a directory")

    // If exists, set name and file
    var fnames : List[String]  = List()
    var files : List[File]  = List()

    // In case it's a directory, let the file array contain all the files of the directory
    if (orig.isDirectory) {
      files   = orig.listFiles.filter(f => """.*\.scala$""".r.findFirstIn(f.getName).isDefined).toList
      fnames  = files.filter(n => n.getName != ".txt").map(f => dir ++ f.getName)
    }

    // Then compile the files
    doCompile(fnames, build)
    return error
  }

  def compileView(error : Option[String]) = error match {
    case Some(s)        => Html(<html><body><p>{ s }</p></body></html>)
    case _              => Html(
      <html>
      <head><title>Everything is quite nice</title></head>
      <body>
        compiling files
      </body>
      </html>)
  }

}


// unfiltered plan 
class App extends unfiltered.filter.Plan {
  import QParams._


  def intent = {
    case GET(Path(p)) =>
      Ok ~> view(Map.empty)(<p> What say you? </p>)
    case POST(Path(p) & Params(params)) =>
      val vw = view(params)_
      val expected = for {
        int <- lookup("int") is
          int { _ + " is not an integer" } is
          required("missing int")
        word <- lookup("palindrome") is
          trimmed is
          nonempty("Palindrome is empty") is
          pred(palindrome, { _ + " is not a palindrome" }) is
          required("missing palindrome")
      } yield vw(<p>Yup. { int.get } is an integer and { word.get } is a palindrome. </p>)
      expected(params) orFail { fails =>
        vw(<ul> { fails.map { f => <li>{f.error} </li> } } </ul>)
      }
  }
  def palindrome(s: String) = s.toLowerCase.reverse == s.toLowerCase
  def view(params: Map[String, Seq[String]])(body: scala.xml.NodeSeq) = {
    def p(k: String) = params.get(k).flatMap { _.headOption } getOrElse("")
    Html(
     <html>
      <head>
        <title>uf example</title>
        <link rel="stylesheet" type="text/css" href="/assets/css/app.css"/>
      </head>
      <body>
       <div id="container">
       { body }
       <form method="POST">
         <div>Integer <input type="text" name="int" value={ p("int") } /></div>
         <div>Palindrome <input type="text" name="palindrome" value={ p("palindrome") } /></div>
         <input type="submit" />
       </form>
       </div>
     </body>
    </html>
   )
  }
}

// embedded server
object Server {
  def main(args: Array[String]) {
    val http = unfiltered.jetty.Http.anylocal // this will not be necessary in 0.4.0
    http.context("/assets") { _.resources(new java.net.URL(getClass().getResource("/www/"), ".")) }
      .context("/code") { _.resources(new java.net.URL(getClass().getResource("/scala/"), ".")) }
      .filter(new FileApp).run({ svr =>
        unfiltered.util.Browser.open(http.url)
      })
  }
}
  */
object Server {
  def main(args: Array[String]) {
    println("hello world")
  }
}
