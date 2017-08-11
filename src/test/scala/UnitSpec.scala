import akka.actor.ActorSystem
import messenger.bot.{MessageHook, SenderApi}
import org.scalatest.easymock.EasyMockSugar.MockObjects
import org.scalatestplus.play._
import play.api.Configuration
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WsTestClient}
import play.api.libs.ws.ahc.StandaloneAhcWSClient
import play.api.libs.ws._
import play.api.test.WsTestClient.InternalWSClient

import scala.concurrent.Await

/**
 * Unit tests can run without a full Play application.
 */
class UnitSpec extends PlaySpec {

  val config: play.api.Configuration = Configuration()

  val client:WSClient =  new InternalWSClient("http",80)

  "SenderApi" should {

    "send a message" in {

      val senderApi = new SenderApi(config,client)
      senderApi.sendMessage("me","hello")

    }
  }

  "Message hook" should {

    val hook = new MessageHook(stubControllerComponents(),new MockMessageHub)

    "accept a challenge " in {
         hook.queryWebHook(FakeRequest())
    }

    " receive a message" in {
        hook.messageWebHook(FakeRequest())
    }

  }



}
