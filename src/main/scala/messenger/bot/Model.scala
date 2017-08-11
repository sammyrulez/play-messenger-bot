package messenger.bot


object Model {

  case class TargetEntity(id: String)

  case class Messaging(sender: TargetEntity, recipient: TargetEntity,timestamp:Long, message: Option[MessageContent])

  case class Entry(id: String, time: Long, messaging: List[Messaging])

  case class CallPayload(`object`:String,entry: List[Entry])

  case class MessageContent(mid:String,seq:Long,text: Option[String],attachments:Option[List[Attachment]])

  case class Attachment(title:String,url:String)

  case class TextMessage(recipient:TargetEntity, message: OutMessageBody)

  case class OutMessageBody(text: String)

  object TextMessage {
    def apply(recipient:String,message: String): TextMessage = new TextMessage(new TargetEntity(recipient),new OutMessageBody(message))
  }
/*
  recipient: {
    id: recipientId
  },
  message: {
    text: messageText
  }

*/
}