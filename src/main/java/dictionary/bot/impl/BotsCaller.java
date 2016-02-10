package dictionary.bot.impl;

import dictionary.bot.Bot;
import dictionary.bot.MessageSubscriber;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Initializing the bot.
 */
public class BotsCaller implements MessageSubscriber {

    public static void main(String[] args) throws XmppStringprepException, SmackException.NotConnectedException, InterruptedException, ClassNotFoundException {
        BotsCaller botsCaller = new BotsCaller();
        Bot.getBot(botsCaller, "uname", "pwd");
        while (true) {
            Thread.sleep(1000000000000L);
        }
    }

    private String errorDefaultText = "Something went wrong";

    @Override
    public String getErrorDefaultText() {
        return errorDefaultText;
    }

    // TODO - Change this method to do something meaningful.
    public String generateReply(Message message) throws UnsupportedEncodingException {
        String body = message.getBody();
        if (body == null) {
            return "Empty Message";
        }
        body = URLDecoder.decode(body, "UTF-8");
        return "Bot says:" + message.getBody();
    }
}
