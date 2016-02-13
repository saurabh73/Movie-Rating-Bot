package loveCalculator.bot.impl;
/**
 * @author saurabh dutta
 *
 */
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.packet.Message;
import org.json.JSONObject;
import org.jxmpp.stringprep.XmppStringprepException;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import loveCalculator.bot.Bot;
import loveCalculator.bot.MessageSubscriber;

/**
 * Initializing the bot.
 */

public class BotsCaller implements MessageSubscriber {

    public static void main(String[] args) throws XmppStringprepException, SmackException.NotConnectedException, InterruptedException, ClassNotFoundException {
        BotsCaller botsCaller = new BotsCaller();
        Bot.getBot(botsCaller, BotCredentials.botUsername, BotCredentials.botPassword);
        while (true) {
            Thread.sleep(1000000000000L);
        }
    }

    @Override
    public String getErrorDefaultText() {
        return BotMessages.DEFAULT_ERROR;
    }

    
    public String generateReply(Message message) throws UnsupportedEncodingException {
        String body = message.getBody();
        if (body == null) {
            return BotMessages.EMPTY_BODY;
        }
        body = URLDecoder.decode(body, "UTF-8").toLowerCase().trim().replaceAll(" +", " ");
      
        return BotReply.getBotReply(body);
    }
}
