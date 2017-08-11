package messenger.bot

import javax.inject.Inject

import io.circe.generic.auto._
import messenger.bot.Model.CallPayload
import play.api.libs.circe.Circe
import play.api.mvc._


class MessageHook @Inject()(cc: ControllerComponents,hub:MessageHub) extends AbstractController(cc) with Circe {


  val HUB_MODE: String = "hub.mode"
  val VERIFY_TOKEN: String = "hub.verify_token"
  val CHALLENGE: String = "hub.challenge"
  val APP_SECRET_TOKEN: String = "everybodyiskungfufighting"

  def queryWebHook = Action { request => {

    request.getQueryString(HUB_MODE).getOrElse("") match {
      case "subscribe" => {
        subscribe(request)
      }
      case _ => Unauthorized("missing mode")
    }
  }
  }

  def messageWebHook = Action(circe.tolerantJson[CallPayload]) { implicit request =>{

    val data :CallPayload = request.body
    println("Got: " + request.body.toString)

    hub.process(data)

    Ok("")

  }
  }

  def subscribe(request: Request[AnyContent]): Result = {
    println("challenge " +  request.getQueryString(VERIFY_TOKEN))
    request.getQueryString(VERIFY_TOKEN).filter(token => token.equals(APP_SECRET_TOKEN))
    match {
      case Some(token) => {
        Ok(request.getQueryString(CHALLENGE).get)
      }
      case None => Unauthorized("Missing token")
    }
  }
}
