package pasa.cbentley.jtronconneuse.client;

import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.Client;

import pasa.cbentley.core.src4.logging.BaseAppender;
import pasa.cbentley.core.src4.logging.DLogEntry;
import pasa.cbentley.core.src4.logging.DLogEntryOfConfig;
import pasa.cbentley.core.src4.logging.ITechDLogConfig;
import pasa.cbentley.jtronconneuse.common.ConfigChange;
import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;

/**
 * Appender to use client side.
 * 
 * Config is dynamic, depending on what the server wants.
 * If server does not need timestamp, no need to compute it.
 * If server does not want stack traces..
 * @author Charles Bentley
 *
 */
public class JTronconneuseAppender extends BaseAppender {

   private Client  client;

   private boolean isConnected;

   private JTroncoClientConnectionListener listener;
   public JTronconneuseAppender(JTroncoCtx jtc) {
      super(jtc.getUC());

      listener = new JTroncoClientConnectionListener(jtc);
      
      client = new Client();
      client.start();

      client.addListener(listener);
      Kryo kryo = client.getKryo();

      kryo.register(JSawLogEntry.class);
      kryo.register(ConfigChange.class);
      
      config.setFlagMaster(ITechDLogConfig.MASTER_FLAG_13_TIMESTAMP, true);

   }

   public void connectToServer() {
      try {

         client.connect(5000, "localhost", 54555);
         // Server communication after connection can go here, or in Listener#connected().
         isConnected = true;
      } catch (IOException ex) {
         ex.printStackTrace();
      }
   }

   public void processLogEntry(DLogEntry logEntry) {
      if (isConnected) {
         //convert
         DLogEntryOfConfig entryConfig = config.getEntryConfig(logEntry);
         if(entryConfig.isAccepted()) {
            JSawLogEntry entry = new JSawLogEntry();
            
            entry.setStringable1Line(logEntry.getString1Line());
            entry.setStringableFull(logEntry.getStringFull());
            client.sendTCP(entry);
         }
      }
   }

}
