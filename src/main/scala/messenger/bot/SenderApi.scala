package messenger.bot

import javax.inject.Inject

import messenger.bot.Model.TextMessage
import play.api.Configuration
import play.api.libs.ws._
import io.circe._, io.circe.generic.auto._, io.circe.parser._, io.circe.syntax._
import scala.concurrent.Future

/**
  * Created by sam on 28/02/17.
  */
class SenderApi @Inject()(  config:Configuration, wSClient:WSClient) {



  def sendMessage(sender:String,text:String) = {



    import scala.concurrent.ExecutionContext.Implicits.global


    // TODO
    val accessToken = config.getString("access_token") getOrElse ""


   val message =  TextMessage(sender,text).asJson.noSpaces
    /*
    val data = Map(
      "recipient" -> Map("id" -> sender ),
      "message" -> Map("text" -> text )
    )*/



    wSClient.url("https://graph.facebook.com/v2.6/me/messages").withQueryStringParameters(("access_token" , accessToken) ,("debug" , "all"))
        .post(message).map {
      response =>

        println( response.body)
    }


  }

}
