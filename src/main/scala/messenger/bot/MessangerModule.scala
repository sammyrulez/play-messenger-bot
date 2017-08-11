package messenger.bot

import play.api.{Configuration, Environment}
import play.api.inject.Module

/**
  * Created by sam on 28/02/17.
  */
class MessangerModule extends Module {

  def bindings(environment: Environment,
               configuration: Configuration) = Seq(

    //bind[SenderApi].to[SenderApi].eagerly()
  )

}
