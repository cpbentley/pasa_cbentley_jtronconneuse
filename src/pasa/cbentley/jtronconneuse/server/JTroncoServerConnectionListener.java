package pasa.cbentley.jtronconneuse.server;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import pasa.cbentley.jtronconneuse.common.ILogEntryListener;
import pasa.cbentley.jtronconneuse.common.JSawLogEntry;
import pasa.cbentley.jtronconneuse.ctx.JTroncoCtx;

public class JTroncoServerConnectionListener extends Listener {

   private ILogEntryListener listener;

   protected final JTroncoCtx jtc;
   
   public JTroncoServerConnectionListener(JTroncoCtx jtc) {
      this.jtc = jtc;
   }

   public void setLogEntryListener(ILogEntryListener listener) {
      this.listener = listener;

   }

   /**
    * 
    */
   public void received(Connection c, Object object) {
      JTroncoConnection connection = (JTroncoConnection) c;

      if (object instanceof JSawLogEntry) {
         if (listener != null) {
            listener.newLogEntry((JSawLogEntry) object);
         }
      }
   }

   /**
    * 
    */
   public void disconnected(Connection c) {
      JTroncoConnection connection = (JTroncoConnection) c;
   }
}
