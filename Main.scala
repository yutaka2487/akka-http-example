import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._

object Main extends App {

  implicit val actorStream = ActorSystem()
  implicit val actorMaterializer = ActorMaterializer()

  val route =
    pathSingleSlash {
      get {
        complete {
          "Hello World"
        }
      }
    }

  Http().bindAndHandle(route, "localhost", 8080)
}
