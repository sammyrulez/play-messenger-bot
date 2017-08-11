import messenger.bot.{MessageHub, Model}

class MockMessageHub  extends MessageHub{
  override def process(message: Model.CallPayload): Unit = {
    print("processing : \n\t " + message.toString)
  }
}
