package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import javax.inject._
import play.api.mvc._

/*Adding to the db API*/
import play.api.db._

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class HomeController @Inject()(db:Database,val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Create an Action to render an HTML page.
   *
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */


  /** establishing the db connection in order to execute queries */
  val connection = db.getConnection()
  val statement = connection.createStatement
  val query = "SELECT * FROM members"
  val resultset = statement.executeQuery(query)



  var i = 0
  var indexNoArray = new Array[Int](5)
  var regnoArray = new Array[String](5)
  var usernameArray = new Array[String](5)
  var teleNoArray = new Array[Int](5)

  while(resultset.next()){
    indexNoArray(i) = resultset.getInt("Index No")
    regnoArray(i) = resultset.getString("Register No")
    usernameArray(i) = resultset.getString("Student Name")
    teleNoArray(i) = resultset.getInt("Telephone No")
    i = i + 1
  }



  /**This is a main home function that passes the data associated within the arrays to the home.scala.html*/
  def display = Action {
    Ok(views.html.memberdetails(
      indexNoArray(0),indexNoArray(1),indexNoArray(2),indexNoArray(3),
      regnoArray(0),regnoArray(1),regnoArray(2),regnoArray(3),
      usernameArray(0), usernameArray(1),usernameArray(2),usernameArray(3),
      teleNoArray(0),teleNoArray(1),teleNoArray(2),teleNoArray(3)
    ))
  }


}
