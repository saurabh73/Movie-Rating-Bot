package movieInfo.bot;

import org.jivesoftware.smack.packet.Message;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by harshit on 30/1/16.
 */
public interface MessageSubscriber {
    /**
     * @return String
     * This text is shown when {@link #generateReply(Message)} message throws exception.
     */
    String getErrorDefaultText();

    /**
     *
     * @param message
     * @return String
     * This function takes the input message,
     * makes the computation and return the relevant reply.
     */
    String generateReply(Message message) throws UnsupportedEncodingException;
}
