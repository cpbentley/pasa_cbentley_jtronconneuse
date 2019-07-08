package pasa.cbentley.jtronconneuse.server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Server;

import pasa.cbentley.jtronconneuse.common.ConfigChange;
import pasa.cbentley.jtronconneuse.common.ILogEntryListener;
import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;

public class JTroncoServer extends Server {

   protected final JTroncoCtx        jtc;

   private JTroncoServerConnectionListener jtroncoConnectionListener;

   public JTroncoServer(JTroncoCtx jtc) {
      this.jtc = jtc;

      //register
      this.getKryo().register(JSawLogEntry.class);
      this.getKryo().register(ConfigChange.class);

      jtroncoConnectionListener = new JTroncoServerConnectionListener(jtc);
      try {
         this.addListener(jtroncoConnectionListener);
         this.bind(jtc.getPort());
         this.start();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void setLogEntryListener(ILogEntryListener listener) {
      this.jtroncoConnectionListener.setLogEntryListener(listener);
   }

   protected Connection newConnection() {
      //no name ?
      return new JTroncoConnection(jtc, this, "");
   }
}
