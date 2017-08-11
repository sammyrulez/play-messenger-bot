package messenger.bot

import messenger.bot.Model.{CallPayload, Messaging}

/**
  * Created by sam on 09/08/17.
  */
trait MessageHub {


  def process(message:CallPayload):Unit

}
